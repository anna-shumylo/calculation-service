<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<c:if test="${not empty error}">
    <h5>${error}</h5>
</c:if>

<form action="${pageContext.request.contextPath}/calculator" method="GET">
    <table border="0" cellpadding="5" cellspacing="10">
        <tr>
            <td>Left parameter:</td>
            <td><input name="left_param" type="text" size="10" <c:if test="${not empty left_param}">
                value=${left_param} </c:if>></td>
            <td><select name="action">
                <option value="plus" <c:if test="${action eq 'plus'}"> selected</c:if>>+</option>
                <option value="minus" <c:if test="${action eq 'minus'}"> selected</c:if>>-</option>
                <option value="multiply" <c:if test="${action eq 'multiply'}"> selected</c:if>>*</option>
                <option value="divide" <c:if test="${action eq 'divide'}"> selected</c:if>>/</option>
            </select></td>
            <td>Right parameter:</td>
            <td><input name="right_param" type="text" size="10" <c:if test="${not empty right_param}">
                       value=${right_param} </c:if>></td>
            <td><input type="submit" value="Calculate!"></td>
            <c:if test="${not empty result}">
            <td>
                    ${result}
            <td>
                </c:if>
        </tr>
    </table>
</form>
</body>
</html>