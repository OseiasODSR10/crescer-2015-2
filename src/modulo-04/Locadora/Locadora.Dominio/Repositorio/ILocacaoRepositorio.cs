using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface ILocacaoRepositorio
    {
        IList<Locacao> BuscarLocacaoPorCliente(Cliente cliente);
        IList<Locacao> BuscarLocacaoPorJogo(Jogo jogo);
        int Criar(Locacao locacao);
        int Atualizar(Locacao locacao);
    }
}
