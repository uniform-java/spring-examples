<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" class="uk-height-1-1">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/assets/vendor/uikit/css/uikit.gradient.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet">
        
        <script src="<c:url value="/assets/vendor/jquery/jquery-1.11.2.min.js"/>"></script>
        <script src="<c:url value="/assets/vendor/uikit/js/uikit.min.js"/>"></script>
        <title>Home</title>
    </head>
    <body class="uk-height-1-1 uk-margin-left uk-margin-right">
        <h1>Hello World!</h1>
        ${form}
        
        <c:if test="${valid != null}">
            <div class="uk-alert uk-alert-${valid ? 'success' : 'danger'}">
                Valid: ${valid}
            </div>
            
            <div class="uk-text-bold">
                Form data:
            </div>
            <code>
                <c:out value="${formData}"/> 
            </code>
        </c:if>
    </body>
</html>
