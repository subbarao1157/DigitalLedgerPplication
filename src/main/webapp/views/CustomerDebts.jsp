<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="customerNavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Debts</title>
     <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Total Debt : ${totalamount}</h1>
    <table>
        <thead>
            <tr>
                
                <th>Retailer</th>
                <th>Amount</th>
                <th>Payment</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${debts}" var="debt">
                <tr>
                    <td>${debt.retailer.name} </br><p>Shop Name:  ${debt.retailer.shopname}</p><p>Proprietor Mobile:  ${debt.retailer.mobile}</p></td>
                    <td>${debt.amount}</td>
                    <td><button>Tap To Pay</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
    