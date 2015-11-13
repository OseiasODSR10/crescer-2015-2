using Locadora.Dominio;
using Locadora.Repositorio.EF;
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
    public class LocacaoController : Controller
    {
        public ActionResult Locacao(int id)
        {
            var jogo = new JogoRepositorio().BuscarPorId(id);

            var model = new LocacaoModel();
            model.Jogo = jogo;
            model.IdJogo = jogo.Id;
            model.DataLocacao = DateTime.Now;
            model.DataPrevistaEntrega = model.DataLocacao.AddDays(jogo.Selo.Prazo);
            model.ValorInicial = jogo.Selo.Preco;

            return View(model);
        }

        public ActionResult Salvar(LocacaoModel model)
        {
            LocacaoRepositorio repLocacao = new LocacaoRepositorio();
            Jogo jogo = new JogoRepositorio().BuscarPorId(model.IdJogo);
            Cliente cliente = new ClienteRepositorio().BuscarPorId(model.IdClient);
            Locacao Locacao = new Locacao(jogo, cliente, model.DataLocacao);

            repLocacao.Criar(Locacao);

            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }
    }
}