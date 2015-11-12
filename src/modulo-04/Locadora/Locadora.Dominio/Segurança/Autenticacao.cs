using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Segurança
{
    public class Autenticacao
    {
        private IUsuarioRepositorio repositorioUsuarios;
        private ICriptografia criptografiaSenha;

        public Autenticacao(IUsuarioRepositorio usuarioRepositorio, ICriptografia servicoCriptografia)
        {
            this.repositorioUsuarios = usuarioRepositorio;
            this.criptografiaSenha = servicoCriptografia;
        }

        public Usuario BuscarPorAutenticacao(string email, string senha)
        {
            Usuario usuario = this.repositorioUsuarios.BuscarPorEmail(email);

            if (usuario != null)
            {
                string senhaCriptografada = criptografiaSenha.CriptografarSenha(senha);

                if (usuario.Senha != senhaCriptografada)
                {
                    return null;
                }
            }

            return usuario;
        }
    }
}
