using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca
{
    public class UsuarioLogado
    {
        public string Usuario { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioLogado(string user, string[] permissoes)
        {
            this.Usuario = user;
            this.Permissoes = permissoes;
        }
    }
}