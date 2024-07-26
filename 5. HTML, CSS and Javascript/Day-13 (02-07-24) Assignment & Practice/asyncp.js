/* function myfunc() {
    console.log("hello world");
}

setTimeout(() => myfunc(), 3000); */

/* let mypromise = new Promise(function(resolve, reject) {
    resolve(); // success
    reject(); // error
})

// 3 states --> Pending, Fulfuilled, rejected
mypromise.then(
    function(value) {
        console.log("Success");
    },
    function (error) {
        console.log("Error");
    }
) */

//  it makes the function return a promise
async function myfunc(params) {
    return "Hello world";        
}

function myfunc2(params) {
    return Promise.resolve("Hello world");
}

myfunc2().then(
    function(value) {console.log("success")},
    function(error) {console.log("error")},
);

myfunc().then(
    function(value) {console.log("success")},
    function(error) {console.log("error")},
);