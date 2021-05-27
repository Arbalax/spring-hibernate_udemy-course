<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="securtiy" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>luv2code Company Home Page</title>
</head>
<body>
    <h2>luv2code Company Home Page</h2>
    <hr>

    <p>
        Welcome to luv2code company home page!
    </p>

    <hr>

    <!-- display user name and role -->

    <p>
        User: <securtiy:authentication property="principal.username" />
        <br><br>
        Role(s): <securtiy:authentication property="principal.authorities" />

    </p>


    <!-- add a link to point to /leaders for managers -->
    <securtiy:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps)
    </p>
    </securtiy:authorize>


    <securtiy:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (Only for Admin peeps)
    </p>
    </securtiy:authorize>

    <hr>

    <form:form action="${pageContext.request.contextPath}/logout"
               method="post">

        <input type="submit" value="Logout"/>

    </form:form>











</body>
</html>
