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
    [Authorize]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorioJogos = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel model = new RelatorioModel();

            foreach(var jogo in string.IsNullOrEmpty(nome)? repositorioJogos.BuscarTodos() : repositorioJogos.BuscarPorNome(nome))
            {
                var jogoModel = new JogoModel(jogo.Id)
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria,
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo
                };
                model.Jogos.Add(jogoModel);
            }
            if (model.Jogos.Count != 0)
            {
                model.QuantidadeDeJogos = model.Jogos.Count;
                var precoMaisAlto = model.Jogos.Max(jogo => jogo.Preco);
                var precoMaisBaixo = model.Jogos.Min(jogo => jogo.Preco);
                model.JogoMaisCaro = model.Jogos.First(jogo => jogo.Preco == precoMaisAlto).Nome;
                model.JogoMaisBarato = model.Jogos.First(jogo => jogo.Preco == precoMaisBaixo).Nome;
                model.MediaDePreco = string.Format("{0: 0.00}",model.Jogos.Average(jogo => jogo.Preco));
            }
            return View(model);
        }

        [Autorizador(Roles = "MASTER")]
        public ActionResult Index(int id)
        {
            var jogo = repositorioJogos.BuscarPorId(id);
            if (jogo == null)
            {
                return null;
            }
            else
            {
                var jogoModelo = new JogoModel(jogo.Id)
                {
                    Nome = jogo.Nome,
                    Descricao = jogo.Descricao,
                    Categoria = jogo.Categoria,
                    Preco = jogo.Preco,
                    Selo = jogo.Selo,
                    IdCliente = jogo.Cliente.Id,
                    Imagem = jogo.Imagem,
                    Video = jogo.Video
                };
                return View(jogoModelo);
            }
        }
    }
}