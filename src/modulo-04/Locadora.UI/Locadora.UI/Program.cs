using Locadora.Dominio;
using System;
using System.Linq;

namespace Locadora.UI
{
    public class Program
    {
        static void Main(string[] args)
        {
            LocadoraNunes loc = new LocadoraNunes();
            var jogos = loc.BuscarJogoPorNome("Top Gear");

            Console.WriteLine(jogos.Count());
            Console.WriteLine(jogos[0].Nome);
            Console.ReadKey();

            Jogo jogo = new Jogo("Jogos Test", 333, Categoria.ESPORTE);
            loc.CadastrarJogo(jogo);

            jogos = loc.BuscarJogoPorNome("Jogo Test");
            Console.WriteLine(jogos.Count);

            Console.ReadKey();
        }
    }
}
