<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Page Navbar</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 0.5rem 1rem;
            color: white;
        }
        .navbar .logo {
            font-size: 1.5rem;
            font-weight: bold;
        }
        .navbar .nav-links {
            display: flex;
            gap: 1rem;
        }
        .navbar .nav-links a {
            color: white;
            text-decoration: none;
            padding: 0.5rem 1rem;
            transition: background-color 0.3s;
        }
        .navbar .nav-links a:hover {
            background-color: #555;
            border-radius: 5px;
        }
        @media (max-width: 768px) {
            .navbar .nav-links {
                flex-direction: column;
                align-items: flex-end;
            }
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
    <nav class="navbar">
        <div class="logo">
            <a href="/retailer/">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdmmfqIxacZcqJY1FM8HUGoWlomwjyBoUbUw&s" alt="Retailer Logo">
            </a>
        </div>
        <div class="nav-links">
            <a href="/logout">Logout</a>
            <a href="profile">Profile</a>
            <a href="addDebt">Add Debt</a>
            <a href="showDebts">Show Debts</a>
            <a href="raiseComplaint">Raise Complaint</a>
        </div>
    </nav>
</body>
</html>
    