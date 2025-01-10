<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration</title>
    <script>
        function validateForm() {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const errorField = document.getElementById("error");

            if (password !== confirmPassword) {
                errorField.textContent = "Passwords do not match.";
                return false;
            }
            errorField.textContent = "";
            return true;
        }
    </script>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center; height: 100vh;">

    <!-- Navbar (extend across the full width) -->
    <nav style="width: 100%; background-color: #333; color: white; padding: 10px 0; text-align: center; position: fixed; top: 0; left: 0; z-index: 1000;">
        <a href="/" style="color: white; text-decoration: none; padding: 14px 20px; display: inline-block;">Home</a>
        <a href="/login" style="color: white; text-decoration: none; padding: 14px 20px; display: inline-block;">Login</a>
        <a href="/register" style="color: white; text-decoration: none; padding: 14px 20px; display: inline-block;">Register</a>
    </nav>

    <!-- Form container with margin-top for navbar -->
    <div class="form-container" style="width: 400px; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); margin-top: 80px;">
        <h1 style="text-align: center; margin-bottom: 20px; color: #333;">Sign Up</h1>
        <form action="/registerCustomer" method="post" onsubmit="return validateForm()">
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="firstname" style="display: block; font-weight: bold; margin-bottom: 5px;">First Name</label>
                <input type="text" id="firstname" name="firstname" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="lastname" style="display: block; font-weight: bold; margin-bottom: 5px;">Last Name</label>
                <input type="text" id="lastname" name="lastname" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="email" style="display: block; font-weight: bold; margin-bottom: 5px;">Email</label>
                <input type="email" id="email" name="email" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="mobile" style="display: block; font-weight: bold; margin-bottom: 5px;">Mobile</label>
                <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" title="Enter a valid 10-digit mobile number" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="password" style="display: block; font-weight: bold; margin-bottom: 5px;">Password</label>
                <input type="password" id="password" name="password" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <label for="confirmPassword" style="display: block; font-weight: bold; margin-bottom: 5px;">Confirm Password</label>
                <input type="password" id="confirmPassword" required style="width: calc(100% - 20px); padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
                <div id="error" class="error" style="color: red; font-size: 12px; margin-top: 5px;"></div>
            </div>
            <div class="form-group" style="margin-bottom: 15px;">
                <button type="submit" style="width: 100%; background-color: #28a745; color: white; border: none; padding: 10px; font-size: 16px; font-weight: bold; cursor: pointer; border-radius: 5px;">Sign Up</button>
            </div>
        </form>
    </div>
</body>
</html>
