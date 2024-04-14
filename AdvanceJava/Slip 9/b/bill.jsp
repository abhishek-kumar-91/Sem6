<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%
    // Retrieve session
    HttpSession session = request.getSession(true);

    // Retrieve page 1 and page 2 totals from session
    Double page1Total = (Double) session.getAttribute("page1Total");
    Double page2Total = (Double) session.getAttribute("page2Total");

    // Calculate total bill
    double totalBill = page1Total + page2Total;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bill - Online Shopping Mall</title>
</head>
<body>
    <h1>Bill Summary</h1>
    <p>Page 1 Total: $<%= page1Total %></p>
    <p>Page 2 Total: $<%= page2Total %></p>
    <p>Total Bill: $<%= totalBill %></p>
</body>
</html>
