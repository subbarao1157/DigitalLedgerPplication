<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Registration</title>
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
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .registration-container {
            width: 100%;
            max-width: 400px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center;
        }

        .registration-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
        }

        .registration-container form {
            display: flex;
            flex-direction: column;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }

        .register-button {
            background-color: #2ea44f;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .register-button:hover {
            background-color: #22863a;
        }

        .login-link {
            margin-top: 15px;
            font-size: 14px;
            color: #0366d6;
            text-decoration: none;
        }

        .login-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="registration-container">
        <h2>Retailer Registration</h2>
        <form action="/registerRetailer" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="shopname">Shop Name</label>
                <input type="text" id="shopname" name="shopname" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" id="description" name="description">
            </div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input type="text" id="mobile" name="mobile" required>
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
            <div class="form-group">
                <label for="shopAddress">Shop Address</label>
                <input type="text" id="shopAddress" name="shopAddress" required>
            </div>
            <button type="submit" class="register-button">Register</button>
        </form>
        <a href="login" class="login-link">Already have an account? Log in</a>
    </div>
</body>
</html>
