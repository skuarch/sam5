<%-- 
    Document   : error
    Created on : Apr 16, 2013, 6:19:01 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>        
        <s:include value="/pages/application/metas.jsp"/>
        <s:include value="/pages/application/header.jsp"/>
    </head>
    <body>        
        <script>eval(<s:property value="js" />);</script>        
        <div class="alert alert-danger">
            <s:text name="application.error" />
        </div>        
    </body>
</html>