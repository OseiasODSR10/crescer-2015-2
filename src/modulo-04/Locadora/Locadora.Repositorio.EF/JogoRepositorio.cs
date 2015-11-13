using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio :  IJogoRepositorio
    {

        public int Atualizar(Jogo jogo)
        {
            using(var db = new BancoDeDadosCF())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using(var db = new BancoDeDadosCF())
            {
                Jogo jogo = db.Jogo.Include("Selo").First(j => j.Id == id);
                return jogo;
            }            
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using(var db = new BancoDeDadosCF())
            {
                return db.Jogo.Include("Selo").Where(j => j.Nome.ToUpper().Contains(nome.ToUpper())).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new BancoDeDadosCF())
            {
                return db.Jogo.Include("Selo").ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using(var db = new BancoDeDadosCF())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();                
            }
        }

        public int Excluir(int id)
        {
            using(var db = new BancoDeDadosCF())
            {
                Jogo jogo = db.Jogo.Find(id);
                db.Entry(jogo).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
