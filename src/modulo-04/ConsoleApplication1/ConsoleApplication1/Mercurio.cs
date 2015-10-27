using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Mercurio : Robo, IVoar
    {
        public int Idade { get; set; }

        public Mercurio(string nome, int idade) : base(nome)
        {
            this.Idade = idade;
        }

        public override void Atacar()
        {
            Console.WriteLine("atacando 2....");
            DebitarMunicao();
        }
        protected override void Defender()
        {
            Console.WriteLine("Defendendo...");
        }

        public void Avoar()
        {
            Console.WriteLine("avoando");
        }

        public void ExplodeiaTudo()
        {
            Console.WriteLine("explodiando tudo");
        }
    }
}
