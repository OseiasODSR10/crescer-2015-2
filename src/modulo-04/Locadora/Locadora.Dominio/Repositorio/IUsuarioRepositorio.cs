using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarPorEmail(string email);
        IList<Usuario> BuscarTodos();
        int Criar(Usuario user);
        int Atualizar(Usuario user);
        int Excluir(int id);
        Usuario BuscarPorId(int id);
    }
}
