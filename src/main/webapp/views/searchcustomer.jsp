<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "RetailerNavbar.jsp" %>
<%
    String str = (String) request.getAttribute("Notfound");
    if (str != null && !str.isEmpty()) {
        str += " is not a Customer";
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Form</title>
</head>
<body>
    <div style="text-align: center;">
        <h2>Search Customer</h2>
        
        <% if (str != null && !str.isEmpty()) { %>
            <p style="color: red;"><%= str %></p>
        <% } %>
        
        <form action="submit" method="POST" style="display: flex; flex-direction: column; align-items: center;">
            <input type="text" name="searchQuery" placeholder="Enter search query" required style="padding: 10px; font-size: 16px; margin-bottom: 10px; width: 300px; border-radius: 5px; border: 1px solid #ccc;">
            <button type="submit" style="padding: 10px 20px; font-size: 16px; cursor: pointer; background-color: #007BFF; color: white; border: none; border-radius: 5px;">Submit</button>
        </form>
    </div>
</body>
</html>
