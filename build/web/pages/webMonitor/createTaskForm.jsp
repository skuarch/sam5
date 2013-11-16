<%-- 
    Document   : createTask
    Created on : Nov 11, 2013, 1:51:25 PM
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
    <body>

        <s:include value="/pages/application/navigation.jsp"/>

        <div class="container">

            <h1><s:text name="text.183" /></h1>

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

            <div class="row">

                <div class="col-lg-12">

                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <s:text name="text.185"/>
                            </h3>
                        </div>
                        <div class="panel-body">

                            <form action="" name="taskForm" id="taskForm" method="POST" enctype="application/x-www-form-urlencoded">
                                <fieldset>
                                    <legend>
                                        <s:text name="text.186"/>
                                    </legend>
                                    <div class="form-group">
                                        <label for="name">                                        
                                            <s:text name="text.187"/>
                                        </label>
                                        <input type="text" class="form-control" name="name" id="url" placeholder="<s:property value="getText('text.188')"/>" tabindex="1">
                                    </div>
                                    <div class="form-group">
                                        <label for="urls">
                                            <s:text name="text.189"/>
                                        </label>
                                        <input type="text" class="form-control" name="urls" id="urls" placeholder="<s:property value="getText('text.190')"/>" tabindex="2">
                                    </div>
                                    <div class="form-group">
                                        <label for="trigger">
                                            <s:text name="text.192"/>
                                        </label>
                                        <input type="text" class="form-control" name="trigger" id="trigger" placeholder="<s:property value="getText('text.193')"/>" tabindex="3">
                                    </div>
                                    <div class="form-group">
                                        <label for="period">
                                            <s:text name="text.196"/>
                                        </label>
                                        <input type="text" class="form-control" name="period" id="period" placeholder="<s:property value="getText('text.197')"/>" tabindex="4">
                                    </div>
                                    <div class="form-group">
                                        <label for="timeout">
                                            <s:text name="text.194"/>
                                        </label>
                                        <input type="text" class="form-control" name="timeout" id="timeout" placeholder="<s:property value="getText('text.195')"/>" tabindex="5">
                                    </div>
                                    <div class="form-group">
                                        <label for="alarmLevel">
                                            <s:text name="text.210"/>
                                        </label>
                                        <select name="alarmLevel" id="alarmLevel" class="btn-block form-group form-control" tabindex="6">
                                            <option value="0">no alarm</option>
                                            <option value="1">info</option>
                                            <option value="2">warning</option>
                                            <option value="3">danger</option>
                                        </select>
                                    </div>  
                                    <div class="form-group">
                                        <label for="method">
                                            <s:text name="text.191"/>
                                        </label>
                                        <select name="method" id="method" class="btn-block form-group form-control" tabindex="6">
                                            <option value="GET">GET</option>
                                            <option value="POST">POST</option>                                        
                                        </select>
                                    </div>                                
                                    <button type="reset" class="btn btn-block" tabindex="8">
                                        <s:text name="text.195"/>
                                    </button>
                                    <button type="button" id="buttonCreateRunTask" class="btn btn-block btn-success" tabindex="7" onclick="createTask();">
                                        <s:property value="getText('text.202')"/>
                                    </button>

                                    <br/>

                                    <div class="text-danger">
                                        <s:property value="message" />
                                    </div>

                                </fieldset>
                            </form>

                        </div>

                    </div>

                </div>

            </div>

            <s:include value="/pages/application/footer.jsp"/>
        </div>        

    </body>
</html>
