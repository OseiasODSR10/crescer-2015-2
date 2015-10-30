using DbFuncionarios;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace BaseDeDadosTeste
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void MetodoBuscarPorNomeRetornaCorretamente()
        {
            BaseDeDados funcionarios = new BaseDeDados();
            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;

            Assert.AreEqual(funcionarios.BuscarPorNome("Lucas Leal")[0], lucasLeal);
        }

        [TestMethod]
        public void MetodoBuscarPorNomeRetornaDoisFuncionarios()
        {
            BaseDeDados funcionarios = new BaseDeDados();
            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;

            Assert.AreEqual(funcionarios.BuscarPorNome("Lucas")[1], lucasLeal);
            Assert.AreEqual(funcionarios.BuscarPorNome("Lucas")[0], lucasKauer);
        }

        [TestMethod]
        public void MetodoBuscarPorTurnoRecebeParametrosVariaveiseRetornaDeAcordoComTurno()
        {
            BaseDeDados funcionarios = new BaseDeDados();

            Assert.AreEqual(
                funcionarios.BuscarPorTurno(TurnoTrabalho.Manha).Count
                , 5);
            Assert.AreEqual(
                funcionarios.BuscarPorTurno(TurnoTrabalho.Noite).Count
                , 2);
            Assert.AreEqual(
                funcionarios.BuscarPorTurno(TurnoTrabalho.Tarde).Count
                , 4);
            Assert.AreEqual(
                funcionarios.BuscarPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Noite).Count
                , 7);
            Assert.AreEqual(
                funcionarios.BuscarPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Noite,TurnoTrabalho.Tarde).Count
                , 11);
        }

        [TestMethod]
        public void BuscaPorCargoAnalistaReotrnaDoisFuncionarios()
        {
            BaseDeDados funcionarios = new BaseDeDados();
            Cargo analista = new Cargo("Analista", 250);
            Assert.AreEqual(funcionarios.BuscarPorCargo(analista).Count, 2);
        }

        [TestMethod]
        public void BuscaPorCargoDesenvolvedorReotrnaOitoFuncionarios()
        {
            BaseDeDados funcionarios = new BaseDeDados();
            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Assert.AreEqual(funcionarios.BuscarPorCargo(desenvolvedor).Count, 8);
        }

        [TestMethod]
        public void BuscaPorCargoGerenteReotrnaUmFuncionarios()
        {
            BaseDeDados funcionarios = new BaseDeDados();
            Cargo gerente = new Cargo("Gerente", 550.5);
            Assert.AreEqual(funcionarios.BuscarPorCargo(gerente).Count, 1);
        }


    }
}
