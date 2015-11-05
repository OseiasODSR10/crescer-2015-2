using Locadora.Dominio;
using System;
using System.Collections.Generic;

namespace Locadora.UI.CadastroDeJogo
{
    abstract class MenuDeJogo : TelaBase
    {
        private Dictionary<int, Categoria> menuCategorias;
        private Dictionary<int, Selo> menuSelos;

        public MenuDeJogo()
        {
            MontarMenuCategorias();
            MontarMenuSelo();
        }

        protected void AtualizarDadosDoJogo(Jogo jogo)
        {
            Console.WriteLine("Insira os dados do jogo:");
            string nome = LerNome();
            decimal preco = LerPreco();
            string descricao = LerDescricao();
            Selo selo = LerSelo();
            Categoria categoria = LerCaregoria();

            jogo.Nome = nome;
            jogo.Preco = preco;
            jogo.Descricao = descricao;
            jogo.Selo = selo;
            jogo.Categoria = categoria;
        }

        protected abstract void SalvarJogo(Jogo jogo);

        private decimal LerPreco()
        {
            while (true)
            {
                string preco = LerDados("Preço");
                decimal precoConvertido = 0;

                if (decimal.TryParse(preco, out precoConvertido))
                {
                    return precoConvertido;
                }

                ImprimirErro("Informe um preço válido...");
            }
        }

        private string LerNome()
        {
            while (true)
            {
                string nome = LerDados("Nome");

                if (String.IsNullOrWhiteSpace(nome))
                {
                    ImprimirErro("O nome é obrigatório.");
                }
                else
                {
                    return nome;
                }
            }
        }

        private string LerDescricao()
        {
            while (true)
            {
                string descricao = LerDados("Descrição");

                if (String.IsNullOrWhiteSpace(descricao))
                {
                    ImprimirErro("A descrição é obrigatória.");
                }
                else
                {
                    return descricao;
                }
            }
        }

        private Categoria LerCaregoria()
        {
            while (true)
            {
                Console.WriteLine("Escolha a categoria:");

                foreach (var cat in menuCategorias)
                {
                    Console.WriteLine(String.Format("{0} - {1}", cat.Key, Enum.GetName(typeof(Categoria), cat.Value)));
                }

                string valorEscolhido = LerDados("Escolher");
                int categoriaEscolhida = 0;

                if (int.TryParse(valorEscolhido, out categoriaEscolhida))
                {
                    if (menuCategorias.ContainsKey(categoriaEscolhida))
                    {
                        return (Categoria)categoriaEscolhida;
                    }
                }

                ImprimirErro("Categoria inválida...");
                Console.WriteLine();
            }
        }

        private Selo LerSelo()
        {
            while (true)
            {
                Console.WriteLine("Escolha o selo:");

                foreach (var sel in menuSelos)
                {
                    Console.WriteLine(String.Format("{0} - {1}", sel.Key, Enum.GetName(typeof(Selo), sel.Value)));
                }

                string valorEscolhido = LerDados("Escolher");
                int seloEscolhido = 0;

                if (int.TryParse(valorEscolhido, out seloEscolhido))
                {
                    if (menuCategorias.ContainsKey(seloEscolhido))
                    {
                        return (Selo)seloEscolhido;
                    }
                }

                ImprimirErro("Selo inválido...");
                Console.WriteLine();
            }
        }

        private void MontarMenuCategorias()
        {
            menuCategorias = new Dictionary<int, Categoria>();

            foreach (int item in Enum.GetValues(typeof(Categoria)))
            {
                menuCategorias.Add(item, (Categoria)item);
            }
        }

        private void MontarMenuSelo()
        {
            menuSelos = new Dictionary<int, Selo>();

            foreach (int item in Enum.GetValues(typeof(Selo)))
            {
                menuSelos.Add(item, (Selo)item);
            }
        }
    }
}
