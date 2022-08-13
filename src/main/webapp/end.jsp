<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<% String name = (String) session.getAttribute("name"); %>

<body>
<div class="top">
    <div class="back" style="background: url(images/aact8.jpg);background-size: 1280px 720px">
    <div class="content_2">
        <p class="desc_act">
            АКТ 8. END
        </p>
        <p class="desc">
            1 февраля 1959 вся тургруппа Дятлова погибает.
        </p>
        <form class="form_go" method="get" action="/startNew">
            <button class="form_button">Начать заново</button>
        </form>
    </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
