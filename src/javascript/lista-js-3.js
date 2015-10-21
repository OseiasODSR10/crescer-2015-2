function Item (sku, descricao, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = 0;
  this.valorUnitario = valorUnitario;
};

Item.prototype.calcularSubTotal = function (){
  return this.valorUnitario*this.quantidade;
};

function CarrinhoDeCompras(){
  this.itensNoCarrinho =
  [];
};

CarrinhoDeCompras.prototype.adicionarItemAoCarrinho = function(item){
  this.itensNoCarrinho.push(item);
};
CarrinhoDeCompras.prototype.removerItemDoCarrinhoPeloSKU = function(sku){
  this.itensNoCarrinho = this.itensNoCarrinho.filter(function(elem) {
    return elem.sku !== sku;
  });
};
CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, qtd){
  var item = this.itensNoCarrinho.filter(function(elem){
    return elem.sku === sku;
  })[0];
  item.quantidade = qtd;
  this.removerItemDoCarrinhoPeloSKU(sku);
  this.adicionarItemAoCarrinho(item);
};

CarrinhoDeCompras.prototype.calcularTotal = function(){
  return this.itensNoCarrinho.reduce(function (acumulador, elemAtual){
    return acumulador + elemAtual.calcularSubTotal();
  }, 0);
}
