using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class EditarJogoModel
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        public Categoria Categoria { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        public SeloModel Selo { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        public string Imagem { get; set; }

        [Required(ErrorMessage = "*Campo Obrigatorio")]
        [DisplayName("Vídeo")]
        public string Video { get; set; }
    }
}