<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page 1 - Online Shopping Mall</title>
</head>
<body>
    <h1>Page 1 - Select Items</h1>
    <form action="page2.jsp" method="post">
        <label>Item 1: $10 <input type="checkbox" name="item1" value="10"></label><br>
        <label>Item 2: $20 <input type="checkbox" name="item2" value="20"></label><br>
        <label>Item 3: $30 <input type="checkbox" name="item3" value="30"></label><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
