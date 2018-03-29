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
    <title>Ajouter un Livre</title>
</head>
<body>
<div class="page">
    <jsp:include page="../template/navbar.jsp"/><%--
    <c:choose>
        <c:when DaoImpl="${sessionScope.access == 'admin'}">--%>
        <div style="max-width:500px; margin-top: 5%;" class="container margin-top">
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Ajouter un livre</h1></div>
                <div class="panel-body">
                    <div class="container-fluid">
                        <form method="post" action="bookAdd" id="bookAdd" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-md-4">Titre </div>
                                <div class="col-md-4"><input type='text' name='title' required></div>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Description </div>
                                <div class="col-md-4"><input type='text' name='description' required></div>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Prix </div>
                                <div class="col-md-4"><input type='text' name='price' required></div>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Date de publication </div>
                                <div class="col-md-4"><input type='date' name='pubDate' required></div>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Populaire ? </div>
                                <div class="col-md-4">
                                    <input type='radio' name="popular" value="Oui"> Oui
                                    <input type='radio' name="popular" value="Non" style="margin-left:20px;" checked> Non
                                </div>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Éditeur </div>
                                <select class="col-md-4" name="editor" form="bookAdd" style="margin-left: 15px;">
                                    <c:forEach items="${editors}" var="editor">
                                        <option>${editor.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Auteur </div>
                                <select class="col-md-4" name="author" form="bookAdd" style="margin-left: 15px;">
                                    <c:forEach items="${authors}" var="author">
                                        <option>${author.authorLastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Catégories </div>
                                <select class="col-md-4" name="category" form="bookAdd" style="margin-left: 15px;">
                                    <c:forEach items="${categories}" var="category">
                                        <option>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div style="margin-top:10px;" class="row">
                                <div class="col-md-4">Couverture </div>
                                <div class="col-md-4"><input type='file' name='image' required></div>
                            </div>
                            <div style="margin-top:20px;" class="row">
                                <div style="text-align:center;" class="col-md-12"><input type='submit' class='btn-success' value='Inscription'></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><%--
        </c:when>
        <c:otherwise>
            <div class="row">
                <div class="container" style="text-align: center;">
                    <h1>Vous n'êtes pas administrateur ou n'êtes pas connecté</h1>
                    <h4><a href="login">Se connecter</a></h4>
                </div>
            </div>
        </c:otherwise>
    </c:choose>--%>
</div>
<jsp:include page="../template/footer.jsp"/>
</body>
</html>
