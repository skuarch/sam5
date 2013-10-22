<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">eval(<s:property value="js"/>);</script>
<s:if test="servers.size < 1">
    <div class="alert alert-info">
        <s:text name="server.no.data"/>
    </div>    
</s:if>
<s:else>
    <table class="footable">
        <thead>
            <tr>
                <th data-hide="phone,tablet">
                    <s:text name="server.table.th.1" />
                </th>
                <th>
                    <s:text name="server.table.th.2" />
                </th>
                <th>
                    <s:text name="server.table.th.3" />
                </th>
                <th>
                    <s:text name="server.table.th.4" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="server.table.th.5" />
                </th>
                <th>
                    <s:text name="server.table.th.6" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="server.table.th.7" />
                </th>                
            </tr>
        </thead>
        <tbody>
            <s:iterator value="servers" var="s">
                <tr>
                    <td>
                        <s:property value="#s.id"/>
                    </td>
                    <td>
                        <s:property value="#s.name"/>
                    </td>
                    <td>
                        <s:property value="#s.ip"/>
                    </td>
                    <td>
                        <s:property value="#s.port"/>
                    </td>
                    <td>
                        <s:property value="#s.description"/>
                    </td>
                    <td>
                        <s:property value="#s.serverType.name"/>
                    </td>
                    <td>
                        <a class="btn btn-primary btn-block" href='<s:url action="switcher">                                                           
                               <s:param name="id" value="#s.id"/>
                               <s:param name="action" value="#s.serverType.action"/>
                           </s:url>'>
                            <s:text name="server.table.button.choose"/>
                        </a>                        
                    </td>                                        
                </tr>
            </s:iterator>
        </tbody>                
    </table>
</s:else>
