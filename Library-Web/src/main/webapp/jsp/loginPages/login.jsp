<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Connexion</title>
</head>
<body>
    <div class="page">
    <jsp:include page="../template/navbar.jsp"/>
        <div style="width:400px; margin-top: 5%;" class="container margin-top">
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Connexion</h1></div>
                <div class="panel-body">
                    <div class="container-fluid">
                        <form name="loginForm" method="post" action="loginCheck">
                            <div class="row">
                                <div class="col-md-5">Login </div>
                                <div class="col-md-5"><input type='text' name='login' required></div>
                            </div>
                            <div style="margin-top:5px;" class="row">
                                <div class="col-md-5">Mot de passe </div>
                                <div class="col-md-5"><input type='password' name='pass' required></div>
                            </div>
                            <div style="margin-top:20px;" class="row">
                                <div style="text-align:center;" class="col-md-12"><input type='submit' class='btn-success' value='Connexion'></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../template/footer.jsp"/>
</body>
</html>
