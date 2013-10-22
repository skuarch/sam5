<%@taglib prefix="s" uri="/struts-tags"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <s:text name="application.name" />
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="alarmDashboard">
                        <s:text name="navigation.link.1" />
                    </a>
                </li>
                <li>
                    <a href="servers">
                        <s:text name="navigation.link.2" />
                    </a>
                </li>
                <li>
                    <a href="logout">
                        <s:text name="navigation.link.4" />
                    </a>
                </li>
            </ul>           
        </div><!--/.navbar-collapse -->
    </div>
</div>