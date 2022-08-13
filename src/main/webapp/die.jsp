<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<% String name = (String) session.getAttribute("name"); %>

<body>
<div class="top">
    <div class="back" style="background: url('images/end.jpg');background-size: 1280px 720px">
    <div class="content_end">
        <p class="desc_act">
            END
        </p>
        <p class="desc">
            <%=name.toUpperCase()%>, БОЛЬШЕ ВАС НИКТО НЕ ВИДЕЛ
        </p>
        <form class="form_go" method="get" action="/startNewDie">
            <button class="form_button">Начать заново</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>
