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
            Property(p => p.IdCliente).IsOptional();
            Property(p => p.IdJogo).IsOptional();

            HasRequired(c => c.Cliente).WithMany().HasForeignKey(k => k.IdCliente);
            HasRequired(j => j.Jogo).WithMany().HasForeignKey(k => k.IdJogo);
        }
    }
}
