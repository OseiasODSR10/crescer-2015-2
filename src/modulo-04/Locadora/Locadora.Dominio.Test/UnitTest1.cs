using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void PermissaoAdicionaNovoUsuario()
        {
            Usuario user = new Usuario();
            Permissao permissao1 = new Permissao();
            permissao1.Nome = "Adm";
            permissao1.Usuarios.Add(user);

            Assert.IsTrue(permissao1.Usuarios.Contains(user));
        }

        [TestMethod]
        public void PermissaoPossuiONomeInformado()
        {
            Permissao permissao1 = new Permissao();
            permissao1.Nome = "Adm";

            Assert.AreEqual(permissao1.Nome, "Adm");
        }
    }
}
