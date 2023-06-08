function Magazzini(id,id_magazzino, qt_disponibile, cod_articolo, nome_articolo,prezzo_unitario, descrizione) {
    this.id = id;
    this.id_magazzino = id_magazzino;
    this.qt_disponibilei = qt_disponibile;
    this.cod_articolo = cod_articolo;
    this.nome_articolo = nome_articolo;
    this.prezzo_unitario = prezzo_unitario;
    this.descrizione = descrizione;

}

const btn = document.getElementById('btnBook');

btn.addEventListener('click', createBooking);

function createBooking() {

    //recupero i dati dalla session storage
    let utConnessoJSON = localStorage.getItem("data");
    let utConnesso = JSON.parse(utConnessoJSON)

    //prendo i dati che mi mancano dal form
    let cod_articolo = utConnesso.cod_articolo;
    let id_magazzino = document.getElementById('inputIdMagazzino').value;
    let inputPagamento = document.getElementById('inputPagamento').value;
    let inputNumArticoli= document.getElementById('inputNumBiglietti').value;

    let articolo = new Magazzini(cod_cliente, inputPagamento, inputNumArticoli, id_magazzino);

    const dataSend = JSON.stringify(articolo);

    fetch('http://localhost:8080/acquistionline/magazzini', {
        method: 'POST', headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: dataSend
    })
    .then(response => {
        if(response.status == 201) {
            alert('hai acquistato un articolo!')
        }else if(response.status==500){
            alert('articolo non disponibile')
        }
    });

}
