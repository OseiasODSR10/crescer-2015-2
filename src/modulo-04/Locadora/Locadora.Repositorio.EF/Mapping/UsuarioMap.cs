using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(c => c.Id);

            Property(p => p.NomeCompleto).IsRequired().HasMaxLength(250);
            Property(p => p.Email).IsRequired().HasMaxLength(250);
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
}
