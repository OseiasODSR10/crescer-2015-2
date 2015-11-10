using Locadora.Dominio;
using Locadora.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            JogoRepositorio bd = new JogoRepositorio();

            Jogo jogo = new Jogo(1, null)
            {
                Nome = "oseias",
                Descricao = "chato",
                Preco = 200,
                Categoria = Categoria.RPG,
                Selo = Selo.OURO,
            };

            bd.Excluir(jogo.Id);
        }
    }
}
