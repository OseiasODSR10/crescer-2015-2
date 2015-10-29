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
        public int Id { get; private set; }
        public Categoria Categoria { get; set; }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        
    }
}
