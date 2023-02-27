pizzeList();

function pizzeList() {
    axios
        .get("http://localhost:8080/api/pizze")
        .then((response) => {
            console.log("richiesta ok", response);
            response.data.forEach(pizza => {
                document.querySelector('#pizze_table').innerHTML += `

            <tr>
                <td>${pizza.name}</td>
                <td>${pizza.description}</td>
                <td><img class="img-thumbnail" width="150" height="150" src="${pizza.imgUrl}"></img></td>
                <td>${pizza.price}</td>
                
                <td><a class="btn btn-primary" href="/pizze/${pizza.id}"><i class="fa-solid fa-magnifying-glass"></i></a></td>
                <td><a class="btn btn-primary" href="/pizze/edit/${pizza.id}"><i class="fa-regular fa-pen-to-square"></i></a></td>
                <td>
                    <button class="btn btn-primary" onclick="deletePizza(${pizza.id})" onClick="window.location.reload()"><i class="fa-solid fa-trash-can"></i></button>
                </td>
			      
			</tr>
            
            `
            });
        })
        .catch((response) => {
            console.error('Errore chiamata', response);
        })
}

function deletePizza(pizzaId) {
    const choise = confirm('Sei sicuro di voler eliminare questa pizza?');

    if (choise) {
        axios
            .delete("http://localhost:8080/api/pizze/" + pizzaId).then((response) => {
                window.location.reload(); //lista aggiornata pizze
            })
            .catch((response) => {
                console.error('Errore chiamata', response);
            })
    }
}