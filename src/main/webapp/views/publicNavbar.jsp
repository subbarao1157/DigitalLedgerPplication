<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Navigation Bar</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .navbar {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #333;
            padding: 10px 20px;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 8px 16px;
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
    </style>
</head>
<body>
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
</body>
</html>