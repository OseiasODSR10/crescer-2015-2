using Locadora.Dominio;
using Locadora.Repositorio.ADO;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        [HttpGet]
        public ActionResult Editar(int? id)
        {
            if (id.HasValue)
            {
                var jogo = new JogoRepositorio().BuscarPorId(id.Value);
                JogoModel model = new JogoModel(jogo.Id)
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Descricao = jogo.Descricao,
                    Categoria = jogo.Categoria,
                    Selo = jogo.Selo,
                    Video = jogo.Video,
                    Imagem = jogo.Imagem,
                    IdCliente = jogo.IdClienteLocacao.Value
                };
                return View(model);
            }
            else
            {
                return View();
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(JogoModel model)
        {
            ModelState.AddModelError("Nome", "Nome já existe no banco de dados!");
            ModelState.AddModelError("", "Tem coisa errada aí...");

            if (ModelState.IsValid)
            {
                Jogo jogoParaSalvar = new Jogo(model.Id, model.IdCliente)
                {
                    Nome = model.Nome,
                    Descricao = model.Descricao,
                    Preco = model.Preco,
                    Categoria = model.Categoria,
                    Selo = model.Selo,
                    Imagem = model.Imagem,
                    Video = model.Video
                };
                new JogoRepositorio().Criar(jogoParaSalvar);
                TempData["Mensagem"] = "Jogo salvo com sucesso!";

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Editar", model);
            }
        }
    }
}