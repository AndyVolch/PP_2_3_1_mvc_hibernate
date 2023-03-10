
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h3>Users</h3>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:url var="updateButton" value="/updateUser">
            <c:param name="UserID" value="${user.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="UserID" value="${user.id}"/>
        </c:url>
        <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>

</table>
<input type="button" value="Add User"
onclick="window.location.href = 'addUser'">
</body>
</html>