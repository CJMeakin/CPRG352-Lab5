<%-- 
    Document   : home
    Created on : Oct 11, 2021, 4:43:36 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="${pageContext.request.contextPath}/resources/itslit.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css" />
        
        <title>Home</title>
    </head>
     <body>
        <div class='bold-line'></div>
            <div class='container'>
              <div class='window'>
                <div class='overlay'></div>
                <div class='content'>
                  <div class='welcome'>Welcome!</div>
                  <div class='subtitle'>Great news. Your name is ${user.username}</div>  
                  <br>
                  <form method="GET">
                    <div><button class='ghost-round full-width' type="submit" name="operation" value="logout">Logout</button></div>
                  </form>
                </div>
              </div>
            </div>
    </body>
</html>
