using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class DetalhesController : Controller
    {
        private IJogoRepositorio repositorioJogos = new Locadora.Repositorio.ADO.JogoRepositorio();

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