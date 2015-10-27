using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    //sealed == final (java)
    public abstract class Robo
    {
        public string Nome { get; private set; }
        public int Municao { get; private set; }

        public Robo(string nome)
        {
            this.Nome = nome;
        }

        public virtual void Atacar()
        {
            Console.WriteLine("Atacou...");
        }

        internal void DebitarMunicao()
        {
            this.Municao--;
        }

        protected abstract void Defender();
    }
}
