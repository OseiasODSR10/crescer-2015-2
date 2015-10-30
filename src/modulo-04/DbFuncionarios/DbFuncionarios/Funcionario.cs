using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Funcionario
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public TurnoTrabalho TurnoTrabalho { get; set; }
        public Cargo Cargo { get; set; }

        public Funcionario(int id, string nome, DateTime dataNascimento)
        {
            this.Id = id;
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
        }

        public override bool Equals(object obj)
        {
            var funcionario2 = (Funcionario)obj;
            return Nome.Equals(funcionario2.Nome)
                && DataNascimento.Equals(funcionario2.DataNascimento)
                && TurnoTrabalho.Equals(funcionario2.TurnoTrabalho)
                && Cargo.Equals(funcionario2.Cargo)
                && Id.Equals(funcionario2.Id);
        }
    }
}