using Locadora.Dominio;
using Locadora.Repositorio.EF.DbFirst;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var db = new BancoDeDados())
            {
                Jogo jogo = db.Jogo.First(j => j.Id == 1);

                Console.ReadLine();
            }

        }
    }
}
