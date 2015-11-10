namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class init2 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        texto = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        NomeCompleto = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                    {
                        Usuario_Id = c.Int(nullable: false),
                        Permissao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id })
                .ForeignKey("dbo.Usuario", t => t.Usuario_Id, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Permissao_Id, cascadeDelete: true)
                .Index(t => t.Usuario_Id)
                .Index(t => t.Permissao_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario_Permissao", "Permissao_Id", "dbo.Permissao");
            DropForeignKey("dbo.Usuario_Permissao", "Usuario_Id", "dbo.Usuario");
            DropIndex("dbo.Usuario_Permissao", new[] { "Permissao_Id" });
            DropIndex("dbo.Usuario_Permissao", new[] { "Usuario_Id" });
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }
    }
}
