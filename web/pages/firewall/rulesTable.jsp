<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">eval(<s:property value="js"/>);</script>

<div class="pull-right">
    <button class="btn btn-info" onclick="setStatusFirewall('<s:property value="firewallStatus"/>');">
        <s:text name="text.12"/> <s:property value="firewallStatus"/>
    </button>
    <button class="btn btn-danger" onclick="resetFirewall();">
        <s:text name="text.11"/>
    </button>
</div>

<br>
<br>

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
                    <s:text name="firewall.rules.table.th.1" />
                </th>                
                <th>
                    <s:text name="firewall.rules.table.th.3" />
                </th>
                <th>
                    <s:text name="firewall.rules.table.th.16" />
                </th>
                <th>
                    <s:text name="firewall.rules.table.th.4" />
                </th>                
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.5" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.8" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.9" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.10" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.11" />
                </th>
                <th data-hide="phone,tablet">
                    <s:text name="firewall.rules.table.th.14" />
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
                        <s:property value="protocol[#counter]" />
                    </td>                    
                    <td>
                        <s:property value="sourceAddress[#counter]" />
                    </td>
                    <td>
                        <s:property value="destinationAddress[#counter]" />
                    </td>
                    <td>
                        <s:property value="sourcePort[#counter]" />
                    </td>
                    <td>
                        <s:property value="destinationPort[#counter]" />
                    </td>        
                    <td>

                        <div class="btn-group">
                            <s:if test="#session.user.level == 1">
                                <button id="buttonDeleteRule<s:property value="id[#counter]" />" class="btn btn-danger" onclick="deleteRule(<s:property value="id[#counter]" />, '<s:property value="chain[#counter]" />', '<s:property value="tableType[#counter]" />', document.getElementById('buttonDeleteRule<s:property value="id[#counter]" />'));">
                                    <s:text name="firewall.rules.table.modal.button.delete" />
                                </button>
                            </s:if>
                            <s:else>
                                <button id="buttonDeleteRule<s:property value="id[#counter]" />" class="btn btn-danger" disabled="disabled" >
                                    <s:text name="firewall.rules.table.modal.button.delete" />
                                </button>
                            </s:else>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation" class="dropdown-header">                                    
                                    <s:text name="firewall.rules.table.dropdown"/>                                    
                                </li> 
                                <li>
                                    <a data-toggle="modal" href="#modalRulesFirewall" onclick="javascript:detailsRulesFirewall('<s:property value="creationDate[#counter]" />', '<s:property value="user[#counter]" />', '<s:property value="comments[#counter]" />',<s:property value="id[#counter]" />, '<s:property value="chain[#counter]" />', '<s:property value="tableType[#counter]" />', '<s:property value="description[#counter]" />');
        runDetailsTrafficRule(<s:property value="id[#counter]" />, '<s:property value="chain[#counter]" />', '<s:property value="tableType[#counter]" />');">
                                        <s:text name="firewall.rules.table.modal.button.details" />
                                    </a>
                                </li>                                
                                <s:if test="#session.user.level == 1">
                                    <li class="divider"></li>
                                    <li role="presentation" class="dropdown-header">
                                        <s:text name="firewall.rules.table.dropdown.positions" />
                                    </li>                                
                                    <s:iterator value="slots[#counter]" var="s1">
                                        <s:iterator value="#s1" var="s2">                                        
                                            <li class="text-center">
                                                <a href="javascript:movePosition(<s:property value="id[#counter]" />, '<s:property value="chain[#counter]" />', '<s:property value="tableType[#counter]" />',<s:property value="#s2"/>);">
                                                    <s:property value="#s2"/>                                        
                                                </a>
                                            </li>
                                        </s:iterator>
                                    </s:iterator>
                                </s:if>
                            </ul>
                        </div>

                    </td>
                </tr>
            </s:iterator>

        </tbody>
    </table>
</s:else>