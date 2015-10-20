function Item (sku, descricao, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = 0;
  this.valorUnitario = valorUnitario;
};

function CarrinhoDeCompras(){
  this.itensNoCarrinho =
  [];
}

CarrinhoDeCompras.prototype.adicionarItemAoCarrinho = function(item){
  this.itensNoCarrinho.push(item);
};
CarrinhoDeCompras.prototype.removerItemDoCarrinhoPeloSKU = function(sku){
  this.itensNoCarrinho.forEach(function (elem){
    if(elem.sku === sku){
      this.itensNoCarrinho.splice(this.itensNoCarrinho.indexOf(elem),1);
    }
  })
}
