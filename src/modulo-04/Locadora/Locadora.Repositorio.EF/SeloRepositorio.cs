using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class SeloRepositorio
    {

        public Selo BuscarPorId(int id)
        {
            using (var db = new BancoDeDadosCF())
            {
                Selo selo = db.Selo.Find(id);
                return selo;
            }
        }
    }
}
