using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace urna
{
    public interface IRepositorio<T>
    {
        T BuscarPorId(int id);

        //TODO: não é tipo, é entidade.
        void Cadastrar(T tipo);

        //TODO: qual a diferença de Atualizar e AtualizarPorId? se Atualizar atualiza todos, deve ser AtualizarTodos()
        void Atualizar(T tipo);

        void AtualizarPorId(int id, T tipo);

    }
}
