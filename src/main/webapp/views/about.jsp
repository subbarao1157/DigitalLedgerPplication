<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .about-container {
            width: 80%;
            max-width: 600px;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin: 40px auto;
        }
        h1 {
            font-size: 24px;
            margin-bottom: 15px;
            color: #333;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
            color: #555;
        }
    </style>
</head>
<body>
    <!-- Include the Navbar -->
    <jsp:include page="publicNavbar.jsp" />

    <!-- About Section -->
    <div class="about-container">
        <h1>About Us</h1>
        <p>Welcome to our Digital Ledger Application! Our platform simplifies financial management by offering streamlined debt tracking, reminders, and online payment integration. Designed for customers, retailers, and admins, we strive to make managing your finances as easy as possible.</p>
        <p>Our mission is to bring transparency and efficiency to personal and business finances.</p>
    </div>
</body>
</html>
    