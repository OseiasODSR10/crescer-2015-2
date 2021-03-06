﻿using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public int Atualizar(Usuario user)
        {
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(user).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();
            }
        }

        public Usuario BuscarPorEmail(string email)
        {
            using (var db = new BancoDeDadosCF())
            {
                var user = db.Usuario.Include("Permissoes").FirstOrDefault(j => email.Equals(j.Email));
                return user;
            }
        }

        public Usuario BuscarPorId(int id)
        {
            using (var db = new BancoDeDadosCF())
            {
                Usuario user = db.Usuario.Include("Permissoes").FirstOrDefault(u => u.Id == id);
                return user;
            }
        }

        public IList<Usuario> BuscarTodos()
        {
            using (var db = new BancoDeDadosCF())
            {
                var user = db.Usuario.Include("Permissoes").ToList();
                return user;
            }
        }

        public int Criar(Usuario user)
        {
            using (var db = new BancoDeDadosCF())
            {
                db.Entry(user).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new BancoDeDadosCF())
            {
                Usuario user = db.Usuario.Find(id);
                db.Entry(user).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
