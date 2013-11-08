var loaderDiv = "<img class='_1' src='img/loader.gif'/>";
var serverDomain = document.domain;
var serverContext = location.pathname.split('/')[1];
var serverPort = location.port;
var wsUrlAlarms = "ws://" + serverDomain + ":" + serverPort + "/" + serverContext + "/alarms";
var wsAlarms;
var standartError = "sorry, we have an error";
var intervalDetailsRules;
var intervalRulesStatus;

//==============================================================================
(function alarms() {

    wsAlarms = new WebSocket(wsUrlAlarms);

    wsAlarms.onopen = function(e) {
    };
    wsAlarms.onclose = function(e) {
        //alertify.error("alerts doesn't work properly<br>the connection with the server has been closed");
    };
    wsAlarms.onmessage = function(e) {
        alertify.log(e.data);
    };
    wsAlarms.onerror = function() {
        alertify.error("error something is wrong, alarms doesn't work properly");
    };

})(); // end alarms

//==============================================================================
function advancedRule() {

    $("#resultAdvancedRule").html(loaderDiv);

    $.ajax({
        url: "advancedRuleForm",
        type: "POST",
        success: function(data) {
            $("#resultAdvancedRule").html(data);
        }, error: function() {
            errorMessage(standartError);
        }

    });

} // end advancedRule

//==============================================================================
function alarmDashboardTable(level) {

    $("#alarmTable").html(loaderDiv);

    $.ajax({
        url: "alarmDashboardTable",
        type: "POST",
        data: {level: level},
        success: function(data) {
            $("#alarmTable").html(data);
            fooTable();
        }, error: function() {
            errorMessage(standartError);
        }

    });

} // end alarmDashboardTable

//==============================================================================
function appendAdvancedRule() {

    var button = document.getElementById('buttonAppendAdvancedRule');
    button.disabled = true;

    var ruleName = document.getElementById('ruleName').value;
    var negativeSourceHostNet = $('#negativeSourceHostNet').is(':checked') ? "on" : "off";
    var sourceHostNet = document.getElementById('sourceHostNet').value;
    var negativeSourcePort = $('#negativeSourcePort').is(':checked') ? "on" : "off";
    var sourcePort = document.getElementById('sourcePort').value;
    var negativeDestinationHostNet = $('#negativeDestinationHostNet').is(':checked') ? "on" : "off";
    var destinationHostNet = document.getElementById('destinationHostNet').value;
    var negativeDestinationPort = $('#negativeDestinationPort').is(':checked') ? "on" : "off";
    var destinationPort = document.getElementById('destinationPort').value;
    var negativeInterfaceIncoming = $('#negativeInterfaceIncoming').is(':checked') ? "on" : "off";
    var interfaceIncoming = document.getElementById('interfaceIncoming').value;
    var negativeInterfaceOutgoing = $('#negativeInterfaceOutgoing').is(':checked') ? "on" : "off";
    var interfaceOutgoing = document.getElementById('interfaceOutgoing').value;
    var searchInPacket = document.getElementById('searchInPacket').value;
    var comments = document.getElementById('comments').value;
    var negativeProtocol = $('#negativeProtocol').is(':checked') ? "on" : "off";
    var protocol = document.getElementById('protocol').value;
    var negativeIcmpType = $('#negativeIcmpType').is(':checked') ? "on" : "off";
    var icmpType = document.getElementById('icmpType').value;
    var fragmentation = document.getElementById('fragmentation').value;
    var negativeMac = $('#negativeMac').is(':checked') ? "on" : "off";
    var mac = document.getElementById('mac').value;
    var limitBurts = document.getElementById('limitBurts').value;
    var limitRate = document.getElementById('limitRate').value;
    var limitPeriod = document.getElementById('limitPeriod').value;
    var state = document.getElementById('state').value;
    var negativeState = $('#negativeState').is(':checked') ? "on" : "off";
    var tos = document.getElementById('tos').value;
    var negativeTos = $('#negativeTos').is(':checked') ? "on" : "off";
    var negativeFlag = $('#negativeFlag').is(':checked') ? "on" : "off";
    var flag = document.getElementById('flag').value;
    var tcpFlagSet = $('#tcpFlagSet').val();
    var tcpFlagUnset = $('#tcpFlagUnset').val();
    var target = document.getElementById('target').value;

    if (ruleName == "" || ruleName == undefined || ruleName.length < 1) {
        alertify.alert("name is require");
        button.disabled = false;
        return;
    }


    alertify.log("waiting confirmation from the firewall");

    $.ajax({
        url: "appendAdvancedRule",
        type: "POST",
        data: {
            ruleName: ruleName,
            negativeSourceHostNet: negativeSourceHostNet,
            sourceHostNet: sourceHostNet,
            negativeSourcePort: negativeSourcePort,
            sourcePort: sourcePort,
            negativeDestinationHostNet: negativeDestinationHostNet,
            destinationHostNet: destinationHostNet,
            negativeDestinationPort: negativeDestinationPort,
            destinationPort: destinationPort,
            negativeInterfaceIncoming: negativeInterfaceIncoming,
            interfaceIncoming: interfaceIncoming,
            negativeInterfaceOutgoing: negativeInterfaceOutgoing,
            interfaceOutgoing: interfaceOutgoing,
            searchInPacket: searchInPacket,
            comments: comments,
            negativeProtocol: negativeProtocol,
            protocol: protocol,
            negativeIcmpType: negativeIcmpType,
            icmpType: icmpType,
            fragmentation: fragmentation,
            negativeMac: negativeMac,
            mac: mac,
            limitBurts: limitBurts,
            limitRate: limitRate,
            limitPeriod: limitPeriod,
            state: state,
            negativeState: negativeState,
            tos: tos,
            negativeTos: negativeTos,
            negativeFlag: negativeFlag,
            flag: flag,
            tcpFlagSet: tcpFlagSet,
            tcpFlagUnset: tcpFlagUnset,
            target: target
        }, success: function(data) {

            data = data.split('&quot;').join('"');
            var json = jQuery.parseJSON(data);

            if (json.hasOwnProperty("error")) {
                alertify.error(json.error);
                button.disabled = false;
            } else {
                confirmAppendRule(json);
            }

        }, error: function() {
            errorMessage(standartError);
            button.disabled = false;
        }

    });


} // end appendAdvancedRule

