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
        public ActionResult JogosDisponiveis()
        {
            RelatorioModel model = new RelatorioModel();

            foreach(var jogo in repositorioJogos.BuscarTodos())
            {
                var jogoModel = new JogoModel()
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria.ToString()
                };
                model.Jogos.Add(jogoModel);
            }
            model.QuantidadeDeJogos = model.Jogos.Count;
            var precoMaisAlto = model.Jogos.Max(jogo => jogo.Preco);
            var precoMaisBaixo = model.Jogos.Min(jogo => jogo.Preco);
            model.JogoMaisCaro = model.Jogos.First(jogo => jogo.Preco == precoMaisAlto).Nome;
            model.JogoMaisBarato = model.Jogos.First(jogo => jogo.Preco == precoMaisBaixo).Nome;

            return View(model);
        }
    }
}