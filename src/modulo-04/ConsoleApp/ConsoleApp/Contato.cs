using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Contato
    {
        public string Nome { get; set; }
        public string Numero { get; set; }

        public Contato(string nome, string numero)
        {
            Nome = nome;
            Numero = numero;
        }
    }

    
}
