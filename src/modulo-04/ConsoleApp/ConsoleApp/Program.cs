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
                Console.WriteLine("Digite a operação\n"
                    +"1 - Adicionar Novo Contato\n"
                    +"2 - Remover contato por nome\n"
                    +"3 - Remover contato por numero\n"
                    +"4 - Listar contatos\n"
                    +"5 - Listar contatos ordenados por nome\n"
                    +"6 - Limpar tela");

                x = Console.ReadLine();
                switch (x)
                {
                    case "1":
                        Console.WriteLine("Digite o nome do contato");
                        var nome = Console.ReadLine();
                        var numero = Console.ReadLine();
                        var contato = new Contato(nome, numero);
                        agenda.AdicionarContato(contato);
                        Console.WriteLine("Contato adicionado!");
                        break;
                    case "2":
                        Console.WriteLine("Digite o nome do contato");
                        var nome2 = Console.ReadLine();
                        agenda.RemoverContatoPorNome(nome2);
                        Console.WriteLine("Contato removido!");
                        break;
                    case "3":
                        Console.WriteLine("Digite o numero do contato");
                        var numero2 = Console.ReadLine();
                        agenda.RemoverContatoPorNumero(numero2);
                        Console.WriteLine("Contato removido!");
                        break;
                    case "4":
                        Console.WriteLine("Listando contatos...");
                        Console.WriteLine(agenda.ListarContatosO());
                        break;
                    case "5": 
                        Console.WriteLine("Listando contatos ordenados por nome...");
                        Console.WriteLine(agenda.listarContatosOrdenadosPorNome());
                        break;
                    case "6":
                        Console.Clear();
                        break;  
                    default: Console.WriteLine("Saindo..."); break;
                }
            }
        }
    }
}
