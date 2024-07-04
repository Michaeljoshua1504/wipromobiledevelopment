function clickme() {
    let a = document.getElementById("a").value;
    let b = document.getElementById("b").value;

    // alert(Number(a) + Number(b));
    document.getElementById("result").innerText = "Result: " + (Number(a) + Number(b))
}