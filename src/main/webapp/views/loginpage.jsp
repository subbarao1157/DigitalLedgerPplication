<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page with Google Sign-In</title>
</head>
<body style="font-family: Arial, sans-serif; display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; background-color: white; margin: 0;">
    
    <!-- Login Card -->
    <div style="border: 1px solid #ccc; border-radius: 8px; padding: 20px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); width: 300px; text-align: center;">
        <h2 style="margin-bottom: 20px;">Login</h2>
        
        <!-- Form for Username and Password -->
        <form action="/login" method="POST" style="display: flex; flex-direction: column; align-items: center;">
            <input type="text" placeholder="Username" name="username" style="width: calc(100% - 20px); padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;">
            <input type="password" name="password" placeholder="Password" style="width: calc(100% - 20px); padding: 10px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px;">
            <button type="submit" style="width: 100%; background-color: #4285F4; color: white; border: none; border-radius: 5px; padding: 10px; font-size: 16px; cursor: pointer; transition: background-color 0.3s;" 
                    onmouseover="this.style.backgroundColor='#357ae8'" 
                    onmouseout="this.style.backgroundColor='#4285F4'">
                Login
            </button>
        </form>

</br>
        <!-- OR Separator -->
        <div style="margin: 15px 0; position: relative;">
            <hr style="border: 0; border-top: 1px solid #ccc;">
            <span style="position: absolute; left: 50%; transform: translateX(-50%); background-color: white; padding: 0 10px; color: #888;">OR</span>
        </div>
</br>
</br>

        <!-- Google Sign-In Button -->
        <a href="/oauth2/authorization/google" style="text-decoration: none;">
            <button style="display: flex; align-items: center; background-color: #000000; color: white; border: none; border-radius: 5px; padding: 10px 20px; font-size: 16px; cursor: pointer; transition: background-color 0.3s; width: 100%;" 
                    onmouseover="this.style.backgroundColor='#000000'" 
                    onmouseout="this.style.backgroundColor='#000000'">
                <img src="https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png" 
                     alt="Google Logo" 
                     style="width: 20px; height: 20px; margin-right: 10px;">
                Continue with Google
            </button>
        </a>
    </div>
</body>
</html>