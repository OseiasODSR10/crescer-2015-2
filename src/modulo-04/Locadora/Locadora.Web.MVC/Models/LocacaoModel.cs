using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocacaoModel
    {
        [Required]
        public Jogo Jogo { get; set; }
        [Required]
        public Cliente Cliente { get; set; }
        [Required]
        public DateTime DataLocacao { get; set; }
        public DateTime DataPrevistaEntrega { get; set; }
        public decimal ValorInicial { get; set; }
        public DateTime? DataDevolucao { get; private set; }
        public bool EstaLocado
        {
            get { return DataDevolucao == null; }
        }
    }
}