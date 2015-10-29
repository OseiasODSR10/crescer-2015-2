using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class LocadoraNunes
    {
        public string caminhoArquivo { get; private set; }
        public string caminhoArquivo2Teste { get; private set; }

        public LocadoraNunes()
        {
            caminhoArquivo = @"C:\Users\Usuario\Documents\crescer-2015-2\src\modulo-04\Locadora.UI\Locadora.UI\game_store.xml";

        }

        public IList<Jogo> BuscarJogoPorNome(string nome)
        {
            XElement xmlJogos = XElement.Load(caminhoArquivo);
            List<Jogo> jogos = new List<Jogo>();

            foreach (XElement jogo in xmlJogos.Elements("jogo"))
            {
                string nomeDoJogo = jogo.Element("nome").Value;
                if(nomeDoJogo.ToUpper().Equals(nome.ToUpper()))
                {
                    double precoDoJogo = double.Parse(jogo.Element("preco").Value);
                    string valor = jogo.Element("categoria").Value;
                    Categoria categoriaDoJogo = (Categoria)Enum.Parse(typeof(Categoria), valor);

                    jogos.Add(new Jogo(nomeDoJogo, precoDoJogo, categoriaDoJogo));
                }
            }
            return jogos;
        }

        public void CadastrarJogo (Jogo jogo)
        {
            caminhoArquivo2Teste = @"C:\Users\Usuario\Documents\crescer-2015-2\src\modulo-04\Locadora.UI\Locadora.UI\game_store2.xml";
            var baseDeJogos = XDocument.Load(caminhoArquivo2Teste);
            XElement nome = new XElement("nome", jogo.Nome);
            XElement preco = new XElement("preco", jogo.Preco);
            XElement categoria = new XElement("categoria", jogo.Categoria);
            XElement jogoParaSalvar = new XElement("jogo", nome, preco, categoria);
            baseDeJogos.Root.Add(jogoParaSalvar);
            baseDeJogos.Save(caminhoArquivo2Teste);
        }



    }
}
