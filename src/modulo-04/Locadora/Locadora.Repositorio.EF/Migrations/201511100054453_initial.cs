namespace Locadora.Repositorio.EF.Migrations
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
                    //idClienteLocacao = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id);
                //.ForeignKey("dbo.Jogo", t => t.idClienteLocacao)
                //.Index(t => t.idClienteLocacao);
            //================================================================
            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                    .PrimaryKey(t => t.Id);
            //=============================================================
            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                    .PrimaryKey(t => t.Id);
            //============================================================
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
                    idClienteLocacao = c.Int(nullable: true),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Categoria", t => t.idCategoria)
                .ForeignKey("dbo.Selo", t => t.idSelo)
                .ForeignKey("dbo.Cliente", t => t.idClienteLocacao)
                .Index(t => t.idSelo)
                .Index(t => t.idCategoria)                
                .Index(t => t.idClienteLocacao);

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
