<%@ page import="java.util.List" %>
<%@ page import="com.example.DIgitalLedgerApp.Models.Debt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="RetailerNavbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The debts object and totalAmount are passed from the controller to this JSP via the model attribute --%>
<% List<Debt> debts = (List<Debt>) request.getAttribute("debts"); %>
<% Double totalAmount = (Double) request.getAttribute("totalamount"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Debt Customers</title>
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

    <!-- Page Title -->
    <h3>Debts</h3>

    <!-- Display Total Amount -->
    
        <p><strong>Total Debt Amount: </strong>${totalamount}</p>
    

    <!-- Conditional Message if no debts -->
    <c:if test="${empty debts}">
        <p>No debts found for this retailer.</p>
    </c:if>

    <!-- Display debts in a table -->
    <c:if test="${not empty debts}">
        <table>
            <thead>
                <tr>
                    <!--  <th>Debt ID</th> -->
                    
                    <th>Customer Name</th>
                    <th>Amount</th>
                    <th>Send Sms</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="debt" items="${debts}">
                    <tr>
                        <!-- <td>${debt.id}</td> -->
                       
                     <td>${debt.customer.getUsername()}</br>
                     <p>Mobile: ${debt.customer.getMobileNumber()}</p><p>Address: ${debt.customer.address}</p></td> <!-- Assuming 'name' is an attribute of the Customer object -->
                     <td>${debt.amount}</td>
                     <td><button>Remind</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>
