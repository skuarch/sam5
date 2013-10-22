<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">eval(<s:property value="js"/>)</script>

<s:if test="rows < 1">
    <div class="alert alert-info">
        <s:text name="firewall.rules.no.data" />
    </div>    
</s:if>
<s:else>
    <table class="footable">
        <thead>
            <tr>
                <th>
                    <s:text name="text.9" />
                </th>                
                <th>
                    <s:text name="text.4" />
                </th>
                <th>
                    <s:text name="text.5" />
                </th>
                <th>
                    <s:text name="text.6" />
                </th>                
                <th data-hide="phone,tablet">
                    <s:text name="text.7" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="text.8" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="text.10" />
                </th>
            </tr>
        </thead>
        <tbody>

            <s:iterator begin="0" end="rows -1" step="1" var="counter">
                <tr>
                    <td>
                        <s:property value="id[#counter]" />
                    </td>
                    <td>
                        <s:property value="ruleName[#counter]" />
                    </td>
                    <td>
                        <s:property value="direction[#counter]" />
                    </td>
                    <td>
                        <s:property value="target[#counter]" />
                    </td>
                    <td>
                        <s:property value="packets[#counter]" />
                    </td>                    
                    <td>
                        <s:property value="bytes[#counter]" />
                    </td>
                    <td>
                        <a href="javascript:;" onclick="resetStatusRule(<s:property value="id[#counter]" />)">
                            <s:text name="text.10" />
                        </a>                        
                    </td>
                </tr>
            </s:iterator>

        </tbody>
    </table>
</s:else>