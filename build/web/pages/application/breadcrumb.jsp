<%@taglib prefix="s" uri="/struts-tags"%>
<ol class="breadcrumb text-right">
    <li><s:property value="#session.server.name"/></li>
    <li><s:property value="#session.server.ip"/></li>
    <li><s:property value="#session.server.port"/></li>
</ol>