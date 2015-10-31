using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscaOrdenadosPorCargo()
        {
            var ordenadosPorNome = Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();
            return ordenadosPorNome;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var funcionariosComEssaPalavra = Funcionarios.FindAll(funcionario => funcionario.Nome.Contains(nome)).OrderBy(funcionario => funcionario.Nome).ToList();
            return funcionariosComEssaPalavra;
        }

        public IList<dynamic> BuscaRapida()
        {
            List<dynamic> funcionariosD = new List<dynamic>();

            funcionariosD.AddRange(
                from f in Funcionarios
                select new
                {
                    Nome = f.Nome,
                    TituloCargo = f.Cargo.Titulo
                }
                );
            return funcionariosD;
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            List<Funcionario> funcionarios = new List<Funcionario>();
            funcionarios.AddRange(
                from f in Funcionarios
                where turnos.Contains(f.TurnoTrabalho)
                select f
                );
            return funcionarios;
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            List<dynamic> turnosDeTrabalho = new List<dynamic>();

            turnosDeTrabalho.AddRange(
                from f in Funcionarios
                group f by f.TurnoTrabalho into turno
                select new {
                    Turno = turno.Key,
                    Quantidade = turno.Count()
                }
                );

            return turnosDeTrabalho;
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            List<Funcionario> funcionariosNesseCargo = new List<Funcionario>();
            funcionariosNesseCargo.AddRange(
                Funcionarios.FindAll(funcionario => funcionario.Cargo.Equals(cargo))
                );
            return funcionariosNesseCargo;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            List<Funcionario> funcionariosComIdadeAproximada = new List<Funcionario>();
            var data = DateTime.Now.AddYears(-idade);
            funcionariosComIdadeAproximada.AddRange(
                from f in Funcionarios
                where (f.DataNascimento.AddYears(-5).Year <= data.Year) 
                && (data.Year <= f.DataNascimento.AddYears(5).Year)
                select f          
                );
            return funcionariosComIdadeAproximada;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            double mediaSalarial = 0;
            if (turno.HasValue)
            {
                mediaSalarial = BuscarPorTurno(turno.Value).Average(funcionario => funcionario.Cargo.Salario);
            }
            else
            {
                mediaSalarial = Funcionarios.Average(
                    funcionario => funcionario.Cargo.Salario);
            }
            return mediaSalarial;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var mesAtual = DateTime.Now.Month;

            return Funcionarios.FindAll(
                funcionario => funcionario.DataNascimento.Month.Equals(mesAtual))
                .ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            string consoantes = "[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]";

            int maiorNumeroDeConsoantes = Funcionarios.Max(f => Regex.Matches(f.Nome, consoantes).Count);

            var funcionarioMaisComplexo = Funcionarios.First(f2 => Regex.Matches(f2.Nome, consoantes).Count == maiorNumeroDeConsoantes);

            double salario = funcionarioMaisComplexo.Cargo.Salario;

            var salarioRS = string.Format("R$ {0:0.00}", salario);
            var salarioUS = string.Format("U$ {0:0.00}", salario);

            return new
            {
                Nome = funcionarioMaisComplexo.Nome,
                SalarioRS = salarioRS,
                SalarioUS = salarioUS
            };
        }

        
    }
}