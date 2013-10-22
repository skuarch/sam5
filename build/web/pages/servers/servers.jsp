<%-- 
    Document   : servers
    Created on : Aug 21, 2013, 11:37:54 AM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>

        <s:include value="/pages/application/metas.jsp" />
        <s:include value="/pages/application/header.jsp" />

    </head>
    <body onload="serversTable();">

        <s:include value="/pages/application/navigation.jsp" />

        <div class="container">

            <h1><s:text name="server.title" /></h1>
            <hr>

            <div id="serversTable">
                
            </div>

            <s:include value="/pages/application/footer.jsp" />
        </div>

    </body>
</html>
