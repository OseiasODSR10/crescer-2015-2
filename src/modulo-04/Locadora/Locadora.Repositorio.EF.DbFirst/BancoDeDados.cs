using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.DbFirst
{
    public class BancoDeDados : DbContext
    {
        
        public BancoDeDados() : base("LOCADORACWI")
        {
        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(200);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
            Property(p => p.Descricao).IsRequired().HasMaxLength(2000);
            Property(p => p.Preco).IsRequired();
            Property(p => p.Categoria).IsRequired().HasColumnName("idCategoria");
            Property(p => p.Selo).IsRequired().HasColumnName("idSelo");
            Property(p => p.Imagem).IsOptional().HasColumnName("Url_Imagem ");
            Property(p => p.Video).IsOptional().HasColumnName("Tag_Video  ");

            HasOptional(p => p.Cliente).WithRequired().Map(m => m.MapKey("idClienteLocacao"));
        }
    }
}
