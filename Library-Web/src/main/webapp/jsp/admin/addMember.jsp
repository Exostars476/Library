<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Ajouter un Membre</title>
</head>
<body>
    <div class="page">
        <jsp:include page="../template/navbar.jsp"/>
        <c:choose>
            <c:when test="${sessionScope.access == 'admin'}">
            <div style="max-width:500px; margin-top: 5%;" class="container margin-top">
                <div class="panel panel-primary">
                    <div class="panel-heading"><h1>Inscrire un utilisateur</h1></div>
                    <div class="panel-body">
                        <div class="container-fluid">
                            <form method="post" action="register" id="register">
                                <div class="row">
                                    <div class="col-md-4">Nom </div>
                                    <div class="col-md-4"><input type='text' name='name' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Prénom </div>
                                    <div class="col-md-4"><input type='text' name='firstName' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">email </div>
                                    <div class="col-md-4"><input type='text' name='email' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Mot de pass </div>
                                    <div class="col-md-4"><input type='password' name='password' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Adresse </div>
                                    <div class="col-md-4"><input type='text' name='address' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Ville </div>
                                    <div class="col-md-4"><input type='text' name='city' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Code postal </div>
                                    <div class="col-md-4"><input type='text' name='postalCode' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Téléphone </div>
                                    <div class="col-md-4"><input type='text' name='phone' required></div>
                                </div>
                                <div style="margin-top:10px;" class="row">
                                    <div class="col-md-4">Rôle </div>
                                    <select name="role" id="role" form="register" style="margin-left: 15px;">
                                        <option>Admin</option>
                                        <option>User</option>
                                    </select>
                                </div>
                                <div style="margin-top:20px;" class="row">
                                    <div style="text-align:center;" class="col-md-12"><input type='submit' class='btn-success' value='Inscription'></div>
                                </div>
                            </form>
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
