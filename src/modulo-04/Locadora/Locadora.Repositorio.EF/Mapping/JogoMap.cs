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
            Property(p => p.Categoria).IsRequired().HasColumnName("Id_Categoria");
            Property(p => p.IdSelo).IsRequired().HasColumnName("Id_Selo");
            Property(p => p.Imagem).IsRequired().HasColumnName("Url_Imagem");
            Property(p => p.Video).IsRequired().HasColumnName("Tag_Video");

            HasRequired(s => s.Selo).WithMany().HasForeignKey(p => p.IdSelo);
        }
    }
}
