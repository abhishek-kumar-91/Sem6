<%
    int number = Integer.parseInt(request.getParameter("number"));
    int sum = 0;
    for (int i = 1; i < number; i++)
        if (number % i == 0) sum += i;
    boolean isPerfect = (sum == number);
%>
<%= isPerfect ? number + " is a perfect number." : number + " is not a perfect number." %>
