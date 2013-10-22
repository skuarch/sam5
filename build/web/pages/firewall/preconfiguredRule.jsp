<%-- 
    Document   : preconfiguredRule
    Created on : Aug 28, 2013, 11:43:43 AM
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
    <body>

        <s:include value="/pages/application/navigation.jsp" />

        <div class="container">

            <h1>
                <s:text name="firewall.rules.create.preconfigured.title" />
            </h1>

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
                        <s:text name="firewall.rules.preconfigured.subnavigation.brand" />
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="firewall">
                                <s:text name="firewall.rules.preconfigured.subnavigation.link.1" />
                            </a>
                        </li>                                                
                        <li>
                            <a href="advancedRule">
                                <s:text name="firewall.rules.preconfigured.subnavigation.link.3" />
                            </a>
                        </li>
                    </ul>                                        
                </div><!-- /.navbar-collapse -->
            </nav> 

            <hr>

            <div class="container">  

                <div class="row">

                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <s:text name="firewall.rules.form.create.preconfigured.panel.title" />
                            </h3>
                        </div>  

                        <div class="panel-body">

                            <form name="createRuleForm" id="createRuleForm" action="" method="POST" enctype="application/x-www-form-urlencoded">

                                <fieldset>

                                    <legend>
                                        <s:text name="firewall.rules.form.create.preconfigured.panel.legend"/>
                                    </legend>                                    

                                    <div class="row">


                                        <div class="form-group col-lg-2">
                                            <label for="chain">
                                                <s:text name="firewall.rules.form.traffic.type"/>                                            
                                            </label>
                                            <select name="trafficType" id="trafficType" class="form-control" tabindex="1" onchange="changeTrafficLabels();">
                                                <option value="LAN">LAN</option>
                                                <option value="WAN">WAN</option>
                                            </select>                                     
                                        </div>

                                        <div class="form-group col-lg-3">
                                            <label for="host">                                                                                    
                                                <s:text name="firewall.rules.form.host"/>
                                                <span class="text-warning" id="trafficLabelHost">(external network)</span>
                                            </label>
                                            <input type="text" class="form-control" name="host" id="host" placeholder="<s:text name="firewall.rules.form.host.placeholder"/>" tabindex="2" required="required" max="32">
                                        </div>

                                        <div class="form-group col-lg-3">
                                            <label for="port">
                                                <s:text name="firewall.rules.form.port"/>
                                                <span class="text-warning" id="trafficLabelPort">(internal port network)</span>
                                            </label>
                                            <input type="number" class="form-control" name="port" id="port" placeholder="<s:text name="firewall.rules.form.port.placeholder"/>" tabindex="3" required="required" max="65535" maxlength="5">
                                        </div>

                                        <div class="form-group col-lg-2">
                                            <label for="target">
                                                <s:text name="firewall.rules.form.target"/>
                                            </label>
                                            <select name="target" id="target" class="form-control" tabindex="4">
                                                <option value="allow">allow</option>
                                                <option value="deny">deny</option>
                                            </select>                                     
                                        </div>                                    

                                        <div class="form-group col-lg-2">
                                            <label for="protocol">
                                                <s:text name="firewall.rules.form.protocol"/>
                                            </label>
                                            <select name="protocol" id="protocol" onchange="changeProtocol();" class="form-control" tabindex="5">
                                                <option value="tcp">TCP</option>
                                                <option value="udp">UDP</option>
                                                <option value="icmp">ICMP</option>
                                            </select>                                     
                                        </div>

                                    </div>

                                    <div class="row">

                                        <div class="form-group col-lg-12">
                                            <label for="comments">
                                                <s:text name="firewall.rules.form.comments"/>
                                            </label>
                                            <textarea class="form-control" rows="3" id="comments" name="comments" tabindex="6"></textarea>
                                        </div>

                                    </div>

                                    <button type="button" id="createRuleButton" onclick="createPreconfiguredRule();" class="btn btn-block btn-success" tabindex="7">
                                        <s:text name="firewall.rules.form.button.save"/>
                                    </button>

                                    <br/>

                                </fieldset>

                            </form>                            

                        </div>    

                    </div> 

                </div>

                <s:include value="/pages/application/footer.jsp" />        

            </div>       

    </body>
</html>