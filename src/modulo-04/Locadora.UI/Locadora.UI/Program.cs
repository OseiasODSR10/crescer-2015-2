using Locadora.Dominio;
using System;
using System.Linq;

namespace Locadora.UI
{
    public class Program
    {
        static void Main(string[] args)
        {
            ULocadora locadoraNunes = new ULocadora("Locadora Nunes Games");
            Program prog = new Program();
            bool continuar = true;

            while (continuar)
            {
                continuar = prog.menu(locadoraNunes);
            }
            

        }

        public bool menu(ULocadora locadora)
        {
            int escolha = -1;
            Console.WriteLine(string.Format("{0, 50}", "Menu"));
            Console.WriteLine(string.Format("{0, 65}", "Digite o Numero da opção desejada:"));
            Console.WriteLine("1 - Buscar um jogo por nome");
            Console.WriteLine("2 - Editar um jogo");
            Console.WriteLine("3 - Cadastrar um novo jogo");
            Console.WriteLine("4 - Exportar um relatório");
            Console.WriteLine("0 - Finalizar programa");

            while (!(0<=escolha && escolha<=5))
            {
                Console.WriteLine("\r\nDigite uma opção válida:");
                try
                {
                    escolha = int.Parse(Console.ReadLine());
                }catch
                {
                    Console.WriteLine("Erro: digite um número");
                }
            }

            switch (escolha)
            {
                case 1: BuscarjogoPorNome(locadora);
                    break;
                case 2: EditarUmJogo(locadora);
                    break;
                case 3: CadastrarUmJogo(locadora);
                    break;
                case 4: ExportarRelatorio(locadora);
                    break;
                case 5:
                    break;
                case 0:
                    return false;
            }
            Console.Clear();
            return true;
        }

        public void BuscarjogoPorNome(ULocadora locadora)
        {
            Console.Clear();
            Console.WriteLine("Digite o nome do jogo que você deseja buscar:");
            string nomeDoJogo = Console.ReadLine();
            if (nomeDoJogo.Length==0)
            {
                Console.WriteLine("Erro: Você não digitou nada");
                Console.WriteLine("Aperte enter para prosseguir");
                Console.ReadLine();
            }
            else
            {
                var jogos = locadora.BuscarJogoPorNome(nomeDoJogo);
                Console.WriteLine(string.Format("{0, -9}{1, -20}{2, -30}{3, -5}{4, 16}", "ID", "Categoria", "Nome", "Preco", "Disponivel"));
                foreach (Jogo jogo in jogos)
                {
                    Console.WriteLine(jogo);
                }
            }
            Console.WriteLine("Operação completada com sucesso!");
            Console.WriteLine("Aperte enter para prosseguir");
            Console.ReadLine();
        }

        public void EditarUmJogo(ULocadora locadora)
        {
            Console.Clear();
            Console.WriteLine("Digite o ID do jogo que você deseja editar:");
            int idDoJogo;
            try
            {
                idDoJogo = int.Parse(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("Erro: Este ID é inválido");
                Console.WriteLine("Aperte enter para prosseguir");
                Console.ReadLine();
                return;
            }
            Jogo jogoAntigo = locadora.BuscarJogoPorID(idDoJogo);
            try
            {
                Console.WriteLine("Digite o novo nome do jogo:");
                string novoNome = Console.ReadLine();
                Console.WriteLine("Digite o novo preço do jogo:");
                double novoPreco = double.Parse(Console.ReadLine());
                Console.WriteLine("Digite a nova categoria do jogo:");
                Console.WriteLine("Categorias Válidas: RPG, CORRIDA, AVENTURA, LUTA, ESPORTE, DESCONHECIDO");
                string categoria = Console.ReadLine();
                Categoria categoriaNova = (Categoria)Enum.Parse(typeof(Categoria), categoria);
                locadora.EditarJogo(jogoAntigo, novoNome, novoPreco, categoriaNova);
                Console.WriteLine("Operação completada com sucesso!");
                Console.WriteLine("Aperte enter para prosseguir");
                Console.ReadLine();
            }
            catch
            {
                Console.WriteLine("Erro durante a operação\r\nAperte enter para continuar");
                Console.ReadLine();
            }
        }

        public void CadastrarUmJogo(ULocadora locadora)
        {
            try
            {
                Console.Clear();
                Console.Write("Digite o nome do Jogo que quer Cadastrar:");
                string nome = Console.ReadLine();
                Console.Write("Digite o preco do Jogo que quer Cadastrar:");
                double preco = double.Parse(Console.ReadLine());
                Console.WriteLine("Digite a categoria do Jogo que quer Cadastrar:");
                Console.WriteLine("Categorias Válidas: RPG, CORRIDA, AVENTURA, LUTA, ESPORTE, DESCONHECIDO");
                Categoria categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine());
                Jogo jogoCadastrar = new Jogo(nome, preco, categoria);
                locadora.CadastrarNovoJogo(jogoCadastrar);
                Console.WriteLine("Operação completada com sucesso!");
                Console.WriteLine("Aperte enter para prosseguir");
                Console.ReadLine();
            }
            catch
            {
                Console.WriteLine("Erro durante a operação\r\nAperte enter para continuar");
                Console.ReadLine();
            }
        }

        public void ExportarRelatorio(ULocadora locadora)
        {
            locadora.ExportarRelatorio();
            Console.WriteLine("Operação completada com sucesso!");
            Console.WriteLine("Aperte enter para prosseguir");
            Console.ReadLine();
        }
    }
}
