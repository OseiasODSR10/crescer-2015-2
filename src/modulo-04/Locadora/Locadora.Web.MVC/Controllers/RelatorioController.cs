using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorioJogos = new Locadora.Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel model = new RelatorioModel();

            foreach(var jogo in string.IsNullOrEmpty(nome)? repositorioJogos.BuscarTodos() : repositorioJogos.BuscarPorNome(nome))
            {
                var jogoModel = new JogoModel(jogo.Id)
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria.ToString(),
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo.ToString()
                };
                model.Jogos.Add(jogoModel);
            }
            model.QuantidadeDeJogos = model.Jogos.Count;
            var precoMaisAlto = model.Jogos.Max(jogo => jogo.Preco);
            var precoMaisBaixo = model.Jogos.Min(jogo => jogo.Preco);
            model.JogoMaisCaro = model.Jogos.First(jogo => jogo.Preco == precoMaisAlto).Nome;
            model.JogoMaisBarato = model.Jogos.First(jogo => jogo.Preco == precoMaisBaixo).Nome;
            model.MediaDePreco = model.Jogos.Average(jogo => jogo.Preco);
            return View(model);
        }

        public ActionResult Index(int id)
        {
            var jogo = repositorioJogos.BuscarPorId(id);
            var jogoModelo = new JogoModel(jogo.Id)
            {
                Nome = jogo.Nome,
                Descricao = jogo.Descricao,
                Categoria = jogo.Categoria.ToString(),
                Preco = jogo.Preco,
                Selo = jogo.Selo.ToString()
            };
            return View(jogoModelo);
        }
    }
}