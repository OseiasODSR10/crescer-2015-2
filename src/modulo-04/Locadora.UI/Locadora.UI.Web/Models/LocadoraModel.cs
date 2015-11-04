using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.UI.Web
{
    public class LocadoraModel
    {
        ULocadora locadora = new ULocadora("Locadora Oséias");

        public string getNomeLocadora()
        {
            return locadora.Nome;
        }
    }
}