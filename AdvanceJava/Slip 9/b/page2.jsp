<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%
    // Retrieve or create session
    HttpSession session = request.getSession(true);

    // Retrieve page 1 total from session, if available
    Double page1Total = (Double) session.getAttribute("page1Total");
    if (page1Total == null) {
        page1Total = 0.0;
    }

    // Retrieve selected items from page 1
    String[] selectedItems = request.getParameterValues("selectedItems");

    // Calculate page 2 total based on selected items
    double page2Total = page1Total;
    if (selectedItems != null) {
        for (String item : selectedItems) {
            page2Total += Double.parseDouble(item);
        }
    }

    // Store page 2 total in session
    session.setAttribute("page2Total", page2Total);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page 2 - Online Shopping Mall</title>
</head>
<body>
    <h1>Page 2 - Confirm Items</h1>
    <form action="bill.jsp" method="post">
        <input type="hidden" name="selectedItems" value="<%= Arrays.toString(selectedItems) %>">
        <p>Page 1 Total: $<%= page1Total %></p>
        <p>Page 2 Total: $<%= page2Total %></p>
        <input type="submit" value="Proceed to Checkout">
    </form>
</body>
</html>
