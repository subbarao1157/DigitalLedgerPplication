<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="customerNavbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Complaint Form</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0;">

    <div class="container" style="padding: 20px;">
        <div class="profile-card" style="max-width: 500px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); background-color: #f9f9f9;">
            <h2 style="margin-top: 0; text-align: center;">Complaint Form</h2>
            
            <form action="submitComplaint.jsp" method="post">
                <div class="form-group" style="margin-bottom: 15px;">
                    <label for="name" style="font-weight: bold; display: block; margin-bottom: 5px;">Your Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter your name" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;">
                </div>

                <div class="form-group" style="margin-bottom: 15px;">
                    <label for="email" style="font-weight: bold; display: block; margin-bottom: 5px;">Your Email</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;">
                </div>

                <div class="form-group" style="margin-bottom: 15px;">
                    <label for="complaint" style="font-weight: bold; display: block; margin-bottom: 5px;">Your Complaint</label>
                    <textarea id="complaint" name="complaint" rows="4" placeholder="Describe your complaint" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;"></textarea>
                </div>

                <button type="submit" class="btn-submit" style="width: 100%; padding: 10px; font-size: 16px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;">Submit</button>
            </form>
        </div>
    </div>

</body>
</html>
