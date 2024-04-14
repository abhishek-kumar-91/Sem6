<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>

<%
    // Get username and password from request parameters
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if username and password are the same
    if (StringUtils.equals(username, password)) {
        // Redirect to Login.html with success message
        response.sendRedirect("Login.html?message=Login+Successfully");
    } else {
        // Redirect to Error.html with error message
        response.sendRedirect("Error.html?message=Login+Failed");
    }
%>
