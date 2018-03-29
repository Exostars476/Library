<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/bootstrap/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/custom.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/css/library.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="<c:url value='/resources/style/bootstrap/js/bootstrap.min.js'/>"></script>
    <title>Library</title>
</head>
<body><!-- sec:authorize="hasAuthority('ADMIN')" -->
    <div class="page">
        <jsp:include page="template/navbar.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <h1 style="margin-bottom:20px; font-size:25px;">Livres recommandés</h1>
                    <div id="box-book-recom" class="container-fluid"  style="background-color:white;overflow-y:scroll;height: 275px;">
                        <div class='row'>
                            <c:forEach items="${books}" var="book">
                            <a href="">
                                <div class='col-md-3' style='margin-top:20px;'>
                                    <div class='book' style="background-image:url('resources/${book.imagePath}')">
                                        <div class='divBookTitle'><span class='bookTitle'>${book.bookTitle}</span></div>
                                    </div>
                                </div>
                            </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="template/footer.jsp"/>
</body>
</html>