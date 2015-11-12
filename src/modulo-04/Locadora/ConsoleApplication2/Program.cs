using Locadora.Dominio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            UsuarioRepositorio bd = new UsuarioRepositorio();

            Usuario user = new Usuario()
            {
                Email = "oseias.rdgs@x.com",
                NomeCompleto = "Oseias",
                Senha = new ServicoCriptografia().CriptografarSenha("oss")
                
            };

            var x = bd.BuscarPorEmail(user.Email);
        }
    }
}
