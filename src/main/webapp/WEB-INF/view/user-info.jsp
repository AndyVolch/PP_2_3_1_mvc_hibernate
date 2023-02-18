<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new User</title>
</head>
<body>
  <form:form action="saveUser" modelAttribute="newUser">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <br><br>
    Surname: <form:input path="lastName"/>
    <br><br>
    Age: <form:input path="age"/>
    <br><br>
    <input type="submit" value="OK">
  </form:form>
</body>
</html>
