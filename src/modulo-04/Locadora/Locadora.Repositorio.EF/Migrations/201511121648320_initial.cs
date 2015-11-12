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
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    Descricao = c.String(nullable: false),
                    Id_Categoria = c.Int(nullable: false),
                    Tag_Video = c.String(nullable: false),
                    Url_Imagem = c.String(nullable: false),
                    Id_Selo = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Selo", t => t.Id_Selo)
                .ForeignKey("dbo.Categoria", t => t.Id_Categoria)
                .Index(t => t.Id_Selo)
                .Index(t => t.Id_Categoria);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    Prazo_Devolucao = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id);

            CriarSelos();

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 75),
                })
                .PrimaryKey(t => t.Id);

            CriarCategorias();

            CreateTable(
                "dbo.Locacao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Valor_Total = c.Decimal(precision: 18, scale: 2),
                    Data_Locacao = c.DateTime(nullable: false),
                    Data_Devolucao = c.DateTime(),
                    Cliente_Id = c.Int(nullable: false),
                    Jogo_Id = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.Cliente_Id, cascadeDelete: true)
                .ForeignKey("dbo.Jogo", t => t.Jogo_Id, cascadeDelete: true)
                .Index(t => t.Cliente_Id)
                .Index(t => t.Jogo_Id);

            CreateTable(
                "dbo.Permissao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Email = c.String(nullable: false, maxLength: 250),
                    NomeCompleto = c.String(nullable: false, maxLength: 250),
                    Senha = c.String(nullable: false, maxLength: 256),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                {
                    Id_Usuario = c.Int(nullable: false),
                    Id_Permissao = c.Int(nullable: false),
                })
                .PrimaryKey(t => new { t.Id_Usuario, t.Id_Permissao })
                .ForeignKey("dbo.Usuario", t => t.Id_Usuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Id_Permissao, cascadeDelete: true)
                .Index(t => t.Id_Usuario)
                .Index(t => t.Id_Permissao);

        }

        public override void Down()
        {
            DropForeignKey("dbo.Usuario_Permissao", "Id_Permissao", "dbo.Permissao");
            DropForeignKey("dbo.Usuario_Permissao", "Id_Usuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacao", "Jogo_Id", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "Cliente_Id", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "Id_Selo", "dbo.Selo");
            DropIndex("dbo.Usuario_Permissao", new[] { "Id_Permissao" });
            DropIndex("dbo.Usuario_Permissao", new[] { "Id_Usuario" });
            DropIndex("dbo.Locacao", new[] { "Jogo_Id" });
            DropIndex("dbo.Locacao", new[] { "Cliente_Id" });
            DropIndex("dbo.Jogo", new[] { "Id_Selo" });
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Locacao");
            DropTable("dbo.Selo");
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
        }

        private void CriarCategorias()
        {
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (1, 'RPG')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (2, 'Corrida')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (3, 'Aventura')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (4, 'Luta')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (5, 'Esporte')");
        }

        private void CriarSelos()
        {
            Sql("INSERT INTO Selo (Nome, Preco, Prazo_Devolucao) VALUES ('Ouro', 15, 1)");
            Sql("INSERT INTO Selo (Nome, Preco, Prazo_Devolucao) VALUES ('Prata', 10, 2)");
            Sql("INSERT INTO Selo (Nome, Preco, Prazo_Devolucao) VALUES ('Bronze', 5, 3)");
        }
    }
}
