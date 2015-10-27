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
            var agenda = new Agenda();
            string x = "";
            while(!(x.Equals("-1")))
            {
                Console.Clear();
                Console.WriteLine("Digite a operação\n"
                    +"1 - Adicionar Novo Contato\n"
                    +"2 - Remover contato por nome\n"
                    +"3 - Remover contato por numero\n"
                    +"4 - Listar contatos\n"
                    +"5 - Listar contatos ordenados por nome\n");

                x = Console.ReadLine();
                switch (x)
                {
                    case "1":
                        Console.Clear();
                        Console.WriteLine("Digite o nome do contato");
                        var nome = Console.ReadLine();
                        var numero = Console.ReadLine();
                        var contato = new Contato(nome, numero);
                        agenda.AdicionarContato(contato);
                        Console.WriteLine("Contato adicionado!");
                        break;
                    case "2":
                        Console.Clear();
                        Console.WriteLine("Digite o nome do contato");
                        var nome2 = Console.ReadLine();
                        agenda.RemoverContatoPorNome(nome2);
                        Console.WriteLine("Contato removido!");
                        break;
                    case "3":
                        Console.Clear();
                        Console.WriteLine("Digite o numero do contato");
                        var numero2 = Console.ReadLine();
                        agenda.RemoverContatoPorNumero(numero2);
                        Console.WriteLine("Contato removido!");
                        break;
                    case "4":
                        Console.Clear();
                        Console.WriteLine("Listando contatos...");
                        Console.WriteLine(agenda.ListarContatosO());
                        Console.WriteLine("Aperte qualquer tecla para sair:");
                        Console.ReadKey();
                        break;
                    case "5":
                        Console.Clear();
                        Console.WriteLine("Listando contatos ordenados por nome...");
                        Console.WriteLine(agenda.listarContatosOrdenadosPorNome());
                        Console.WriteLine("Aperte qualquer tecla para sair:");
                        Console.ReadKey();
                        break; 
                    default: Console.WriteLine("Saindo..."); break;
                }
            }
        }
    }
}
