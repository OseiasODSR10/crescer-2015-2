using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Text;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            Jogo jogoA = new Jogo(1);
            Jogo jogoB = new Jogo(1);

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void JogoADeveSerDiferenteDoJogoB()
        {
            Jogo jogoA = new Jogo(1);
            Jogo jogoB = new Jogo(2);

            Assert.AreNotEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void JogoÉCriadoComUmaCategoriaCorretamente()
        {
            Jogo jogoA = new Jogo(1) { Categoria = Categoria.AVENTURA };

            Assert.AreEqual(jogoA.Categoria, Categoria.AVENTURA);
        }

        [TestMethod]
        public void JogoPossuiOSeloInfromado()
        {
            Selo selo = new Selo() { Nome = "Ouro" };
            Jogo jogoA = new Jogo(1) { Selo = selo };

            Assert.AreEqual(jogoA.Selo, selo);
        }

        [TestMethod]
        public void JogoToStringRetornaAStringComTodosOsDados()
        {
            Selo selo = new Selo() { Nome = "Ouro" };
            Jogo jogoA = new Jogo(1)
            {
                Nome = "1",
                Categoria = Categoria.RPG,
                Selo = selo,
                Descricao = "1",
                Imagem = "img",
                Video = "vid"
            };
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + 1);
            builder.AppendLine("Nome: " + 1);
            builder.AppendLine("Descrição: " + 1);
            builder.AppendLine("Selo: " + "Ouro");
            builder.AppendLine("Categoria: " + "RPG");

            string stringEsperada = builder.ToString();

            Assert.AreEqual(jogoA.ToString(), stringEsperada);
        }
    }
}
