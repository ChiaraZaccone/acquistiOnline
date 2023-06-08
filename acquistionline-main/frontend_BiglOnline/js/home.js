// vai alla pagina prenotazioni
let btnOrdinaArticolo = document.getElementById('btnOrdinaArticolo');

function goToPaginaPrenotazione(){
  window.location.replace('./bookForm.html');
}

btnOrdinaArticolo.addEventListener('click',goToPaginaPrenotazione)

//mostra elenco dei voli
let btnElencoArticoli = document.getElementById('btnElencoArticoli');

function mostraTabellaArticoli(){
  fetch('http://localhost:8080/acquistionline/magazzini')
  .then(response => response.json())
  .then(data => {
      let table = `
          <tr>
              <th>Nome articolo</th>
              <th>Descrizione</th>
              <th>Prezzo</th>
             
          </tr>
      `;
  
      for(let i = 0; i < data.length; i++) {
  
          table +=`
              <tr>
                  <td>${data[i].nome_articolo}</td>
                  <td>${data[i].descrizione}</td>
                  <td>${data[i].prezzo_unitario}</td>
                 
              </tr>
          `;
      }
      
      let tabella = document.getElementById('tableArticoli')
      tabella.classList.add('nascondi');
      tabella.innerHTML = table;
  })
}
  
btnElencoArticoli.addEventListener('click',mostraTabellaArticoli)

//mostra elenco biglietti
let btnElencoOrdini = document.getElementById('btnElencoOrdini');

function mostraTabellaOrdini(){
  //recupero i dati dalla session storage
  let utConnessoJSON = localStorage.getItem("data");
  let utConnesso = JSON.parse(utConnessoJSON)

  //prendo i dati che mi mancano dal form
  let codCliente = utConnesso.codCliente;
  let nome = utConnesso.nome;
  let cognome = utConnesso.cognome;

  fetch('http://localhost:8080/acquistionline/carrelli/'+codCliente)
  .then(response => response.json())
  .then(data => {
      let table = `
      <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Tipo pagamento</th>
        <th>Codice articolo</th>
        <th>Quantità articoli</th>
        <th>Prezzo unitario/th>
        <th>Prezzo totale</th>
      </tr>
      `;
  
    for(let i = 0; i < data.length; i++) {
  
    table += `
      <tr>
        <td>${nome}</td>
        <td>${cognome}</td>
        <td>${data[i].tipo_pagamento}</td>
        <td>${data[i].cod_articolo}</td>
        <td>${data[i].qt_articoli}</td>
        <td>${data[i].prezzo_unitario}</td>
        <td>${data[i].prezzo_unitario * data[i].qt_articoli}</td>
      </tr>
        `;
    }
  
    document.getElementById('tableOrdini').innerHTML = table;
  })
}

btnElencoOrdini.addEventListener('click',mostraTabellaOrdini)

let btnLogin = document.getElementById('btnLogin');

function goToLogin(){
  window.location.replace('./login.html');
}

btnLogin.addEventListener('click',goToLogin)

