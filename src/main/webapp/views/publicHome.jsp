<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home - Digital Ledger Accounts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }
        .content {
            margin: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .content h1 {
            text-align: center;
        }
        .content p {
            line-height: 1.6;
            margin: 10px 0;
        }
        .features {
            margin-top: 20px;
        }
        .features ul {
            list-style-type: square;
            padding-left: 20px;
        }
        .features ul li {
            margin: 5px 0;
        }
        .footer {
            text-align: center;
            background-color: #333;
            color: white;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <!-- Include Navbar -->
    <jsp:include page="publicNavbar.jsp" />

    <div class="content">
        <h1>About Digital Ledger Accounts</h1>
        <p>
            Our Digital Ledger Accounts application simplifies the way you manage and track financial transactions. 
            Whether you're a retailer or a customer, our system is designed to provide a seamless and efficient way 
            to handle debts, reminders, and online payments.
        </p>
        <div class="features">
            <h2>Key Features:</h2>
            <ul>
                <li>Track customer debts and payments in real-time.</li>
                <li>Send automated reminders using Twilio integration.</li>
                <li>Secure online payments through Razorpay integration.</li>
                <li>Role-based access for Retailers, Customers, and Admins.</li>
                <li>Comprehensive reports and payment history tracking.</li>
