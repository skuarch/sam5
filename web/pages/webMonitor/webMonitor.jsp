<%-- 
    Document   : webMonitor
    Created on : Nov 6, 2013, 6:58:49 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>

        <s:include value="/pages/application/metas.jsp"/>
        <s:include value="/pages/application/header.jsp"/>

    </head>
    <body onload="taskTable();">

        <s:include value="/pages/application/navigation.jsp"/>

        <div class="container">

            <h1><s:text name="text.224"/></h1>
            <hr>
            <s:include value="/pages/application/breadcrumb.jsp"/>            

            <nav class="navbar navbar-default alert-warning" role="navigation">                
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">
                        <s:text name="firewall.subnavigation.brand" />
                    </a>
                </div>                
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="createTaskForm">
                                <s:text name="text.175" />
                            </a>
                        </li>
                        <li>
                            <a href="taskSettings">
                                <s:text name="text.212" />
                            </a>
                        </li>
                    </ul>                                        
                </div>
            </nav>

            <hr>

            <div id="result">

            </div>               
            
            <s:include value="/pages/application/footer.jsp"/>
        </div>

    </body>
</html>
