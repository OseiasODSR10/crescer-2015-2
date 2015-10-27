using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos;

        public Agenda()
        {
            contatos = new List<Contato>();
        }

        public int QuantidadeContatos { get { return contatos.Count; } }


        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }
        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if(contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}
        public void RemoverContatoPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {

                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatoPorNumero(string numeroContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {

                if (contatos[i].Numero.Equals(numeroContato))
                    contatosASeremRemovidos.Add(contatos[i]);
            }
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public string ListarContatosO()
        {
            string listaContatos = "";
            foreach (var contato in contatos)
            {
                listaContatos += contato.Nome + " - " + contato.Numero + "\n";
            }
            return listaContatos;
        }
        public string listarContatosOrdenadosPorNome()
        {
            List<Contato> listaOrganizada = new List<Contato>();
            contatos.Sort(delegate (Contato contatoA, Contato y)
            {
                if (contatoA.Nome == null && y.Nome == null) return 0;
                else if (contatoA.Nome == null) return -1;
                else if (y.Nome == null) return 1;
                else return contatoA.Nome.CompareTo(y.Nome);
            });
            return ListarContatosO();
        }
    }
}
