

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
  this.itensNoCarrinho = [];
  this.precoTotal = 0;
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
  for (var i=0;i<this.itensNoCarrinho.length;i++) {
    var elemAtual = this.itensNoCarrinho[i];
    if (elemAtual.sku === sku) {
      elemAtual.quantidade = qtd;
    }
  }

  /*var item = this.itensNoCarrinho.filter(function(elem){
    return elem.sku === sku;
  })[0];
  item.quantidade = qtd;
  this.removerItemDoCarrinhoPeloSKU(sku);
  this.adicionarItemAoCarrinho(item);*/
};

CarrinhoDeCompras.prototype.calcularTotal = function(){
  this.precoTotal = this.itensNoCarrinho.reduce(function (acumulador, elemAtual){
    return acumulador + elemAtual.calcularSubTotal();
  }, 0);
};

CarrinhoDeCompras.prototype.sortearDesconto = function(){
  var numeroSorte = Math.random();
  if(numeroSorte < 0.4){
    this.aplicarDesconto();
  }
};

CarrinhoDeCompras.prototype.aplicarDesconto = function(){
  this.precoTotal = (this.precoTotal*0.9);
};

CarrinhoDeCompras.prototype.forcarCompra = function() {
  if (!this.intervalo) {
    // var self = this;
    this.intervalo = setInterval(function() {
      this.itensNoCarrinho.forEach(function(elem) {
        elem.valorUnitario += elem.valorUnitario * .1;
      });
    }.bind(this), 5000);
  }
};

CarrinhoDeCompras.prototype.concluirPedido = function() {
  clearInterval(this.intervalo);
  // remover propriedade intervalo do objeto
  delete this.intervalo;
};
