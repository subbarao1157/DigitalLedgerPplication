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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }

        /* Navbar Styling */
        .navbar {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #333;
            padding: 5px 12px;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 14px 20px;
            font-size: 16px;
        }
        .navbar a:hover {
            background-color: #575757;
            border-radius: 4px;
        }
        .logo {
            display: flex;
            align-items: center;
        }
        .logo img {
            height: 40px;
            margin-right: 10px;
        }

        .form-container {
            width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-top: 80px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .form-group button {
            width: 100%;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
        }

        .form-group button:hover {
            background-color: #218838;
        }

        .login-link {
            display: block;
            margin-top: 15px;
            font-size: 14px;
            color: #0366d6;
            text-decoration: none;
        }

        .login-link:hover {
            text-decoration: underline;
        }

        #error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="logo">
            <a href="/"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdmmfqIxacZcqJY1FM8HUGoWlomwjyBoUbUw&s" alt="Get Book Logo"></a>
        </div>
        <div>
            <a href="/login">Login</a>
            <a href="/register">Register</a>
            <a href="/about">About</a>
            <a href="/contact">Contact</a>
        </div>
    </div>

    <!-- Form container -->
    <div class="form-container">
        <h1>Sign Up</h1>
        <form action="/registerCustomer" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="tel" id="mobile" name="mobileNumber" pattern="[0-9]{10}" title="Enter a valid 10-digit mobile number" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" required>
                <div id="error" class="error"></div>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required>
            </div>

            <div class="form-group">
                <label for="passkey">Pass Key</label>
                <input type="text" id="passkey" name="passkey" required>
            </div>

            <div class="form-group">
                <button type="submit">Sign Up</button>
            </div>
        </form>

        <a href="login" class="login-link">Already have an account? Log in</a>
    </div>

</body>
</html>
