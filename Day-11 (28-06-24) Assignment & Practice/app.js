/* function sum(a, b) {
    console.log("Sum:", a + b)
}

sum(5, 5) */
let name1 = "Chirag"
let name2 = "Vinod"
let name3 = "Noman"
let names = `Aaryan, Arush, Ananya, ${name1}, ${name2}, ${name3}`
// names += ", " + name1 + ", " + name2 + ", " + name3

// console.log(names);

// conditional statements
/* let a = 5;
let b = 6;
if(a < b) {
    console.log("a is smaller"); //
} else if(a > b) {
    console.log("a is bigger");
} else {
    console.log("Both r equal");
} */

// Loops

/* for (let i = 0; i < 5; i++) {
    console.log(i);
} */

let arr = [3, 4, "Aaryan", true, false, "Aarush", 45];
arr.push(34);

/* for (const obj of arr) {
    console.log(obj)
} */
/* arr.filter(e => e % 2 == 0).forEach(e => console.log(e))
arr.map(e => e * 2).forEach(e => console.log(e))
arr.reverse().forEach(e => console.log(e)) */

let arr2 = ["second"]

// TASK: arr2 --> [arr + "second"]
arr2 = [...arr, "middle", ...arr2]
// console.log(arr2);

// JSON
let obj = {
    name: "Aaryan",
    role: "Trainer",
    exp: 9,
    salary: 0
}

// console.log(obj.name);
let a, middle, b
[a, b, ...middle] = ["Aaryan", "bla", "bla", "bla", "Arush"];
// let { name } = {name: "Aaryan"}
// console.log(name);



