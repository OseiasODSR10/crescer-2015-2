namespace Locadora.Repositorio.EF.CodeFirst.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 200),
                        idClienteLocacao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Jogo", t => t.idClienteLocacao)
                .Index(t => t.idClienteLocacao);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(nullable: false, maxLength: 2000),
                        idSelo = c.Int(nullable: false),
                        idCategoria = c.Int(nullable: false),
                        Tag_Video = c.String(name: "Tag_Video  "),
                        Url_Imagem = c.String(name: "Url_Imagem "),
                    })
                .PrimaryKey(t => t.Id);           
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Cliente", "idClienteLocacao", "dbo.Jogo");
            DropIndex("dbo.Cliente", new[] { "idClienteLocacao" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
        }
    }
}
