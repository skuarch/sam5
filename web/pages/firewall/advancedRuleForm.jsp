<%@taglib prefix="s" uri="/struts-tags"%>
<script>eval("<s:property value="js"/>");</script>

<s:if test="error == false">

    <div class="row">

        <div class="panel panel-primary">

            <div class="panel-heading">
                <h3 class="panel-title">
                    <s:text name="firewall.rules.form.create.advanced.panel.legend.1"/>                                
                </h3>
            </div>  

            <div class="panel-body">                                       

                <div class="row">
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.33"/>                                
                            </div>
                            <div class="panel-body">
                                <input type="text" id="ruleName" class="form-control" maxlength="30" placeholder="<s:text name="firewall.rules.form.create.advanced.34"/>"/>
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.30"/>
                            </div>
                            <div class="panel-body">
                                <select class="form-control" id="target">
                                    <option value="accept">accept</option>
                                    <option value="drop">drop</option>
                                    <option value="reject">reject</option>
                                    <option value="alarm-info">alarm-info</option>
                                    <option value="alarm-warning">alarm-warning</option>
                                    <option value="alarm-danger">alarm-danger</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">                                

                    <div class="col-lg-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.2"/>
                            </div>
                            <div class="panel-body">
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.3"/>                                                
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeSourceHostNet">
                                    </span>
                                    <input type="text" id="sourceHostNet" name="sourceHostNet" class="form-control" placeholder="<s:text name="firewall.rules.form.create.advanced.3.placeholder"/>">
                                </div>
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.4"/>                                                 
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeSourcePort" disabled="disabled">
                                    </span>
                                    <input type="text" class="form-control" id="sourcePort" placeholder="<s:text name="firewall.rules.form.create.advanced.4.placeholder"/>" disabled="disabled">
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.5"/>                                            
                            </div>
                            <div class="panel-body">
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.6"/>
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeDestinationHostNet">
                                    </span>
                                    <input type="text" class="form-control" id="destinationHostNet" placeholder="<s:text name="firewall.rules.form.create.advanced.6.placeholder"/>">
                                </div>
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.7"/>                                                
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeDestinationPort" disabled="disabled">
                                    </span>
                                    <input type="text" class="form-control" id="destinationPort" placeholder="<s:text name="firewall.rules.form.create.advanced.7.placeholder"/>" disabled="disabled"> 
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.8"/>                                           
                            </div>
                            <div class="panel-body">
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.9"/>                                                
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeProtocol">
                                    </span>
                                    <select class="form-control" id="protocol" onchange="protocolChange();">
                                        <option value="ignore">ignore</option>
                                        <option value="tcp">tcp</option>
                                        <option value="udp">udp</option>
                                        <option value="icmp">icmp</option>
                                        <option value="sctp">sctp</option>
                                    </select>
                                </div>                                            
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.10"/>                                                
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeIcmpType">
                                    </span>
                                    <select class="form-control" id="icmpType" disabled="disabled">m                                        
                                        <option value="any">any</option>                                    
                                        <option value="echo-reply (pong)">echo-reply (pong)</option>
                                        <option value="destination-unreachable">destination-unreachable</option>
                                        <option value="network-unreachable">network-unreachable</option>
                                        <option value="host-unreachable">host-unreachable</option>
                                        <option value="protocol-unreachable">protocol-unreachable</option>
                                        <option value="port-unreachable">port-unreachable</option>
                                        <option value="fragmentation-needed">fragmentation-needed</option>
                                        <option value="source-route-failed">source-route-failed</option>
                                        <option value="network-unknown">network-unknown</option>
                                        <option value="host-unknown">host-unknown</option>
                                        <option value="network-prohibited">network-prohibited</option>
                                        <option value="host-prohibited">host-prohibited</option>
                                        <option value="TOS-network-unreachable">TOS-network-unreachable</option>
                                        <option value="TOS-host-unreachable">TOS-host-unreachable</option>
                                        <option value="communication-prohibited">communication-prohibited</option>
                                        <option value="host-precedence-violation">host-precedence-violation</option>
                                        <option value="precedence-cutoff">precedence-cutoff</option>
                                        <option value="source-quench">source-quench</option>
                                        <option value="redirect">redirect</option>
                                        <option value="network-redirect">network-redirect</option>
                                        <option value="host-redirect">host-redirect</option>
                                        <option value="TOS-network-redirect">TOS-network-redirect</option>
                                        <option value="TOS-host-redirect">TOS-host-redirect</option>
                                        <option value="echo-request (ping)">echo-request (ping)</option>
                                        <option value="router-advertisement">router-advertisement</option>
                                        <option value="router-solicitation">router-solicitation</option>
                                        <option value="time-exceeded (ttl-exceeded)">time-exceeded (ttl-exceeded)</option>
                                        <option value="ttl-zero-during-transit">ttl-zero-during-transit</option>
                                        <option value="ttl-zero-during-reassembly">ttl-zero-during-reassembly</option>
                                        <option value="parameter-problem">parameter-problem</option>
                                        <option value="ip-header-bad">ip-header-bad</option>
                                        <option value="required-option-missing">required-option-missing</option>
                                        <option value="timestamp-request">timestamp-request</option>
                                        <option value="timestamp-reply">timestamp-reply</option>
                                        <option value="address-mask-request">address-mask-request</option>
                                        <option value="address-mask-reply">address-mask-reply</option>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-3">

                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.11"/>
                            </div>
                            <div class="panel-body">
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.12"/>
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeInterfaceIncoming">
                                    </span>
                                    <select class="form-control" id="interfaceIncoming">
                                        <s:iterator value="interfaces" var="i">
                                            <option value="<s:property value="#i"/>">
                                                <s:property value="#i"/>
                                            </option>
                                        </s:iterator>
                                    </select>
                                </div>
                                <label>
                                    <s:text name="firewall.rules.form.create.advanced.13"/>
                                </label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input type="checkbox" id="negativeInterfaceOutgoing">
                                    </span>
                                    <select class="form-control" id="interfaceOutgoing">
                                        <s:iterator value="interfaces" var="i">
                                            <option value="<s:property value="#i"/>">
                                                <s:property value="#i"/>
                                            </option>
                                        </s:iterator>
                                    </select>
                                </div>
                            </div>                                        
                        </div>                   

                    </div>

                </div>  

                <div class="row">
                    <div class="col-lg-12">

                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.32" />
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" id="searchInPacket"></textarea>
                            </div>

                        </div>

                    </div>
                </div>    

                <div class="row">

                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.14"/>
                            </div>
                            <div class="panel-body">
                                <textarea class="form-control" id="comments" name="comments"></textarea>
                            </div>
                        </div>
                    </div>

                </div>

            </div>    

        </div> 

    </div>


    <div class="row">

        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <s:text name="firewall.rules.form.create.advanced.15"/>
                </h3>
            </div>
            <div class="panel-body">

                <div class="row">

                    <div class="col-lg-8">

                        <div class="row">

                            <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <s:text name="firewall.rules.form.create.advanced.16"/>
                                    </div>
                                    <div class="panel-body">
                                        <select class="form-control" id="fragmentation">
                                            <option value="ignore">ignore</option>
                                            <option value="yes">yes</option>
                                            <option value="no">no</option>
                                        </select>
                                    </div>

                                </div>
                            </div>  

                            <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <s:text name="firewall.rules.form.create.advanced.17"/>
                                    </div>
                                    <div class="panel-body">                                        
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <input type="checkbox" id="negativeMac">
                                            </span>
                                            <input type="text" id="mac" class="form-control" placeholder="<s:text name="firewall.rules.form.create.advanced.18"/>">
                                        </div>                                        
                                    </div>
                                </div>                                           

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <s:text name="firewall.rules.form.create.advanced.19"/>
                                            </div>
                                            <div class="panel-body">
                                                <label>
                                                    <s:text name="firewall.rules.form.create.advanced.20"/>
                                                </label>
                                                <input type="text" id="limitBurts" class="form-control" />
                                                <label>
                                                    <s:text name="firewall.rules.form.create.advanced.21"/>
                                                </label>
                                                <input type="text" class="form-control" id="limitRate" />
                                                <select class="form-control" id="limitPeriod">
                                                    <option value="second">second</option>
                                                    <option value="minute">minute</option>
                                                    <option value="hour">hour</option>
                                                    <option value="day">day</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <s:text name="firewall.rules.form.create.advanced.22"/>
                                    </div>
                                    <div class="panel-body">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <input type="checkbox" id="negativeState">
                                            </span>                                            
                                            <select class="form-control" id="state">
                                                <option value="ignore">ignore</option>
                                                <option value="invalid">invalid</option>
                                                <option value="established">established</option>
                                                <option value="new">new</option>
                                                <option value="related">related</option>
                                                <option value="untracked">untracked</option>
                                                <option value="notrack">notrack</option>
                                            </select>
                                        </div>              
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <s:text name="firewall.rules.form.create.advanced.23"/>
                                    </div>
                                    <div class="panel-body">

                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <input type="checkbox" id="negativeTos">
                                            </span>                                            
                                            <select class="form-control" id="tos">
                                                <option value="ignore">ignore</option>
                                                <option value="minimize-delay">minimize-delay</option>
                                                <option value="maximize-throughput">maximize-throughput</option>
                                                <option value="maximize-reliability">maximize-reliability</option>
                                                <option value="minimize-cost">minimize-cost</option>
                                                <option value="normal-service">normal-service</option>
                                            </select>
                                        </div> 
                                    </div>
                                </div>
                            </div>

                        </div>                                    
                    </div>
                    <div class="col-lg-4">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <s:text name="firewall.rules.form.create.advanced.24"/>
                            </div>
                            <div class="panel-body">    

                                <div class="row">

                                    <div class="col-lg-12">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <input type="checkbox" id="negativeFlag">

                                            </span>                                            
                                            <select class="form-control" id="flag">
                                                <option value="ignore">ignore</option>
                                                <option value="selected">selected</option>
                                            </select>
                                        </div> 

                                        <label>
                                            <s:text name="firewall.rules.form.create.advanced.25"/>
                                        </label>
                                        <select class="form-control" multiple id="tcpFlagSet">
                                            <option value="SYN">SYN</option>
                                            <option value="ACK">ACK</option>
                                            <option value="FIN">FIN</option>
                                            <option value="RST">RST</option>
                                            <option value="URG">URG</option>
                                            <option value="PSH">PSH</option>
                                        </select>
                                        <label>
                                            <s:text name="firewall.rules.form.create.advanced.26"/>
                                        </label>
                                        <select class="form-control" multiple id="tcpFlagUnset">
                                            <option value="SYN">SYN</option>
                                            <option value="ACK">ACK</option>
                                            <option value="FIN">FIN</option>
                                            <option value="RST">RST</option>
                                            <option value="URG">URG</option>
                                            <option value="PSH">PSH</option>
                                        </select>
                                    </div> 

                                </div>                                    

                            </div>

                        </div>

                    </div>
                    
                </div>                            

            </div>

        </div>

    </div>  

    <div class="row">                    

        <button class="btn btn-block btn-success" id="buttonAppendAdvancedRule" onclick="appendAdvancedRule();" <s:if test="error == true || firewallStatus == 'disabled'"> disabled="disabled" </s:if>> 
            <s:text name="firewall.rules.form.create.advanced.31"/>                        
        </button>        
    </div>  

</s:if>

<s:else>
    <div class="row">
        <div class="alert alert-danger">
            <s:text name="application.please.try.again" />
        </div>
    </div>
</s:else>