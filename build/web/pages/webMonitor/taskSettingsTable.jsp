<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">eval(<s:property value="js"/>);</script>

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
                    <s:text name="text.214" />
                </th>                
                <th>
                    <s:text name="text.215" />
                </th>
                <th>
                    <s:text name="text.216" />
                </th>
                <th>
                    <s:text name="text.217" />
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
                        <button class="btn btn-danger btn-block btn-lg">
                            <s:text name="text.218"/>
                        </button>
                    </td>
                    <td>                        
                        <s:if test="status[#counter] == 0">
                            <button class="btn btn-primary btn-block btn-lg" onclick="changeStatusTask(<s:property value="ids[#counter]" />);">
                                <s:text name="text.219"/>
                            </button>
                        </s:if>
                        <s:else>
                            <button class="btn btn-block btn-lg" onclick="changeStatusTask(<s:property value="ids[#counter]" />);">
                                <s:text name="text.220"/>
                            </button>
                        </s:else>                        
                    </td>
                </tr>
            </s:iterator>

        </tbody>
    </table>
</s:else>