<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>

    <form method="post" action="signup">
        <fieldset>
            <legend>Sign Up</legend>

            <label for="email">E-mail : </label>
            <input id="email" name="email" value="<c:out value="${param.email}"/>" />
            <span class="errors">${errors['email']}</span>
            <br />

            <label for="password">Password : </label>
            <input id="password" name="password" value=""/>
            <span class="errors">${errors['password']}</span>
            <br />

            <label for="confirm">Confirm Password : </label>
            <input id="confirm" name="confirm" value=""/>
            <span class="errors">${errors['confirm']}</span>
            <br />

            <label for="username">Username : </label>
            <input id="username" name="username" value="<c:out value="${param.username}"/>" />
            <span class="errors">${errors['username']}</span>
            <br />

            <input type="submit" value="Send" />

            <p class="${empty errors ? 'success' : 'errors'}">${results}</p>

        </fieldset>

    </form>

</body>
</html>