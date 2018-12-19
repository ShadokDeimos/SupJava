<%@ page pageEncoding="UTF-8" %>
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
            <input id="email" name="email" value="" />
            <br />

            <label for="password">Password : </label>
            <input id="password" name="password" value="" />
            <br />

            <label for="confirm">Confirm Password : </label>
            <input id="confirm" name="confirm" value="" />
            <br />

            <label for="username">Username : </label>
            <input id="username" name="username" value="" />
            <br />

            <input type="submit" value="Send" />

        </fieldset>

        </fieldset>
    </form>

</body>
</html>