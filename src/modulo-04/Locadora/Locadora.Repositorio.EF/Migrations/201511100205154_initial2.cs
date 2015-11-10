namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial2 : DbMigration
    {
        public override void Up()
        {
            DropIndex("dbo.Cliente", new[] { "idClienteLocacao" });
            AddColumn("dbo.Jogo", "idClienteLocacao", c => c.Int());
            CreateIndex("dbo.Jogo", "idClienteLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Cliente", "idClienteLocacao", c => c.Int(nullable: false));
            DropIndex("dbo.Jogo", new[] { "idClienteLocacao" });
            DropColumn("dbo.Jogo", "idClienteLocacao");
            CreateIndex("dbo.Cliente", "idClienteLocacao");
        }
    }
}
