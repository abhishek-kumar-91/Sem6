<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>
    
    <%
        // Get the number from the request parameter
        int number = Integer.parseInt(request.getParameter("number"));
        
        // Calculate the sum of the first and last digit
        int lastDigit = number % 10;
        int firstDigit = 0;
        while (number != 0) {
            firstDigit = number % 10;
            number /= 10;
        }
        int sum = firstDigit + lastDigit;
    %>
    
    <p style="color: red; font-size: 18px;">Sum of first and last digit of <%= number %> is <%= sum %></p>
</body>
</html>
