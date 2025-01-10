<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select Role</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
            margin-top: 50px;
        }
        h1 {
            color: #333;
        }
        .button-container {
            margin-top: 30px;
        }
        .role-button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 15px 30px;
            font-size: 16px;
            cursor: pointer;
            margin: 10px;
            border-radius: 5px;
        }
        .role-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <!-- Include the Navbar -->
    <jsp:include page="publicNavbar.jsp" />

    <h1>Select Your Role</h1>
    <p>Please select whether you want to register as a Retailer or Customer.</p>
    <div class="button-container">
        <form action="retailerRegister" method="get">
            <button type="submit" class="role-button">Retailer</button>
        </form>
        <form action="customerRegister" method="get">
            <button type="submit" class="role-button">Customer</button>
        </form>
    </div>
</body>
</html>
