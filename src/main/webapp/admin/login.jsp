<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<fieldset>
    <legend>Login</legend>
    ${message}
    <br>
    <form method="post" action="account">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td>
                    <input type="text" name="username">
                </td>
                <br>
                <td>Password</td>
                <td>
                    <input type="password" name="password">
                </td>
                <br>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>