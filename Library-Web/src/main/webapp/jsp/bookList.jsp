<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Livres</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="page">
    <jsp:include page="template/navbar.jsp"/>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3>Liste des livres</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th style='text-align:left'>Titre</th>
                                    <th style='text-align:left'>Prix</th>
                                    <th style='text-align:left'>Auteur</th>
                                    <th style='text-align:left'>Editeur</th>
                                    <th style='text-align:left'>Actions</th>
                                </tr>
                            </thead>
                            <tbody id="contenant">
                            <c:forEach items="${books}" var="book">
                                <tr>
                                    <td><img src="<c:url value="/resources/${book.imagePath}"/>" width="100px" height="150px"></td>
                                    <td style="vertical-align: middle;">${book.bookTitle}</td>
                                    <td style="vertical-align: middle;">${book.bookPrice}</td>
                                    <td style="vertical-align: middle;"><c:forEach items="${book.authors}" var="author"><span> ${author.firstName} ${author.authorLastName} |</span></c:forEach></td>
                                    <td style="vertical-align: middle;">${book.editor.name}</td>
                                    <td style="vertical-align: middle;">
                                        <form method="get" action="BookDetail">
                                            <input type="hidden" name="id" value="${book.isbn}">
                                            <input type="submit" class="btn btn-info" value="Détail">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp"/>
</body>
</html>
