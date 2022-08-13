<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>
<div class="top">
    <div class="back" style="background: url(images/glav.jpg)">
        <div class="content">
            <p class="desc">23 января 1959 года группа туристов во главе
                с Игорем Дятловым отправилась в поход по Уральским горам,
                из которого никто не вернулся. Смерть девяти туристов стала одной из загадок века.
            </p>
            <hr>
            <p class="desc_go">
                Отправляйся в гущу событий и узнай, что там произошло
            </p>
            <div class align="center">
                <audio src="images/m.mp3" id="audio"></audio>
                <button type="button" class="buttonSwagee" onclick="soundClick()">Включить музыку</button>
            </div>
            <form class="form_go" method="get" action="go">
                <label class="label_name" for="name">
                    <input class="form_input" type="text" name="name" id="name" placeholder="Ваше имя" required>
                </label>
                <br>
                <button class="form_button">Начать</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
