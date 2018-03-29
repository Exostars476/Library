<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>
<html>
<head>
    <title>Membres</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="page">
    <jsp:include page="../template/navbar.jsp"/>
    <c:choose>
        <c:when test="${sessionScope.access == 'admin'}">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3>Liste des membres</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>EMail</th>
                                        <th>Adresse</th>
                                        <th>Tel</th>
                                        <th>Rôle</th>
     <c:if test="${sessionScope.access == 'admin'}"><th>Actions</th></c:if>
                                    </tr>
                                </thead>
                                <tbody id="contenant">
                                <c:forEach items="${members}" var="member">
                                    <tr>
                                        <td>${member.memberLastName}</td>
                                        <td>${member.firstName}</td>
                                        <td>${member.email}</td>
                                        <td>${member.address} ${member.postalCode} ${member.city}</td>
                                        <td>${member.phone}</td>
                                        <td>
                                            <c:if test="${member.access == 1}">Admin</c:if>
                                            <c:if test="${member.access == 2}">User</c:if>
                                        </td>
                                        <c:if test="${sessionScope.access == 'admin'}">
                                        <td>
                                            <div class="row">
                                                <form method="get" action="editMember" class="col-md-6" style="padding-right: 0;">
                                                    <input type="hidden" name="id" value="${member.memberId}">
                                                    <input type="submit" class="btn btn-info" value="Editer">
                                                </form>
                                                <form method="get" action="deleteMember" class="col-md-6" style="padding-left: 0;">
                                                    <input type="hidden" name="id" value="${member.memberId}">
                                                    <input type="submit" class="btn btn-danger" value="Supprimer">
                                                </form>
                                            </div>
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="row">
                <div class="container" style="text-align: center;">
                    <h1>Vous n'êtes pas administrateur ou n'êtes pas connecté</h1>
                    <h4><a href="login">Se connecter</a></h4>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    </div>
    <jsp:include page="../template/footer.jsp"/>
</body>
</html>
