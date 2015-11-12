using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class SeloMap : EntityTypeConfiguration<Selo>
    {
        public SeloMap()
        {
            ToTable("Selo");

            HasKey(s => s.Id);

            Property(s => s.Nome).IsRequired().HasMaxLength(250).HasColumnName("Nome");
            Property(s => s.Preco).IsRequired();
            Property(s => s.Prazo).IsRequired().HasColumnName("Prazo_Devolucao");
        }
    }
}
