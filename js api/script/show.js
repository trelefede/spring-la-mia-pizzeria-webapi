const URLParams = new URLSearchParams(window.location.search);
const pizzaId = URLParams.get('id');

showPizza(pizzaId);

function showPizza(pizzaId) {
    axios
        .get("http://localhost:8080/api/pizze/" + pizzaId)
        .then((response) => {
            console.log('richiesta ok', response);
            const pizza = response.data;
            const ingredienti = pizza.ingredienti;
            const offerte = pizza.offerte;
            document.querySelector('#show_pizza').innerHTML = `
            
            <h1>Dettaglio Pizza</h1>
            <div class="row">
                <div class="col-4">
                    <h3>${pizza.name}</h3>
                    <img alt="${pizza.name}" width="150" height="150" src="${pizza.imgUrl}">
                    <p>${pizza.description}</p>
                    <p>${pizza.price}</p>
                </div>
            </div>

            `
        })
        .catch((response) => {
            console.error('Errore chiamata', response);
        })
}