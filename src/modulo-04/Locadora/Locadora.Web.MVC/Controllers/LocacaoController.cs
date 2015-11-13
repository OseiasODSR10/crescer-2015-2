using Locadora.Dominio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        public ActionResult Locacao()
        {
            return View();
        }

        public ActionResult Salvar(int idJogo, int idCliente, DateTime DataLocacao)
        {
            LocacaoRepositorio repLocacao = new LocacaoRepositorio();
            Jogo Jogo = new JogoRepositorio().BuscarPorId(idJogo);
            Cliente Cliente = new ClienteRepositorio().BuscarPorId(idCliente);

            Locacao Locacao = new Locacao(Jogo, Cliente, DataLocacao);

            repLocacao.Criar(Locacao);

            return View();
        }
    }
}