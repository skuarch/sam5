<%-- 
    Document   : firewall
    Created on : Aug 22, 2013, 10:42:34 AM
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
    <body onload="rulesTable();pressEscKey();">

        <s:include value="/pages/application/navigation.jsp"/>

        <div class="container">            

            <h1><s:text name="firewall.title" /></h1>

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
                            <a href="advancedRule">
                                <s:text name="firewall.subnavigation.link.1" />
                            </a>
                        </li>                        
                        <li>
                            <a href="rulesStatus">
                                <s:text name="firewall.subnavigation.link.3" />
                            </a>
                        </li>

                    </ul>                                        
                </div><!-- /.navbar-collapse -->
            </nav>

            <hr>            

            <div id="rulesTable">

            </div>

            <s:include value="/pages/application/footer.jsp"/>
        </div>        

        <div class="modal fade" id="modalRulesFirewall" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" onclick="stopDetailsTrafficRule();">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" onclick="stopDetailsTrafficRule();" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">
                            <s:text name="firewall.rules.table.modal.title"/>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <h4 class="list-group-item-heading">
                                    <s:text name="firewall.rules.table.modal.badges.1" />
                                </h4>
                                <div id="dateRuleDetail"></div>
                            </li>
                            <li class="list-group-item" >
                                <h4 class="list-group-item-heading">
                                    <s:text name="firewall.rules.table.modal.badges.2" />
                                </h4>
                                <div id="userRuleDetail"></div>
                            </li>                            
                            <li class="list-group-item">
                                <h4 class="list-group-item-heading">
                                    <s:text name="firewall.rules.table.modal.badges.3" />
                                </h4>
                                <div id="commentsRuleDetail"></div>
                            </li>
                            <li class="list-group-item">
                                <h4 class="list-group-item-heading">
                                    <s:text name="firewall.rules.table.modal.badges.4" />
                                </h4>
                                <div id="descriptionRuleDetail"></div>
                            </li>
                        </ul>
                    </div>
                                
                    <div class="container">
                        <div id="detailsTrafficRule" class="alert alert-success"> 
                        </div> 
                    </div>

                    <div class="modal-footer">
                        <button type="button" onclick="stopDetailsTrafficRule();" class="btn btn-primary btn-block" data-dismiss="modal">
                            <s:text name="firewall.rules.table.modal.button.close"/>
                        </button>                        
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>

    </body>
</html>