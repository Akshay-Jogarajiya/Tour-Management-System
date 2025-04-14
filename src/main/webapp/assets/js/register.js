function validatePasswords() {

    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    return true; 
}

function togglePasswordVisibility() {

    var passwordField = document.getElementById("password");
    var confirmPasswordField = document.getElementById("confirmPassword");
    var showPasswordCheckbox = document.getElementById("showPassword");

    if (showPasswordCheckbox.checked) {

        passwordField.type = "text"; 
        confirmPasswordField.type = "text"; 
    } 
    else {

        passwordField.type = "password"; 
        confirmPasswordField.type = "password"; 
    }
}