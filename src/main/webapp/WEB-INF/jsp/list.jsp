<%--
  Created by IntelliJ IDEA.
  User: Cezary
  Date: 10.05.2023
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="Note" type=""--%>
<form:form method="post" modelAttribute="Note">
    <label for="im">Importance:</label>
    <form:select path="importance" id="im">
        <form:options items="${Importances}" />
    </form:select>
    <br/>
    <label for="tx">Your Note:</label>
    <form:input path="content" type="text" id="tx"/>
    <br/>

    <form:button type="submit">add</form:button>
</form:form>


<button type="button" onclick="deleteNotes()">Usuń rekordy</button>

<script>
    function deleteNotes() {
        fetch("/list", {
            method: "DELETE"
        })
            .then(function(response) {
                if (response.status === 200) {
                    window.location.href = "/list";
                }
            })
            .catch(function(error) {
            });
    }
</script>



<h1>The list of your notes:</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Importance</th>
        <th>Timestamp</th>
        <th>Note</th>
        <!-- Dodaj inne kolumny, jeśli są dostępne -->
    </tr>
    <c:forEach items="${Notes}" var="row">
        <tr>
            <td>${row.id}</td>
            <td>${row.importance}</td>
            <td>${row.timestamp}</td>
            <td>${row.content}</td>
            <!-- Dodaj inne kolumny, jeśli są dostępne -->
        </tr>
    </c:forEach>
</table>

</body>
</html>
