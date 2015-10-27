using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Mercurio m = new Mercurio("mmm", 18);
            m.Atacar();
            m.Avoar();
            m.DebitarMunicao();

            Console.ReadLine();
        }
    }
}
