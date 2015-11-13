namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class correcao : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Locacao", name: "Cliente_Id", newName: "IdCliente");
            RenameColumn(table: "dbo.Locacao", name: "Jogo_Id", newName: "IdJogo");
            RenameIndex(table: "dbo.Locacao", name: "IX_Jogo_Id", newName: "IX_IdJogo");
            RenameIndex(table: "dbo.Locacao", name: "IX_Cliente_Id", newName: "IX_IdCliente");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Locacao", name: "IX_IdCliente", newName: "IX_Cliente_Id");
            RenameIndex(table: "dbo.Locacao", name: "IX_IdJogo", newName: "IX_Jogo_Id");
            RenameColumn(table: "dbo.Locacao", name: "IdJogo", newName: "Jogo_Id");
            RenameColumn(table: "dbo.Locacao", name: "IdCliente", newName: "Cliente_Id");
        }
    }
}
