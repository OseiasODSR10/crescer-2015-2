using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
            Property(p => p.Descricao).IsRequired().HasMaxLength(8000);
            Property(p => p.Preco).IsRequired();
            Property(p => (int)p.Categoria).IsRequired().HasColumnName("id_Categoria");
            Property(p => p.Imagem).IsRequired().HasColumnName("Url_Imagem");
            Property(p => p.Video).IsRequired().HasColumnName("Tag_Video");

            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("id_Cliente_Locacao"));
            HasRequired(s => s.Selo).WithRequiredDependent().Map(m => m.MapKey("id_Selo"));
        }
    }
}
