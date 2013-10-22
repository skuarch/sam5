<%-- 
    Document   : logout
    Created on : Jun 13, 2013, 12:23:45 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/pages/application/metas.jsp"/>
        <s:include value="/pages/application/header.jsp"/>         
        <link rel="stylesheet" href="css/logout.css"/>
    </head>
    <body onload="javascript:window.history.forward(1);" onunload="javascript:history.go(1);">

        <div class="container-narrow">

            <div class="masthead">                
                <h3 class="muted">
                    <s:text name="application.name" />
                </h3>
            </div>

            <hr>

            <div class="jumbotron">
                <h1>
                    <s:text name="application.logout.thanks" />            
                </h1>
                <p class="lead">
                    <s:text name="application.logout.text" />            
                </p>
                <a class="btn btn-large btn-success" href="login">
                    <s:text name="login.form.button.submit"/>
                </a>
            </div>            

            <s:include value="/pages/global/footer.jsp"/>
        </div> <!-- /container -->

    </body>
</html>
