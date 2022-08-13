<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<% String name = (String) session.getAttribute("name"); %>
<% int exp = (int) session.getAttribute("exp"); %>
<% LocalDateTime date = LocalDateTime.now(); %>
<div class="foot">
    <p class="desc_footer"><%=name%>  <%=exp%></p>
</div>
