function togglePasswordVisibility() {
    var passwordField = document.getElementById("password");
    var showPasswordCheckbox = document.getElementById("showPassword");

    if (showPasswordCheckbox.checked) {
        passwordField.type = "text"; // Show password
    } else {
        passwordField.type = "password"; // Hide password
    }
}