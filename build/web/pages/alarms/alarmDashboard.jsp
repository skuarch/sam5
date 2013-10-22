<%-- 
    Document   : alarmDashboard
    Created on : Aug 16, 2013, 6:56:24 PM
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
    <body onload="alarmDashboardTable(0);">  
        <script type="text/javascript">eval('<s:property value="js"/>');</script> 
        <s:include value="/pages/application/navigation.jsp" />        
        <div class="container">            
            
            <h1><s:text name="alarm.title"/></h1>            
            <hr>
            
            <div id="alarmTable">

            </div>

            <s:include value="/pages/application/footer.jsp"/>
        </div>
    </body>
</html>