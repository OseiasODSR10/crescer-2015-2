using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");
            HasKey(c => c.Id);

            Property(p => p.valoTotal).IsOptional().HasColumnName("Valor_Total");
            Property(p => p.DataLocacao).IsRequired().HasColumnName("Data_Locacao");
            Property(p => p.DataDevolucao).IsOptional().HasColumnName("Data_Devolucao");

            HasRequired(c => c.Cliente).WithMany();
            HasRequired(j => j.Jogo).WithMany();
        }
    }
}
