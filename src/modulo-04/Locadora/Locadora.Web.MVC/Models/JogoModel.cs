using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int Id { get; private set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        [StringLength(250, ErrorMessage = "*O nome deve ter no máximo 250 caracteres")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public decimal Preco { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public Categoria Categoria { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public Selo Selo { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public string Descricao { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }

        [DisplayName("Id cliente")]
        public int? IdCliente { get; set; }

        public JogoModel(int id)
        {
            Id = id;
        }

    }
}