using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class JogoRepositorio
    {
        public string caminhoArquivo { get; private set; }

        public JogoRepositorio()
        {
            caminhoArquivo = @"C:\Users\oseias.rodrigues\Documents\crescer-2015-2\src\modulo-04\Locadora.UI\Locadora.UI\game_store.xml";

        }

        public List<Jogo> BuscarJogoPorNome(string nome)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            List<Jogo> jogos = new List<Jogo>();

            foreach (XElement jogo in xmlJogos.Elements("jogo"))
            {
                nome = nome.ToUpper();
                string nomeDoJogo = jogo.Element("nome").Value;
                if(nomeDoJogo.ToUpper().Contains(nome)                                 )            
                {
                    double precoDoJogo = double.Parse(jogo.Element("preco").Value);
                    string valor = jogo.Element("categoria").Value;
                    Categoria categoriaDoJogo = (Categoria)Enum.Parse(typeof(Categoria), valor);
                    int id = int.Parse(jogo.Attribute("id").Value);

                    jogos.Add(new Jogo(nomeDoJogo, precoDoJogo, categoriaDoJogo)
                    {
                        Id = id,
                        StatusDisponivel = "sim"
                    });
                }
            }
            return jogos;
        }

        public Jogo BuscarJogoPorID(int id)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogosXml = xmlJogos.Elements("jogo").ToList();
            var query = from jog in jogosXml
                        where int.Parse(jog.Attribute("id").Value) == id
                        select new Jogo
                        (
                            jog.Element("nome").Value,
                            double.Parse(jog.Element("preco").Value),
                            (Categoria)Enum.Parse(typeof(Categoria), jog.Element("categoria").Value)
                        )
                        {
                            Id = int.Parse(jog.Attribute("id").Value),
                            StatusDisponivel = "sim"
                        };
            return query.First();
        }

        public void CadastrarJogo (Jogo jogo)
        {
            var baseDeJogos = XElement.Load(caminhoArquivo);
            XElement nome = new XElement("nome", jogo.Nome);
            XElement preco = new XElement("preco", jogo.Preco);
            XElement categoria = new XElement("categoria", jogo.Categoria);
            int ultimoid = int.Parse(baseDeJogos.Elements("jogo").Last().Attribute("id").Value);
            XAttribute id = new XAttribute("id", (ultimoid + 1));
            XElement jogoParaSalvar = new XElement("jogo", id, nome, preco, categoria);
            
            baseDeJogos.Add(jogoParaSalvar);
            baseDeJogos.Save(caminhoArquivo);
        }

        public void EditarJogo(Jogo jogo)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            XElement jogoAntigo = xmlJogos.Elements("jogo").First(j => int.Parse(j.Attribute("id").Value) == jogo.Id);
            jogoAntigo.SetElementValue("nome", jogo.Nome);
            jogoAntigo.SetElementValue("preco", jogo.Preco);
            jogoAntigo.SetElementValue("categoria", jogo.Categoria);
            xmlJogos.Save(caminhoArquivo);
        }
        
        public List<Jogo> ListarJogos()
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            var jogosXml = xmlJogos.Elements("jogo").ToList();
            var jogos = from j in jogosXml
                               select new
                               Jogo(
                                    j.Element("nome").Value,
                                    double.Parse(j.Element("preco").Value),
                                    (Categoria)Enum.Parse(typeof(Categoria), j.Element("categoria").Value)
                                )
                               {
                                   Id = int.Parse(j.Attribute("id").Value),
                                   StatusDisponivel = "sim"
                               };
            return jogos.ToList();
        }
        
    }
}
