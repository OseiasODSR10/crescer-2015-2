using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var contato1 = new Contato()
            {
                Nome = "Oseias",
                Numero = 23456433
            };

            var contato2 = new Contato()
            {
                Nome = "Ben Hur",
                Numero = 666
            };
            var contato3 = new Contato()
            {
                Nome = "Ben Hur",
                Numero = 666
            };

            var agenda = new Agenda();
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            agenda.ListarContatos();

            System.Console.WriteLine("Após a remoção: ");

            agenda.RemoverContato("Ben Hur");

            agenda.ListarContatos();

        }
    }
}
