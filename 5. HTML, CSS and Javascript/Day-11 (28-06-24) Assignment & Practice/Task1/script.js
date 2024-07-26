document.addEventListener("DOMContentLoaded", function() {
    console.log("JavaScript is running"); // Check if JS is running
    document.getElementById("loginForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission
        console.log("Form submitted"); // Check if form is being submitted

        // Set your own credentials here
        const validUsername = "josh"; // Replace with your desired username
        const validPassword = "0007"; // Replace with your desired password

        // Get entered credentials
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        console.log(`Entered Username: ${username}, Entered Password: ${password}`); // Check entered credentials

        // Check if entered credentials match
        if (username === validUsername && password === validPassword) {
            // Successful login
            console.log("Login successful"); // Check if credentials match
            document.getElementById("messageBox").textContent = "Login successful!";
            document.getElementById("messageBox").style.color = "green";
            // Redirect to welcome page or perform other actions
            setTimeout(function() {
                window.location.href = "welcome.html"; // Redirect to welcome page
            }, 1000); // Delay for 1 second
        } else {
            // Incorrect credentials
            console.log("Incorrect username or password"); // Check for incorrect credentials
            document.getElementById("messageBox").textContent = "Incorrect username or password. Please try again.";
            document.getElementById("messageBox").style.color = "red";
        }
    });
});

$(document).ready(function(){
    $(window).scroll(function(){
        // sticky navbar on scroll script
        if(this.scrollY > 20){
            $('.navbar').addClass("sticky");
        }else{
            $('.navbar').removeClass("sticky");
        }
        
        // scroll-up button show/hide script
        if(this.scrollY > 500){
            $('.scroll-up-btn').addClass("show");
        }else{
            $('.scroll-up-btn').removeClass("show");
        }
    });

    // slide-up script
    $('.scroll-up-btn').click(function(){
        $('html').animate({scrollTop: 0});
        // removing smooth scroll on slide-up button click
        $('html').css("scrollBehavior", "auto");
    });

    $('.navbar .menu li a').click(function(){
        // applying again smooth scroll on menu items click
        $('html').css("scrollBehavior", "smooth");
    });

    // toggle menu/navbar script
    $('.menu-btn').click(function(){
        $('.navbar .menu').toggleClass("active");
        $('.menu-btn i').toggleClass("active");
    });

    // typing text animation script
    var typed = new Typed(".typing", {
        strings: ["High School", "Intermediate", "Diploma", "Graduation"],
        typeSpeed: 100,
        backSpeed: 60,
        loop: true
    });
});