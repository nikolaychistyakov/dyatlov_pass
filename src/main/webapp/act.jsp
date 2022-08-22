<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ page import="com.xyc.InitActs" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.xyc.Act" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Map<String, Act> acts = InitActs.getActs();%>
<% String act = String.valueOf(session.getAttribute("act"));%>
<jsp:include page="header.jsp"/>
<body>
<div class="top">
    <div class="back" style="background: url('images/<%=acts.get(act).getImage()%>');background-size: 1280px 720px">
        <div class="content_2">
            <p class="desc_act" id="desc_act_title">
                <%=acts.get(act).getTitleAct()%>
            </p>
            <p class="desc" id="desc_before">
                <%=acts.get(act).getTitleBefore()%>
            </p>
            <hr>
            <p class="desc" id="desc_after">
                <%=acts.get(act).getTitleAfter()%>
            </p>
            <jsp:include page="form.jsp">
                <jsp:param name="act" value="<%=acts.get(act).getId()%>"/>
                <jsp:param name="descAction1" value="<%=acts.get(act).getDescAction().get(0)%>"/>
                <jsp:param name="descAction2" value="<%=acts.get(act).getDescAction().get(1)%>"/>
                <jsp:param name="descAction3" value="<%=acts.get(act).getDescAction().get(2)%>"/>
            </jsp:include>
            <jsp:include page="foot.jsp"/>
        </div>

    </div>
</div>

<jsp:include page="footer.jsp"/>
