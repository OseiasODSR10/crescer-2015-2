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
            var Jogo = new JogoRepositorio().BuscarPorId(id);

            var model = new LocacaoModel();
            model.Jogo = Jogo;
            model.DataLocacao = DateTime.Now;
            model.DataPrevistaEntrega = model.DataLocacao.AddDays(Jogo.Selo.Prazo);
            model.ValorInicial = Jogo.Selo.Preco;

            return View(model);
        }

        public ActionResult Salvar(LocacaoModel model)
        {
            LocacaoRepositorio repLocacao = new LocacaoRepositorio();
            
            Locacao Locacao = new Locacao(model.Jogo, model.Cliente, model.DataLocacao);

            repLocacao.Criar(Locacao);

            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }
    }
}