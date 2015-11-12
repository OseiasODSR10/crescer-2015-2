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
    public class JogoController : Controller
    {
        [HttpGet]
        public ActionResult Editar(int? id)
        {
            if (id.HasValue)
            {
                var jogo = new JogoRepositorio().BuscarPorId(id.Value);
                EditarJogoModel model = new EditarJogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Descricao = jogo.Descricao,
                    Categoria = jogo.Categoria,
                    Selo = (SeloModel)Enum.Parse(typeof(SeloModel), jogo.Selo.Nome),
                    Video = jogo.Video,
                    Imagem = jogo.Imagem
                };
                return View(model);
            }
            else
            {
                return View(new EditarJogoModel());
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(EditarJogoModel model)
        {
            if (ModelState.IsValid)
            {
                Jogo jogoParaSalvar = new Jogo(model.Id)
                {
                    Nome = model.Nome,
                    Descricao = model.Descricao,
                    Categoria = model.Categoria,
                    Selo = new SeloRepositorio().BuscarPorId((int)model.Selo),
                    Imagem = model.Imagem,
                    Video = model.Video         
                };

                if(jogoParaSalvar.Id == 0)
                {
                    new JogoRepositorio().Criar(jogoParaSalvar);
                    TempData["Mensagem"] = "Jogo salvo com sucesso!";
                }
                else
                {
                    new JogoRepositorio().Atualizar(jogoParaSalvar);
                    TempData["Mensagem"] = "Jogo alterado com sucesso!";
                }

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Editar", model);
            }
        }

        [Autorizador(Roles = "ADMIN")]
        public ActionResult DetalhesJogo(int id)
        {
            var jogo = new JogoRepositorio().BuscarPorId(id);

            if (jogo == null)
            {
                return null;
            }
            else
            {
                JogoDetalhesModel jogoModelo = new JogoDetalhesModel()
                {
                    Nome = jogo.Nome,
                    Descricao = jogo.Descricao,
                    Categoria = jogo.Categoria.ToString(),
                    Selo = jogo.Selo.ToString(),
                    Imagem = jogo.Imagem,
                    Video = jogo.Video
                };
                return View(jogoModelo);
            }
        }
    }
}