//==============================================================================
function confirmAppendRule(json) {

    if (json.created) {
        alertify.confirm("confirm the creation of the rule,<br/>you have 30 seconds to confirm", function(e) {
            if (e) {
                responseRule(true, json.id);
            } else {
                responseRule(false, json.id);
            }
        });
    } else {
        alertify.log("imposible to create rule");
    }

    document.getElementById('buttonAppendAdvancedRule').disabled = false;

} // end confirmAppendRule

//==============================================================================
function protocolChange() {

    var protocol = document.getElementById('protocol').value;

    if (protocol == "icmp") {
        document.getElementById('icmpType').disabled = false;
        document.getElementById('sourcePort').disabled = true;
        document.getElementById('negativeSourcePort').disabled = true;
        document.getElementById('destinationPort').disabled = true;
        document.getElementById('negativeDestinationPort').disabled = true;
        document.getElementById('negativeFlag').disabled = true;
        document.getElementById('flag').disabled = true;
        document.getElementById('tcpFlagSet').disabled = true;
        document.getElementById('tcpFlagUnset').disabled = true;
    } else {
        document.getElementById('icmpType').disabled = true;
        document.getElementById('negativeSourcePort').disabled = false;
        document.getElementById('sourcePort').disabled = false;
        document.getElementById('destinationPort').disabled = false;
        document.getElementById('negativeDestinationPort').disabled = false;
        document.getElementById('negativeFlag').disabled = false;
        document.getElementById('flag').disabled = false;
        document.getElementById('tcpFlagSet').disabled = false;
        document.getElementById('tcpFlagUnset').disabled = false;
    }

    if (protocol == "tcp" || protocol == "udp" || protocol == "sctp") {
        document.getElementById('sourcePort').disabled = false;
        document.getElementById('negativeSourcePort').disabled = false;
        document.getElementById('destinationPort').disabled = false;
        document.getElementById('negativeDestinationPort').disabled = false;
    } else {
        document.getElementById('sourcePort').disabled = true;
        document.getElementById('negativeSourcePort').disabled = true;
        document.getElementById('destinationPort').disabled = true;
        document.getElementById('negativeDestinationPort').disabled = true;
    }

} // end 

