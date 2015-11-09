using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public decimal Preco { get; set; }

        public string Descricao { get; set; }

        public Selo Selo { get; set; }

        public Categoria Categoria { get; set; }

        public Cliente Cliente { get; private set; }

        public string Video { get; set; }

        public string Imagem { get; set; }

        
        public Jogo()
        {

        }

        public Jogo(int id, Cliente cliente)
        {
            this.Id = id;
            this.Cliente = cliente;
        }

        public void LocarPara(Cliente cliente)
        {
            this.Cliente = cliente;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
            builder.AppendLine("Descrição: " + this.Descricao);
            builder.AppendLine("Selo: " + this.Selo);
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Preco == jogoComp.Preco
                    && this.Descricao == jogoComp.Descricao
                    && this.Selo == jogoComp.Selo
                    && this.Categoria == jogoComp.Categoria
                    && this.Video == jogoComp.Video
                    && this.Imagem == jogoComp.Imagem
                    && this.Cliente == jogoComp.Cliente;
            }

            return false;
        }
    }
}
