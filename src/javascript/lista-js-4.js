// ======== TEMA =========
// EXERCICIOS 9 LISTA 3
// LISTA 4
String.prototype.palindromo = function(){
  return this.split('').reverse().join('') == this;
};

Date.prototype.bissexto = function(){
  return (this.getFullYear() % 4 === 0 && this.getFullYear % 100 !== 0) || this.getFullYear % 400 === 0;
};

function CarrinhoDeComprasChantagista (){
  CarrinhoDeCompras.apply(this);
}

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

CarrinhoDeComprasChantagista.prototype.forcarCompra = function() {
  if (!this.intervalo) {
    // var self = this;
    this.intervalo = setInterval(function() {
      this.itensNoCarrinho.forEach(function(elem) {
        elem.valorUnitario += elem.valorUnitario * .1;
      });
    }.bind(this), 5000);
  }
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function() {
  clearInterval(this.intervalo);
  // remover propriedade intervalo do objeto
  delete this.intervalo;
};
