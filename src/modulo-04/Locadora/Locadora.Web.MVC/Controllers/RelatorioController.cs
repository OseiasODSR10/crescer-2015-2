using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorioJogos = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel model = new RelatorioModel();

            foreach(var jogo in string.IsNullOrEmpty(nome)? repositorioJogos.BuscarTodos() : repositorioJogos.BuscarPorNome(nome))
            {
                var jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria.ToString(),
                    Selo = jogo.Selo.ToString()
                };
                model.Jogos.Add(jogoModel);
            }
            if (model.Jogos.Count != 0)
            {
                model.QuantidadeDeJogos = model.Jogos.Count;
            }
            return View(model);
        }
        
    }
}