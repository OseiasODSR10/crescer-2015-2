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

        [Required(ErrorMessage = "*Campo obrigatório")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        [DisplayName("Preço")]
        public decimal Preco { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public Categoria Categoria { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        public Selo Selo { get; set; }

        [Required(ErrorMessage = "*Campo obrigatório")]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }
        
        public string Imagem { get; set; }
        
        [DisplayName("Vídeo")]
        public string Video { get; set; }
    }
}