<%-- 
    Document   : login
    Created on : Oct 11, 2021, 2:54:08 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="icon" href="${pageContext.request.contextPath}/resources/itslit.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css" />
    </head>
    <body>
        <div class="bold-line"></div>
        <div class="container">
            <div class="window">
                <div class="overlay"></div>
                <div class="content">
                    <div class="welcome">Welcome!</div>
                    <div class="subtitle">${welcomeMsg}</div>
                    <div class="input-fields">
                        <form type="password" method="POST" action="login">
                            <input type ="text" placeholder="Username" class="input-line full-width" name= "username" value="${user.username}"></input>                    
                            <input type ="password" placeholder="Password" class="input-line full-width" name= "password" value="${user.password}"></input>
                            <div><button class="ghost-round full-width" type="submit" name="operation" value="login">Login</button></div>
                        </form>
                        <div>${errMsg}</div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
