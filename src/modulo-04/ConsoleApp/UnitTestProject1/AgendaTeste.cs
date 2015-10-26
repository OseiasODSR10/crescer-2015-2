using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApp;

namespace ConsoleAppTeste
{
    [TestClass]
    public class AgendaTeste
    {
        [TestMethod]
        public void agendaTemUmContato()
        {
            var agenda = new Agenda();
            agenda.AdicionarContato(new Contato() { Nome = "Julio César", Numero = 97879867 });
            agenda.AdicionarContato(new Contato() { Nome = "Oseias", Numero = 08907896});
            Assert.AreEqual(agenda.QuantidadeContatos, 2);
        }
    }
}
