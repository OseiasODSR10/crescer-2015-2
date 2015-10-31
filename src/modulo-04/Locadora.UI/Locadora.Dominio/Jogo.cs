using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public string Nome { get; set; }
        public double Preco { get; set; }
        public int Id { get; set; }
        public Categoria Categoria { get; set; }
        public string StatusDisponivel { get; set; }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        public override string ToString()
        {
            return string.Format("{0, -9}{1, -20}{2, -30}{3, -5}{4, 16}",
                Id, Categoria, Nome, Preco, StatusDisponivel);
        }
    }
}
