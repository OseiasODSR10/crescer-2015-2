var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
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

function ordenarPorIndice(clubes, indice){
  return clubes.sort(function(elem1, elem2){
    return elem1.titulos[indice].qtd < elem2.titulos[indice].qtd;
  });
}
function somarPorTitulos(clubes, indice){
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
