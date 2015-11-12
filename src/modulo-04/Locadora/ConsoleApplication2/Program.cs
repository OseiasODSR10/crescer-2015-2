using Locadora.Dominio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Seguranca;
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
            BancoDeDadosCF bdAll = new BancoDeDadosCF();
            Selo oselo;

            using (var db = new BancoDeDadosCF())
            {
                oselo = db.Selo.Find(1);
            }
            Jogo jogo = new Jogo()
            {
                Nome = "oseias",
                Categoria = Categoria.AVENTURA,
                Descricao = "Um jogo",
                Imagem = "ssa",
                Selo = oselo,
                Video = "cbdksc"
            };
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
                Console.Read();
            }
            
            
        }
    }
}
