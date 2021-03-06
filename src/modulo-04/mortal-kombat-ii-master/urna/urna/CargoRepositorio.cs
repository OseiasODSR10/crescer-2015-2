﻿using DbExtensions;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace urna
{
    public class CargoRepositorio : IRepositorio<Cargo>
    {
        public Cargo BuscarPorId(int id)
        {
            Cargo cargoEncontrado = null;

            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText =
                    "SELECT * FROM Cargo WHERE IdCargo = @paramIdCargo";

                comando.AddParameter("paramIdCargo", id);

                connection.Open();

                IDataReader reader = comando.ExecuteReader();

                if (reader.Read())
                {
                    string nome = reader["Nome"].ToString();
                    char situacao = Convert.ToChar(reader["Situacao"]);

                    cargoEncontrado = new Cargo(nome, situacao);    
                }

                connection.Close();
            }

            return cargoEncontrado;
        }

        public void Cadastrar(Cargo cargo)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("@paramNome", cargo.Nome);
                comando.AddParameter("@paramSituacao", cargo.Situacao);

                comando.CommandText =
                    "INSERT INTO Cargo(Nome, Situacao)" +
                    " VALUES(@paramNome, @paramSituacao)";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
            }
        }

        public void Atualizar(Cargo cargo)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("@paramNome", cargo.Nome);
                comando.AddParameter("@paramSituacao", cargo.Situacao);


                comando.CommandText =
                    "UPDATE Cargo SET Situacao=@paramSituacao WHERE Nome=@paramNome";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
            }
        }

        public void AtualizarPorId(int id, Cargo cargo)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("@paramIDCargo", id);
                comando.AddParameter("@paramNome", cargo.Nome);
                comando.AddParameter("@paramSituacao", cargo.Situacao);


                comando.CommandText =
                    "UPDATE Cargo SET Nome=@paramNome,Situacao=@paramSituacao WHERE IDCargo=@paramIDCargo";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
            }

        }

        public void AtualizarPorNome(string nome, Cargo cargo)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("@paramNomeAntigo", nome);
                comando.AddParameter("@paramNome", cargo.Nome);
                comando.AddParameter("@paramSituacao", cargo.Situacao);


                comando.CommandText =
                    "UPDATE Cargo SET Nome=@paramNome,Situacao=@paramSituacao WHERE Nome=@paramNomeAntigo";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
            }
        }

        public int BuscarIDDoCargoPorNome(string nome)
        {
            int idDesteCargo = -1;
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using(IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramNome", nome);

                comando.CommandText =
                    "SELECT IDCargo FROM Cargo WHERE Nome= @paramNome;";

                connection.Open();
                IDataReader reader = comando.ExecuteReader();

                if (reader.Read())
                {
                    idDesteCargo = int.Parse(reader["IDCargo"].ToString());
                }
                
            }
            return idDesteCargo;
        }

        public bool ValidarExistencia(string nome)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText =
                    "SELECT * FROM Cargo WHERE Nome = @paramNome";
                comando.AddParameter("paramNome", nome);

                connection.Open();

                IDataReader reader = comando.ExecuteReader();

                return reader.Read();
            }
        }
    }
}

