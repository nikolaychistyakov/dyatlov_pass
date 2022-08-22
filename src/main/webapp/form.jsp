
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"
         isELIgnored="false"
%>
<form name="form_go" class="form_go" method="get" action="${pageContext.request.contextPath}/choiceAct">
    <input id="act" type="hidden" name="act" value="<%=request.getParameter("act")%>">
    <fieldset name="fieldset">
        <legend>Выберите действие:</legend>
        <div class="form_radio">
            <input id="next" type="radio" name="action" value="next" checked>
            <label for="next"><%=request.getParameter("descAction1")%></label><br>
            <input id="void" type="radio" name="action" value="void">
            <label for="void"><%=request.getParameter("descAction2")%></label><br>
            <input id="back" type="radio" name="action" value="back">
            <label for="back"><%=request.getParameter("descAction3")%></label>
        </div>
        <div>
            <button class="form_button" name="form_button">Выбрать</button>
        </div>
    </fieldset>
</form>
