// Create a user object
const user = {
    name: "John Doe",
    email: "john.doe@example.com",
    age: 25
};

// Function to change the name
function changeName(newName) {
    user.name = newName;
}

// Function to update the email
function updateEmail(newEmail) {
    user.email = newEmail;
}

// Function to calculate the user's birth year
function calculateBirthYear() {
    const currentYear = new Date().getFullYear();
    return currentYear - user.age;
}

// Test the functions
console.log("Original User:", user);

changeName("Jane Smith");
console.log("After Name Change:", user);

updateEmail("jane.smith@example.com");
console.log("After Email Update:", user);

const birthYear = calculateBirthYear();
console.log("User's Birth Year:", birthYear);
