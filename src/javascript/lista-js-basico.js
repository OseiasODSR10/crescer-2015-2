//Exercicio 1
 function daisyGame (numero) {
    if(numero%2 === 0){
     console.log("Love me not");
   }else{
     console.log("Love me");
   }
 }
//Exercicio 2
 function maiorTexto(textos){
   var maior = textos[0];
   for (var i=0; i<textos.length; i++) {
     if(textos[i].length > maior.length){
       maior = textos[i];
     }
   }
   return maior;
 }
//Exercicio 3
function imprime(instrutores, funcao){
  try{
    for(var i=0; i<instrutores.length; i++){
        funcao(instrutores[i]);
    }
  }catch (err){
    alert( "Jabulani: \nTypeError: number is not a function");
  }
}
//Exercicio 4
//Funcao auxiliar
function fibonacci(numero){
  if(numero < 2){
    return numero;
  }
  return fibonacci(numero - 1) + fibonacci(numero-2);
}
//Funcao da soma
function fiboSum(n){
  var somaF = 0;
  for(var i=0; i<=n; i++){
    somaF = somaF + fibonacci(i);
  }
  return somaF;
}
//Exercicio 5
function excelis(ref){
  if(ref.charCodeAt(i) >= 65 && ref.charCodeAt(i) <= 90){
    ref = ref.split('').reverse().join('');
    var pos = 0;
    var num = 0;
    for(var i=0; i<ref.length; i++){
      num = ref.charCodeAt(i) - 64;
      pos = pos + (num*Math.pow(26, i));
    }
  }
  else{
    pos = "Não é uma posição válida."
  }
  return pos;
}
//Exercício 6
function queroCafe(mascada, listaDePrecos){
  var listaPr = "";
  //usar filter() e sort()
  listaDePrecos.sort(sortNumber);
  for(var i=0; i<listaDePrecos.length; i++){
    if(listaDePrecos[i] <= mascada){
      listaPr = listaPr===""? listaPr + listaDePrecos[i] : listaPr + "," +listaDePrecos[i];
    }
  }
  return listaPr;
  //Arrumar: usar join.
}

function sortNumber(a,b) {
    return a - b;
}
