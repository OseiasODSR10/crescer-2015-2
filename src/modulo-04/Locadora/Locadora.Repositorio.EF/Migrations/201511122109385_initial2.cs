namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial2 : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Jogo", "Id_Selo", "dbo.Selo");
            AddForeignKey("dbo.Jogo", "Id_Selo", "dbo.Selo", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "Id_Selo", "dbo.Selo");
            AddForeignKey("dbo.Jogo", "Id_Selo", "dbo.Selo", "Id");
        }
    }
}
