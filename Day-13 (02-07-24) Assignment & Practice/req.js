function getCat() {
    fetch("https://cataas.com/cat?json=true")
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.log(err));
}

async function dogfacts() {
    const data = await fetch("https://dogapi.dog/api/facts");
    return data.json();
}

getCat();
// dogfacts().then(res => console.log(res)).catch(err => console.log(err));