//==============================================================================
function responseRule(createRule, id) {

    $.ajax({
        url: "responseRule",
        type: "POST",
        data: {
            createRule: createRule,
            id: id
        },
        success: function(data) {
            data = data.split('&quot;').join('"');
            var json = jQuery.parseJSON(data);

            if (json.hasOwnProperty("error")) {
                alertify.error(json.error);
            } else {
                alertify.log(json.message);
            }

        }, error: function() {
            errorMessage(standartError);
        }

    });

} // end responseAdvancedRule

//==============================================================================
function changeProtocol() {

    var protocol = document.createRuleForm.protocol.value;
    var port = document.createRuleForm.port.value;

    if (protocol == "icmp") {

        if (port.length > 0) {
            alertify.alert("port is only for TCP and UDP");
        }

        document.createRuleForm.port.disabled = true;
        document.createRuleForm.port.value = "";

    } else {
        document.createRuleForm.port.disabled = false;
    }

}

//==============================================================================
function changeTrafficLabels() {

    var trafficType = document.createRuleForm.trafficType.value;

    $("#trafficLabelHost").toggleClass("text-info");
    $("#trafficLabelPort").toggleClass("text-info");

    if (trafficType == "WAN") {
        $("#trafficLabelHost").html("(external network host)");
        $("#trafficLabelPort").html("(internal network port)");
    } else {
        $("#trafficLabelHost").html("(internal network host)");
        $("#trafficLabelPort").html("(external network port)");
    }

} // end changeTrafficLabels

//==============================================================================
function createPreconfiguredRule() {

    var button = document.getElementById('createRuleButton');
    button.disabled = true;

    var form = document.createRuleForm;
    var host = form.host.value;
    var port = form.port.value;
    var target = form.target.value;
    var trafficType = form.trafficType.value;
    var comments = form.comments.value;

    var protocol = form.protocol.value;

    if (host == "" || host == undefined || host.length < 1) {
        alertify.alert("host is incorrect");
        button.disabled = false;
        return;
    }

    // port can be empty
    if (protocol != "icmp") {
        //check if port is a number
        if (port != "" || port != undefined) {
            //check the range
            if (isNaN(port) || port < 0 || port > 65535) {
                alertify.alert("port is incorrect");
                button.disabled = false;
                return;
            }
        }
    }

    if (target == "" || target == undefined || target.length < 1) {
        alertify.alert("target is incorrect");
        button.disabled = false;
        return;
    }

    if (trafficType == "" || trafficType == undefined || trafficType.length < 1) {
        alertify.alert("traffic type is incorrect");
        button.disabled = false;
        return;
    }

    if (protocol == "" || protocol == undefined || protocol.length < 1) {
        alertify.alert("protocol is incorrect");
        button.disabled = false;
        return;
    }

    $.ajax({
        url: "createPreconfiguredRule",
        type: "POST",
        data: {
            host: host,
            port: port,
            target: target,
            trafficType: trafficType,
            protocol: protocol,
            comments: comments
        }, success: function(data) {
            button.disabled = false;
            alertify.alert(data);
        }, error: function() {
            button.disabled = false;
            errorMessage(standartError);
        }

    });


} // end createRule

//==============================================================================
function deleteRule(id, chain, table, button) {

    alertify.confirm("do you want to delete the rule?", function(e) {

        if (e) {

            button.disabled = true;
            button.value = "deleting";

            $.ajax({
                url: "deleteFirewallRule",
                type: "POST",
                data: {
                    id: id,
                    chain: chain,
                    table: table
                }, success: function(data) {
                    alertify.log(data);
                    rulesTable();
                }, error: function() {
                    errorMessage(standartError);
                    button.disabled = false;
                }

            });

        } else {
            // user clicked "cancel"
        }
    });

}

//==============================================================================
function detailsRulesFirewall(date, user, comments, id, chain, tableType, description) {

    $('#toggleDivModal').removeClass("alert alert-warning");
    $('#toggleDivModal').html("");
    $("#dateRuleDetail").html(date);
    $("#userRuleDetail").html(user);
    $("#commentsRuleDetail").html(comments);
    $("#descriptionRuleDetail").html(description);

} // end detailsRulesFirewall

//==============================================================================
function errorMessage(text) {
    alertify.alert(text);
} // end error

//==============================================================================
function fooTable() {

    $(function() {
        $('table').footable();
    });

} // fooTable

