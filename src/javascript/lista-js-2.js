var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

function ordenaPorNacionais(clubesArray){
  return clubesArray.sort(ordenarPorIndice(clubesArray, 0));

  /*
  return clubes.sort(
     (x,y) => x.titulos[0].qtd < y.titulos[0].qtd
  );
  */
};

function ordenaPorContinentais(clubesArray){
  return clubesArray.sort(ordenarPorIndice(clubesArray, 1));
};

function ordenaPorMundiais(clubesArray){
  return clubesArray.sort(ordenarPorIndice(clubesArray, 2));
};

/*
function somarPorNacionais(clubesArray){
  return somarTitulos(clubesArray, 0);
};

function somarPorContinentais(clubesArray){
  return somarTitulos(clubesArray, 1);
};

function somarPorMundiais(clubesArray){
  return somarTitulos(clubesArray, 2);
};
*/

/* Duplicação do código
function nacionaisDescendente (a,b){
  return a.titulos[0].qtd<b.titulos[0].qtd;
};

function continentaisDescendente (a,b){
  return a.titulos[1].qtd<b.titulos[1].qtd;
};

function mundiaisDescendente (a,b){
  return a.titulos[2].qtd<b.titulos[2].qtd;
};

function apenasOsMelhores(clubesArray){
  var osMelhores = [];
  clubesArray.forEach(
    function(elem){
      if(elem.titulos[0].qtd>18){
        osMelhores.push(elem);
      }
    });
    return osMelhores;
};
*/

function apenasOsMelhores(clubesArray){
  return clubesArray.filter(function (elem){
    return elem.titulos[0].qtd > 18;
  });
}

function somarTitulos(clubesArray, j){
  var soma = 0;
  for(var i=0; i<clubesArray.length; i++){
    soma = soma + clubesArray[i].titulos[j].qtd;
  }
  return soma;
};

function somarPorTodosTitulos(clubesArray){
var soma=0;
  for (var j=0; j<clubesArray[0].titulos.length; j++){
    soma = soma + somarTitulos(clubesArray, j);
  }
  return soma;
};

function ordenarPorIndice(clubesArray, indice){
  return clubes.sort(function(elem1, elem2){
    return elem1.titulos[indice].qtd < elem2.titulos[indice].qtd;
  });
}
function somarPorTitulos(clubesArray, indice){
    return clubes.reduce(function(acumulador, elemAtual){
      return acumulador + elemAtual.titulos[indice].qtd;
    }, 0);
}

function somaPorNacionais(clubesArray){
  return somarPorTitulos(clubesArray, 0);
}
function somaPorContinentais(clubesArray){
  return somarPorTitulos(clubesArray, 1);
}



// ======== Exemplos aula 3 ==========

//Modifica o clube também, depois retorna
var teams = clubes.map(function (clube){
  // clube.nome += ' FC' --> Uma das formas
  return clube.nome += ' FC', clube;
});

//Este retorna um novo objeto
var teams2 = clubes.map(function (clube){
  // clube.nome += ' FC' --> Uma das formas
  return {
    nome: clube.nome += ' FC',
    titulos: clube.titulos
  }
});

function mediaDeIdadeDosClubes(clubesArray){
  // Também pode-se usar map() junto com o reduce()
  var soma = clubesArray.reduce(function(acumulador, elem){
    var idade = new Date().getFullYear() - elem.fundacao.getFullYear();
    return acumulador + idade;
  },0);
  return soma/clubesArray.length;
};

function Elfo(nome, flechas) {

  this.nome = nome;
  this.flechas = flechas || 42;

  Object.defineProperty(this, 'flechas', {
    writable: false
  });
};

Elfo.prototype.atirarFlecha = function() {
  console.log('atirando flecha...');
};

function ElfoNoturno(nome, flechas){
  // Elfo.call(this, nome, flechas);
  Elfo.apply(this, arguments);
}

//Elfo noturno extends Elfo
ElfoNoturno.prototype = Object.create(Elfo.prototype);

//override
// ElfoNoturno.prototype.atirarFlecha = function(dawrf){ console.log('novo atirar flechas')} ;

// static
ElfoNoturno.mediaDeAlturaDosElfosNoturno = function(){
  return 2.15
};

String.prototype.comecaComB = function() {
  return this.toUpperCase()[0] === 'B';
};
