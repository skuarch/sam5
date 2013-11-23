<%-- 
    Document   : taskSettings
    Created on : Nov 21, 2013, 6:44:40 PM
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
    <body onload="taskSettingsTable();">

        <div class="container">

            <s:include value="/pages/application/navigation.jsp"/>

            <h1><s:text name="text.213" /></h1>

            <hr>

            <s:include value="/pages/application/breadcrumb.jsp"/>

            <nav class="navbar navbar-default alert-warning" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
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

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="webMonitor">
                                <s:text name="text.184" />
                            </a>
                        </li>                        
                    </ul>                                        
                </div><!-- /.navbar-collapse -->
            </nav>

            <hr>  
            
            <div id="result">
                
            </div>

            <s:include value="/pages/application/footer.jsp"/>

        </div>

    </body>
</html>