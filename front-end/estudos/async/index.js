function soma(num1, num2) {
    return num1 + num2;
}

console.log(soma(2, 2)) // 4

let response = await fetch(`https://api.com/api/user/${userId}`);
let userData = await response.json();

async function getUser(userId) {
    let response = await fetch(`https://api.com/api/user/${userId}`);
    let userData = await response.json();
    return userData.name; // nas linhas de return não é necessário usar await
}

exibeDadosUser(await getUser(1))
getUser(1).then(exibeDadosUser).catch(reject)

/*
function getUser(userId) {
    const userData = fetch(`https://api.com/api/user/${userId}`)
        .then(response => response.json())
        .then(data => console.log(data.name))
}

getUser(1);*/
