using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace urna
{
    public class Partido
    {
        //TODO: por que public get?
        public int IdPartido { get; set; }
        public string Nome { get; set; }
        public string Slogan { get; set; }
        public string Sigla { get; set; }

        //TODO: não é necessário construtor para public set.
        public Partido (string nome, string slogan, string sigla)
        {
            Nome = nome;
            Slogan = slogan;
            Sigla = sigla;
        }
    }
}
