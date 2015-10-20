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
  return clubesArray.sort(nacionaisDescendente);
};

function ordenaPorContinentais(clubesArray){
  return clubesArray.sort(continentaisDescendente);
};

function ordenaPorMundiais(clubesArray){
  return clubesArray.sort(mundiaisDescendente);
};

function somarPorNacionais(clubesArray){
  return somarTitulos(clubesArray, 0);
};

function somarPorContinentais(clubesArray){
  return somarTitulos(clubesArray, 1);
};

function somarPorMundiais(clubesArray){
  return somarTitulos(clubesArray, 2);
};

function somarPorTodosTitulos(clubesArray){
var soma=0;
  for (var j=0; j<clubesArray[0].titulos.length; j++){
    soma = soma + somarTitulos(clubesArray, j);
  }
  return soma;
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

function somarTitulos(clubesArray, j){
  var soma = 0;
  for(var i=0; i<clubesArray.length; i++){
    soma = soma + clubesArray[i].titulos[j].qtd;
  }
  return soma;
};

function nacionaisDescendente (a,b){
  return a.titulos[0].qtd<b.titulos[0].qtd;
};

function continentaisDescendente (a,b){
  return a.titulos[1].qtd<b.titulos[1].qtd;
};

function mundiaisDescendente (a,b){
  return a.titulos[2].qtd<b.titulos[2].qtd;
};
