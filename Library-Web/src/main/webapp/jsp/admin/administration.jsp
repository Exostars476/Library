<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Administration</title>
</head>
<body>
    <div class="page">
        <jsp:include page="../template/navbar.jsp"/>
        <c:choose>
            <c:when test="${sessionScope.access == 'admin'}">
                <div class="row">
                    <div class="container" style="max-width: 600px;">
                        <div class="container-fluid">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3>Administration</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h4><span class="glyphicon glyphicon-user" style="padding-right: 10px;"></span><a href="addUser">Inscrire un utilisateur</a></h4>
                                        </div>
                                        <div class="col-md-6">
                                            <h4><span class="glyphicon glyphicon-book" style="padding-right: 10px;"></span><a href="addBook">Ajouter un livre</a></h4>
                                        </div>
                                    </div>
                                    <hr style="border-color:#94B6D2;">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h4><span class="glyphicon glyphicon-list" style="padding-right: 10px;"></span><a href="memberList">Liste des utilisateurs</a></h4>
                                        </div>
                                    </div>
                                </div>
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
