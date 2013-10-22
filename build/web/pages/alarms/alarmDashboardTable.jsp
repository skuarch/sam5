<%@taglib prefix="s" uri="/struts-tags" %>
<div class="row"> 
    <div class="col-md-12">
        <div class="pull-right">
            <input type="button" value="info" class="btn btn-info" onclick="alarmDashboardTable(1);"/>
            <input type="button" value="warning" class="btn btn-warning" onclick="alarmDashboardTable(2);"/>
            <input type="button" value="danger" class="btn btn-danger" onclick="alarmDashboardTable(3);"/>
            <br>
            <br>                
        </div>                        
    </div>          
</div>
<s:if test="alarms.size < 1">
    <div class="alert alert-info">
        <s:text name="alarm.no.data" />
    </div>
</s:if>
<s:else>
    <div class="row">
        <div class="col-md-12"> 
            <table class="footable">
                <thead>
                    <tr>
                        <th>
                            <s:text name="alarm.dashboard.table.th.1" />
                        </th>
                        <th>
                            <s:text name="alarm.dashboard.table.th.5" />
                        </th>
                        <th>
                            <s:text name="alarm.dashboard.table.th.2" />
                        </th>
                        <th data-hide="phone,tablet">
                            <s:text name="alarm.dashboard.table.th.3" />
                        </th>
                        <th data-hide="phone,tablet">
                            <s:text name="alarm.dashboard.table.th.4" />
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="alarms" var="a">
                        <tr 
                            <s:if test="#a.level == 1" > class="alert alert-info" </s:if>
                            <s:if test="#a.level == 2" > class="alert alert-warning" </s:if>
                            <s:if test="#a.level == 3" > class="alert alert-danger" </s:if>
                                >
                                <td>
                                <s:property value="#a.level" />
                            </td>
                            <td>
                                <s:property value="#a.serverType.name" />
                            </td>
                            <td>
                                <s:property value="#a.date" />
                            </td>
                            <td>
                                <s:property value="#a.description" />
                            </td>
                            <td>
                                <s:property value="#a.server.name" />
                            </td>
                        </tr>                            
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</s:else>