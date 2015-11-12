using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao : EntidadeBase
    {
        public Cliente Cliente { get; private set; }
        public Jogo Jogo { get; private set; }
        public decimal ValorInicial { get; }
        public decimal? valoTotal { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataPrevistaDevolucao { get;}
        public DateTime? DataDevolucao { get; private set; }
        public bool EstaLocado
        {
            get { return DataDevolucao == null; }
        }

        public Locacao(Jogo jogo, Cliente cliente, DateTime dataLocacao)
        {
            this.Cliente = cliente;
            this.Jogo = jogo;
            this.ValorInicial = jogo.Selo.Preco;
            this.DataLocacao = dataLocacao;
            this.DataPrevistaDevolucao = dataLocacao.AddDays(jogo.Selo.Prazo);
        }

        public void DevolverJogo(DateTime dataDevolucao)
        {
            this.DataDevolucao = dataDevolucao;
            int diasDeAtraso = (int)(dataDevolucao - DataPrevistaDevolucao).TotalDays;
            int multaPorAtraso = 5 * diasDeAtraso;
            this.valoTotal = ValorInicial + multaPorAtraso;
        }
    }
}
