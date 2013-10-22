package org.apache.jsp.pages.firewall;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class preconfiguredRule_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_text_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_include_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_text_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_include_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_text_name_nobody.release();
    _jspx_tagPool_s_include_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      if (_jspx_meth_s_include_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_s_include_1(_jspx_page_context))
        return;
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_s_include_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <h1>\n");
      out.write("                ");
      if (_jspx_meth_s_text_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </h1>\n");
      out.write("\n");
      out.write("            <hr>\n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_s_include_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-default alert-warning\" role=\"navigation\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\">\n");
      out.write("                        ");
      if (_jspx_meth_s_text_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse navbar-ex1-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"firewall\">\n");
      out.write("                                ");
      if (_jspx_meth_s_text_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </li>                                                \n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"advancedRule\">\n");
      out.write("                                ");
      if (_jspx_meth_s_text_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>                                        \n");
      out.write("                </div><!-- /.navbar-collapse -->\n");
      out.write("            </nav> \n");
      out.write("\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            <div class=\"container\">  \n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <h3 class=\"panel-title\">\n");
      out.write("                                ");
      if (_jspx_meth_s_text_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </h3>\n");
      out.write("                        </div>  \n");
      out.write("\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                            <form name=\"createRuleForm\" id=\"createRuleForm\" action=\"\" method=\"POST\" enctype=\"application/x-www-form-urlencoded\">\n");
      out.write("\n");
      out.write("                                <fieldset>\n");
      out.write("\n");
      out.write("                                    <legend>\n");
      out.write("                                        ");
      if (_jspx_meth_s_text_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </legend>                                    \n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-2\">\n");
      out.write("                                            <label for=\"chain\">\n");
      out.write("                                                ");
      if (_jspx_meth_s_text_6(_jspx_page_context))
        return;
      out.write("                                            \n");
      out.write("                                            </label>\n");
      out.write("                                            <select name=\"trafficType\" id=\"trafficType\" class=\"form-control\" tabindex=\"1\" onchange=\"changeTrafficLabels();\">\n");
      out.write("                                                <option value=\"LAN\">LAN</option>\n");
      out.write("                                                <option value=\"WAN\">WAN</option>\n");
      out.write("                                            </select>                                     \n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-3\">\n");
      out.write("                                            <label for=\"host\">                                                                                    \n");
      out.write("                                                ");
      if (_jspx_meth_s_text_7(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                <span class=\"text-warning\" id=\"trafficLabelHost\">(external network)</span>\n");
      out.write("                                            </label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"host\" id=\"host\" placeholder=\"");
      if (_jspx_meth_s_text_8(_jspx_page_context))
        return;
      out.write("\" tabindex=\"2\" required=\"required\" max=\"32\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-3\">\n");
      out.write("                                            <label for=\"port\">\n");
      out.write("                                                ");
      if (_jspx_meth_s_text_9(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                <span class=\"text-warning\" id=\"trafficLabelPort\">(internal port network)</span>\n");
      out.write("                                            </label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" name=\"port\" id=\"port\" placeholder=\"");
      if (_jspx_meth_s_text_10(_jspx_page_context))
        return;
      out.write("\" tabindex=\"3\" required=\"required\" max=\"65535\" maxlength=\"5\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-2\">\n");
      out.write("                                            <label for=\"target\">\n");
      out.write("                                                ");
      if (_jspx_meth_s_text_11(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </label>\n");
      out.write("                                            <select name=\"target\" id=\"target\" class=\"form-control\" tabindex=\"4\">\n");
      out.write("                                                <option value=\"allow\">allow</option>\n");
      out.write("                                                <option value=\"deny\">deny</option>\n");
      out.write("                                            </select>                                     \n");
      out.write("                                        </div>                                    \n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-2\">\n");
      out.write("                                            <label for=\"protocol\">\n");
      out.write("                                                ");
      if (_jspx_meth_s_text_12(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </label>\n");
      out.write("                                            <select name=\"protocol\" id=\"protocol\" onchange=\"changeProtocol();\" class=\"form-control\" tabindex=\"5\">\n");
      out.write("                                                <option value=\"tcp\">TCP</option>\n");
      out.write("                                                <option value=\"udp\">UDP</option>\n");
      out.write("                                                <option value=\"icmp\">ICMP</option>\n");
      out.write("                                            </select>                                     \n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group col-lg-12\">\n");
      out.write("                                            <label for=\"comments\">\n");
      out.write("                                                ");
      if (_jspx_meth_s_text_13(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </label>\n");
      out.write("                                            <textarea class=\"form-control\" rows=\"3\" id=\"comments\" name=\"comments\" tabindex=\"6\"></textarea>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <button type=\"button\" id=\"createRuleButton\" onclick=\"createPreconfiguredRule();\" class=\"btn btn-block btn-success\" tabindex=\"7\">\n");
      out.write("                                        ");
      if (_jspx_meth_s_text_14(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </button>\n");
      out.write("\n");
      out.write("                                    <br/>\n");
      out.write("\n");
      out.write("                                </fieldset>\n");
      out.write("\n");
      out.write("                            </form>                            \n");
      out.write("\n");
      out.write("                        </div>    \n");
      out.write("\n");
      out.write("                    </div> \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_s_include_4(_jspx_page_context))
        return;
      out.write("        \n");
      out.write("\n");
      out.write("            </div>       \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_include_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_include_0 = (org.apache.struts2.views.jsp.IncludeTag) _jspx_tagPool_s_include_value_nobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_include_0.setPageContext(_jspx_page_context);
    _jspx_th_s_include_0.setParent(null);
    _jspx_th_s_include_0.setValue("/pages/application/metas.jsp");
    int _jspx_eval_s_include_0 = _jspx_th_s_include_0.doStartTag();
    if (_jspx_th_s_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_0);
      return true;
    }
    _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_0);
    return false;
  }

  private boolean _jspx_meth_s_include_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_include_1 = (org.apache.struts2.views.jsp.IncludeTag) _jspx_tagPool_s_include_value_nobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_include_1.setPageContext(_jspx_page_context);
    _jspx_th_s_include_1.setParent(null);
    _jspx_th_s_include_1.setValue("/pages/application/header.jsp");
    int _jspx_eval_s_include_1 = _jspx_th_s_include_1.doStartTag();
    if (_jspx_th_s_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_1);
      return true;
    }
    _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_1);
    return false;
  }

  private boolean _jspx_meth_s_include_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_include_2 = (org.apache.struts2.views.jsp.IncludeTag) _jspx_tagPool_s_include_value_nobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_include_2.setPageContext(_jspx_page_context);
    _jspx_th_s_include_2.setParent(null);
    _jspx_th_s_include_2.setValue("/pages/application/navigation.jsp");
    int _jspx_eval_s_include_2 = _jspx_th_s_include_2.doStartTag();
    if (_jspx_th_s_include_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_2);
      return true;
    }
    _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_2);
    return false;
  }

  private boolean _jspx_meth_s_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_0 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_0.setPageContext(_jspx_page_context);
    _jspx_th_s_text_0.setParent(null);
    _jspx_th_s_text_0.setName("firewall.rules.create.preconfigured.title");
    int _jspx_eval_s_text_0 = _jspx_th_s_text_0.doStartTag();
    if (_jspx_th_s_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
    return false;
  }

  private boolean _jspx_meth_s_include_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_include_3 = (org.apache.struts2.views.jsp.IncludeTag) _jspx_tagPool_s_include_value_nobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_include_3.setPageContext(_jspx_page_context);
    _jspx_th_s_include_3.setParent(null);
    _jspx_th_s_include_3.setValue("/pages/application/breadcrumb.jsp");
    int _jspx_eval_s_include_3 = _jspx_th_s_include_3.doStartTag();
    if (_jspx_th_s_include_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_3);
      return true;
    }
    _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_3);
    return false;
  }

  private boolean _jspx_meth_s_text_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_1 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_1.setPageContext(_jspx_page_context);
    _jspx_th_s_text_1.setParent(null);
    _jspx_th_s_text_1.setName("firewall.rules.preconfigured.subnavigation.brand");
    int _jspx_eval_s_text_1 = _jspx_th_s_text_1.doStartTag();
    if (_jspx_th_s_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_1);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_1);
    return false;
  }

  private boolean _jspx_meth_s_text_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_2 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_2.setPageContext(_jspx_page_context);
    _jspx_th_s_text_2.setParent(null);
    _jspx_th_s_text_2.setName("firewall.rules.preconfigured.subnavigation.link.1");
    int _jspx_eval_s_text_2 = _jspx_th_s_text_2.doStartTag();
    if (_jspx_th_s_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_2);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_2);
    return false;
  }

  private boolean _jspx_meth_s_text_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_3 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_3.setPageContext(_jspx_page_context);
    _jspx_th_s_text_3.setParent(null);
    _jspx_th_s_text_3.setName("firewall.rules.preconfigured.subnavigation.link.3");
    int _jspx_eval_s_text_3 = _jspx_th_s_text_3.doStartTag();
    if (_jspx_th_s_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_3);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_3);
    return false;
  }

  private boolean _jspx_meth_s_text_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_4 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_4.setPageContext(_jspx_page_context);
    _jspx_th_s_text_4.setParent(null);
    _jspx_th_s_text_4.setName("firewall.rules.form.create.preconfigured.panel.title");
    int _jspx_eval_s_text_4 = _jspx_th_s_text_4.doStartTag();
    if (_jspx_th_s_text_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_4);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_4);
    return false;
  }

  private boolean _jspx_meth_s_text_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_5 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_5.setPageContext(_jspx_page_context);
    _jspx_th_s_text_5.setParent(null);
    _jspx_th_s_text_5.setName("firewall.rules.form.create.preconfigured.panel.legend");
    int _jspx_eval_s_text_5 = _jspx_th_s_text_5.doStartTag();
    if (_jspx_th_s_text_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_5);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_5);
    return false;
  }

  private boolean _jspx_meth_s_text_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_6 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_6.setPageContext(_jspx_page_context);
    _jspx_th_s_text_6.setParent(null);
    _jspx_th_s_text_6.setName("firewall.rules.form.traffic.type");
    int _jspx_eval_s_text_6 = _jspx_th_s_text_6.doStartTag();
    if (_jspx_th_s_text_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_6);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_6);
    return false;
  }

  private boolean _jspx_meth_s_text_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_7 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_7.setPageContext(_jspx_page_context);
    _jspx_th_s_text_7.setParent(null);
    _jspx_th_s_text_7.setName("firewall.rules.form.host");
    int _jspx_eval_s_text_7 = _jspx_th_s_text_7.doStartTag();
    if (_jspx_th_s_text_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_7);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_7);
    return false;
  }

  private boolean _jspx_meth_s_text_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_8 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_8.setPageContext(_jspx_page_context);
    _jspx_th_s_text_8.setParent(null);
    _jspx_th_s_text_8.setName("firewall.rules.form.host.placeholder");
    int _jspx_eval_s_text_8 = _jspx_th_s_text_8.doStartTag();
    if (_jspx_th_s_text_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_8);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_8);
    return false;
  }

  private boolean _jspx_meth_s_text_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_9 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_9.setPageContext(_jspx_page_context);
    _jspx_th_s_text_9.setParent(null);
    _jspx_th_s_text_9.setName("firewall.rules.form.port");
    int _jspx_eval_s_text_9 = _jspx_th_s_text_9.doStartTag();
    if (_jspx_th_s_text_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_9);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_9);
    return false;
  }

  private boolean _jspx_meth_s_text_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_10 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_10.setPageContext(_jspx_page_context);
    _jspx_th_s_text_10.setParent(null);
    _jspx_th_s_text_10.setName("firewall.rules.form.port.placeholder");
    int _jspx_eval_s_text_10 = _jspx_th_s_text_10.doStartTag();
    if (_jspx_th_s_text_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_10);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_10);
    return false;
  }

  private boolean _jspx_meth_s_text_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_11 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_11.setPageContext(_jspx_page_context);
    _jspx_th_s_text_11.setParent(null);
    _jspx_th_s_text_11.setName("firewall.rules.form.target");
    int _jspx_eval_s_text_11 = _jspx_th_s_text_11.doStartTag();
    if (_jspx_th_s_text_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_11);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_11);
    return false;
  }

  private boolean _jspx_meth_s_text_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_12 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_12.setPageContext(_jspx_page_context);
    _jspx_th_s_text_12.setParent(null);
    _jspx_th_s_text_12.setName("firewall.rules.form.protocol");
    int _jspx_eval_s_text_12 = _jspx_th_s_text_12.doStartTag();
    if (_jspx_th_s_text_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_12);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_12);
    return false;
  }

  private boolean _jspx_meth_s_text_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_13 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_13.setPageContext(_jspx_page_context);
    _jspx_th_s_text_13.setParent(null);
    _jspx_th_s_text_13.setName("firewall.rules.form.comments");
    int _jspx_eval_s_text_13 = _jspx_th_s_text_13.doStartTag();
    if (_jspx_th_s_text_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_13);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_13);
    return false;
  }

  private boolean _jspx_meth_s_text_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_14 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_14.setPageContext(_jspx_page_context);
    _jspx_th_s_text_14.setParent(null);
    _jspx_th_s_text_14.setName("firewall.rules.form.button.save");
    int _jspx_eval_s_text_14 = _jspx_th_s_text_14.doStartTag();
    if (_jspx_th_s_text_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_14);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_14);
    return false;
  }

  private boolean _jspx_meth_s_include_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_include_4 = (org.apache.struts2.views.jsp.IncludeTag) _jspx_tagPool_s_include_value_nobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_include_4.setPageContext(_jspx_page_context);
    _jspx_th_s_include_4.setParent(null);
    _jspx_th_s_include_4.setValue("/pages/application/footer.jsp");
    int _jspx_eval_s_include_4 = _jspx_th_s_include_4.doStartTag();
    if (_jspx_th_s_include_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_4);
      return true;
    }
    _jspx_tagPool_s_include_value_nobody.reuse(_jspx_th_s_include_4);
    return false;
  }
}
