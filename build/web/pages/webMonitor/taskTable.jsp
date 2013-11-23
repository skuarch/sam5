<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">eval(<s:property value="js"/>);</script>

<s:if test="rows < 1">    

    <div class="alert alert-info">
        <s:text name="text.222" />
    </div>    

</s:if>
<s:else>
    <table class="footable">
        <thead>
            <tr>
                <th>
                    <s:text name="text.176" />
                </th>                
                <th>
                    <s:text name="text.177" />
                </th>
                <th>
                    <s:text name="text.178" />
                </th>
                <th>
                    <s:text name="text.179" />
                </th>                
                <th data-hide="phone,tablet">
                    <s:text name="text.182" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="text.180" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="text.181" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="text.211" />
                </th>
            </tr>
        </thead>
        <tbody>

            <s:iterator begin="0" end="rows -1" step="1" var="counter">
                <tr>
                    <td>
                        <s:property value="names[#counter]" />
                    </td>
                    <td>
                        <s:property value="url[#counter]" />
                    </td>
                    <td>
                        <s:property value="method[#counter]" />
                    </td>
                    <td>
                        <s:property value="trigger[#counter]" />
                    </td>
                    <td>
                        <s:property value="status[#counter]" />
                    </td>                    
                    <td>
                        <s:property value="period[#counter]" />
                    </td>
                    <td>
                        <s:property value="timeout[#counter]" />
                    </td>
                    <td>
                        <s:property value="alarmLevel[#counter]" />
                    </td>
                </tr>
            </s:iterator>

        </tbody>
    </table>
</s:else>