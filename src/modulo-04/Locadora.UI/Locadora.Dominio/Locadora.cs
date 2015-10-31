using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Locadora.Dominio
{
    public class ULocadora
    {
        public string Nome { get; set; }
        List<Jogo> Jogos { get; set; }
        JogoRepositorio baseDeJogos;

        public ULocadora(string nome)
        {
            Nome = nome;
            baseDeJogos = new JogoRepositorio();
            Jogos = baseDeJogos.ListarJogos();
        }

        public List<Jogo> BuscarJogoPorNome(string nome)
        {
            return baseDeJogos.BuscarJogoPorNome(nome);
        }

        public Jogo BuscarJogoPorID(int id)
        {
            return baseDeJogos.BuscarJogoPorID(id);
        }

        public void CadastrarNovoJogo(Jogo jogo)
        {
            baseDeJogos.CadastrarJogo(jogo);
            AtualizarListaDeJogos();
        }

        public void EditarJogo(Jogo jogo, string novoNome, double novoPreco, Categoria novaCategoria)
        {
            Jogo jogoAtualizado = new Jogo(novoNome, novoPreco, novaCategoria) { Id = jogo.Id, StatusDisponivel = "sim" };
            baseDeJogos.EditarJogo(jogoAtualizado);
            AtualizarListaDeJogos();
        }

        public void AtualizarListaDeJogos()
        {
            Jogos = baseDeJogos.ListarJogos();
        }

        public void ExportarRelatorio()
        {
            List<string> linhas = new List<string>();
            string nomeDoArquivo = string.Format("Relatorio-{0:dd.MM.yyy.hh.mm.ss}", DateTime.Now);
            string caminhoDoTxt = @"C:\Users\Usuario\Documents\crescer-2015-2\src\modulo-04\Locadora.UI\Locadora.UI\"+nomeDoArquivo+".txt";
            int qtdJogosDisp = Jogos.FindAll(j => j.StatusDisponivel.Equals("sim")).Count;
            double mediaPrecoJogos = Jogos.Average(j => j.Preco);
            string jogoMaisCaro = Jogos.Find(j => j.Preco.Equals(Jogos.Max(j2 => j2.Preco))).Nome;
            string jogoMaisBarato = Jogos.Find(j => j.Preco.Equals(Jogos.Min(j2 => j2.Preco))).Nome;
            linhas.Add(string.Format("{0, 45}", Nome));
            string data = String.Format("{0: d/M/yyyy}", DateTime.Now);
            string hora = String.Format("{0: HH:mm:ss}", DateTime.Now);
            linhas.Add(String.Format("{0, -35} {1, 43}", data, hora));
            linhas.Add(String.Format("{0, 50}", "Relatorio de Jogos"));
            linhas.Add("==========================================================================================");
            linhas.Add(string.Format("{0, -9}{1, -20}{2, -40}{3, -5}{4, 16}", "ID", "Categoria", "Nome", "Preco", "Disponivel"));
            foreach(Jogo jogo in Jogos)
            {
                linhas.Add(string.Format("{0, -9}{1, -20}{2, -40}{3, -5}{4, 16}",
                    jogo.Id, jogo.Categoria, jogo.Nome, jogo.Preco, jogo.StatusDisponivel));
            }
            linhas.Add("------------------------------------------------------------------------------------------");
            linhas.Add(string.Format("Quantidade total de jogos: {0}", Jogos.Count));
            linhas.Add(string.Format("Quantidade de jogos disponíveis: {0}", qtdJogosDisp));
            linhas.Add(string.Format("Valor médio por jogo: R$ {0:0}", mediaPrecoJogos));
            linhas.Add(string.Format("Jogo mais caro: {0}", jogoMaisCaro));
            linhas.Add(string.Format("Jogo mais barato: {0}", jogoMaisBarato));
            linhas.Add("==========================================================================================");

            File.AppendAllLines(caminhoDoTxt, linhas);
        }
    }
}
