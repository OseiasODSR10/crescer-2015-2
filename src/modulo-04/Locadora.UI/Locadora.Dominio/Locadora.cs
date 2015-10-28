using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class LocadoraOR
    {
        public string caminhoArquivo { get; private set; }

        public LocadoraOR()
        {
            caminhoArquivo = @"C:\Users\oseias.rodrigues\Documents\crescer-2015-2\src\modulo-04\Locadora.UI\Locadora.UI\game_store.xml";

        }

        public IList<Jogo> buscarJogoPorNome(string nome)
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

        

    }
}
