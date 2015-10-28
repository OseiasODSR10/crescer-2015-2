using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    public class Program
    {
        static void Main(string[] args)
        {
            LocadoraOR loc = new LocadoraOR();
            var jogos = loc.buscarJogoPorNome("Top Gear");

            Console.WriteLine(jogos.Count());
            Console.WriteLine(jogos[0].Nome);
            Console.ReadKey();
        }
    }
}
