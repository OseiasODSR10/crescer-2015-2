using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(string usuario, string senha)
        {
            if (usuario == "didi" && senha == "die")
            {
                var usuarioLogadoModel = new UsuarioLogado("didi", new string[] { "MASTER" });

                FormsAuthentication.SetAuthCookie(usuario, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }
            else
            {
                return View("Index");
            }
            return RedirectToAction("Index", "Home");
        }
    }
}