using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class LocacaoRepositorio : ILocacaoRepositorio
    {
        public int Atualizar(Locacao locacao)
        {
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public IList<Locacao> BuscarLocacaoPorCliente(Cliente cliente)
        {
            using (var db = new BancoDeDadosCF())
            {
                return db.Locacao.Where(c => c.Id == cliente.Id).ToList();
            }
        }

        public IList<Locacao> BuscarLocacaoPorJogo(Jogo jogo)
        {
            using (var db = new BancoDeDadosCF())
            {
                return db.Locacao.Where(j => j.Id == jogo.Id).ToList();
            }
        }

        public int Criar(Locacao locacao)
        {
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }
    }
}
