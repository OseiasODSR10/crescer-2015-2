using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDadosCF : DbContext
    {

        public BancoDeDadosCF() : base("LOCADORACWI")
        {
        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

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

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(c => c.Id);

            Property(p => p.NomeCompleto).IsRequired().HasMaxLength(400);
            Property(p => p.Email).IsRequired().HasMaxLength(100);
            Property(p => p.Senha).IsRequired().HasMaxLength(256);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                .Map(m =>
               {
                   m.ToTable("Usuario_Permissao");
                   m.MapLeftKey("idUsuario");
                   m.MapRightKey("idPermissao");
               });

        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");

            HasKey(c => c.Id);

            Property(p => p.texto);
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
            Property(p => (int)p.Categoria).IsRequired().HasColumnName("idCategoria");
            Property(p => (int)p.Selo).IsRequired().HasColumnName("idSelo");
            Property(p => p.Imagem).IsOptional().HasColumnName("Url_Imagem ");
            Property(p => p.Video).IsOptional().HasColumnName("Tag_Video  ");

            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("idClienteLocacao"));
        }
    }
}
