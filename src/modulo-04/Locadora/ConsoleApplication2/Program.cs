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
            Cliente cliente = new Cliente()
            {
                Nome = "Oséias"
            };
            Cliente cliente2 = new Cliente()
            {
                Nome = "André"
            };

            using (var db = new BancoDeDadosCF())
            {
                db.Entry(cliente).State = System.Data.Entity.EntityState.Added;
                db.Entry(cliente2).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
                Console.Read();
            }


            /*
            Selo oselo;
            
            using (var db = new BancoDeDadosCF())
            {
                oselo = db.Selo.Find(1);
            }
            oselo = new Selo(1) { Nome = "Ouro", Prazo = 1, Preco=15 };
            Jogo jogo = new Jogo()
            {
                Nome = "oseias",
                Categoria = Categoria.AVENTURA,
                Descricao = "Um jogo legal sem duplicar",
                Imagem = "ssa",
                IdSelo = oselo.Id,
                Video = "cbdksc"
            };
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
                Console.Read();
            }
            */
            /*
            Usuario user = new Usuario()
            {
                NomeCompleto = "Oséias Daniel Soares Rodrigues",
                Email = "oseias.rodrigues@cwi.com.br",
                Senha = new ServicoCriptografia().CriptografarSenha("oss")
            };

            Permissao permissao = new Permissao() { Nome = "ADMIN" };

            using (var db = new BancoDeDadosCF())
            {
                db.Entry(permissao).State = System.Data.Entity.EntityState.Added;
                db.Entry(user).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
                permissao.Usuarios.Add(user);
                user.Permissoes.Add(permissao);
                db.Entry(permissao).State = System.Data.Entity.EntityState.Modified;
                db.Entry(user).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
                Console.Read();
            }
            */
        }
    }
}