//=============================================================================
function loadWebSocket(wsPath) {

    try {

        new WebSocket(wsPath);

    } catch (e) {
        error(standartError);
    }

} // end loadWebSocket

//==============================================================================
function movePosition(id, chain, table, position) {

    alertify.confirm("do you want to move the rule?", function(e) {

        if (e) {

            $("#rulesTable").html(loaderDiv);

            $.ajax({
                url: "movePosition",
                type: "POST",
                data: {
                    id: id,
                    chain: chain,
                    table: table,
                    position: position
                },
                success: function(data) {
                    alertify.log(data);
                    rulesTable();
                }, error: function() {
                    errorMessage(standartError);
                }

            });

        } else {
            // user clicked "cancel"
        }
    });

} // end movePosition

//==============================================================================
function pressEscKey() {

    document.onkeydown = function(evt) {
        evt = evt || window.event;
        if (evt.keyCode == 27) {
            stopDetailsTrafficRule();
        }
    };

} // pressEscKey

//==============================================================================
function redirect(location) {
    window.location.href = location;
} // end redirect


//==============================================================================
function requestStatusTrafficRule(id, chain, table) {

    $.ajax({
        url: "trafficRule",
        type: "POST",
        data: {
            id: id,
            chain: chain,
            table: table
        }, success: function(data) {
            $("#detailsTrafficRule").html(data);
        }, error: function() {
            errorMessage(standartError);
        }

    });

} // end requestStatusTrafficRule


//==============================================================================
function resetFirewall() {

    alertify.confirm("do you want to reset the rules?", function(e) {

        if (e) {

            $.ajax({
                url: "resetFirewall",
                type: "POST",
                success: function(data) {
                    alertify.log(data);
                    rulesTable();
                }, error: function() {
                    errorMessage(standartError);
                }

            });

        } else {
            // user clicked "cancel"
        }
    });

} // end resetFirewall

//==============================================================================
function resetStatusRule(rule) {

    $.ajax({
        url: "resetRule",
        type: "POST",
        data: {id: rule},
        async: false
    });

}

//==============================================================================
function rulesTable() {

    $("#rulesTable").html(loaderDiv);

    $.ajax({
        url: "rulesTable",
        type: "POST",
        cache: false,
        success: function(data) {
            $("#rulesTable").html(data);
            fooTable();
        }, error: function() {
            errorMessage(standartError);
        }

    });


} // end serversTable

//==============================================================================
function runDetailsTrafficRule(id, chain, table) {

    requestStatusTrafficRule(id, chain, table);

    intervalDetailsRules = setInterval(function() {
        requestStatusTrafficRule(id, chain, table);
    }, 1000);

} // end runDetailsRules


//==============================================================================
function rulesStatusInterval() {

    $("#result").html(loaderDiv);

    intervalRulesStatus = setInterval(function() {

        $.ajax({
            url: "rulesStatusInterval",
            type: "POST",
            success: function(data) {
                $("#result").html(data);
            }, error: function() {
                errorMessage(standartError);
            }

        });

    }, 1500);

} // end rulesStatusInterval


//==============================================================================
function serversTable() {

    $("#serversTable").html(loaderDiv);

    $.ajax({
        url: "serversTable",
        type: "POST",
        success: function(data) {
            $("#serversTable").html(data);
            fooTable();
        }, error: function() {
            errorMessage(standartError);
        }

    });


} // end serversTable

//==============================================================================
function setStatusFirewall(status) {

    if (status === "enabled") {
        status = "disabled";
    } else {
        status = "enabled";
    }

    alertify.confirm("do you want to " + status + " the firewall?", function(e) {

        if (e) {

            $.ajax({
                url: "firewallStatus",
                type: "POST",
                data: {
                    status: status
                },
                success: function(data) {
                    alertify.log(data);
                    rulesTable();
                }, error: function() {
                    errorMessage(standartError);
                }

            });

        } else {
            // user clicked "cancel"
        }
    });

} // end setStatusFirewall


//==============================================================================
function stopDetailsTrafficRule() {
    clearInterval(intervalDetailsRules);
} // end stopRulesStatus

//==============================================================================
function taskTable() {

    $("#result").html(loaderDiv);

    $.ajax({
        url: "taskTable",
        type: "POST",
        success: function(data) {alert(data);
            $("#result").html(data);
        }, error: function() {
            errorMessage(standartError);
        }

    });

} // end taskTable
