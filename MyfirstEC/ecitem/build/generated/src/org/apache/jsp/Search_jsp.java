package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("<!--検索するあたいを受け取る-->\n");
      out.write("\n");

HttpSession hs = request.getSession();
hs.getAttribute("user");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"boot/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            header.jumbotron {\n");
      out.write("                background: url(\"image/GREEN20160902172018_TP_V.jpg\");\n");
      out.write("                background-position:center center;\n");
      out.write("                background-size: cover;\n");
      out.write("                color:#101010;    \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("          \n");
      out.write("            button{\n");
      out.write("               border:0;\n");
      out.write("               background:none;\n");
      out.write("               width:auto;\n");
      out.write("               overflow:visible;\n");
      out.write("            }\n");
      out.write("        i.white{\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("         footer{\n");
      out.write("             text-align: center;\n");
      out.write("             padding: 10px;\n");
      out.write("             background: #101010;\n");
      out.write("         }\n");
      out.write("     </style>\n");
      out.write("        <title>TOP</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("          <div class=\"navbar-header\">\n");
      out.write("              <!--ロゴ-->\n");
      out.write("              <a class=\"navbar-brand\" href=\"Search\">LOGO</a>\n");
      out.write("              <!--トグルボタン-->\n");
      out.write("              <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#nav-content\">\n");
      out.write("                  <span class=\"icon-bar\"></span>\n");
      out.write("                  <span class=\"icon-bar\"></span>\n");
      out.write("                  <span class=\"icon-bar\"></span>\n");
      out.write("              </button>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"nav-content\" class=\"collapse navbar-collapse\">\n");
      out.write("              <!--リンクリスト-->\n");
      out.write("              <ul class=\"nav navbar-nav\">\n");
      out.write("                  <li><a href=\"\">Link1</a></li>\n");
      out.write("                  <li><a href=\"\">Link1</a></li>\n");
      out.write("                  <li><a href=\"\">Link1</a></li>\n");
      out.write("                  <li><a href=\"\">Link1</a></li>\n");
      out.write("              </ul>\n");
      out.write("              ");
if(hs.getAttribute("user")==null){
      out.write("\n");
      out.write("        <form class=\"navbar-form navbar-right\" action=\"Login\" method=\"POST\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("            \n");
      out.write("            <input type=\"text\" name=\"id\" maxlength=\"10\"class=\"form-control\" placeholder=\"user\">\n");
      out.write("            \n");
      out.write("            <input type=\"password\" name=\"pass\" maxlength=\"8\"class=\"form-control\" placeholder=\"password\">\n");
      out.write("            <input type=\"hidden\" name=\"path\" value=\"");
      out.print((String)request.getAttribute("path"));
      out.write("\">\n");
      out.write("             <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <span><i class=\"glyphicon glyphicon-plus-sign white\"></i></span>\n");
      out.write("            </button>\n");
      out.write("        </form>\n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("            <form class=\"navbar-form navbar-right\" action=\"Login\" method=\"POST\">\n");
      out.write("                 <input type=\"hidden\" name=\"path\" value=\"");
      out.print((String)request.getAttribute("path"));
      out.write("\">\n");
      out.write("                 <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("                <button type=\"submit\">\n");
      out.write("                <span><i class=\"glyphicon glyphicon-minus-sign white\"></i></span>\n");
      out.write("            </button>\n");
      out.write("            </form>\n");
      out.write("            <form class=\"navbar-form navbar-right\" action=\"Mydata\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"path\" value=\"");
      out.print((String)request.getAttribute("path"));
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <span><i class=\"glyphicon glyphicon-user white\"></i></span>\n");
      out.write("            </button>  \n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("             <form class=\"navbar-form navbar-right\" action=\"cart\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"path\" value=\"");
      out.print((String)request.getAttribute("path"));
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <span><i class=\"glyphicon glyphicon-shopping-cart white\"></i></span>\n");
      out.write("            </button>\n");
      out.write("            </form>\n");
      out.write("             <form class=\"navbar-form navbar-right\" action=\"Registration\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"path\" value=\"");
      out.print((String)request.getAttribute("path"));
      out.write("\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            <button type=\"submit\">\n");
      out.write("                <span><i class=\"glyphicon glyphicon-leaf white\"></i></span>\n");
      out.write("            </button>\n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("      </nav>\n");
      out.write("            <header class=\"jumbotron\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("              <h1>Buy for Free</h1>\n");
      out.write("              <p>form</p>\n");
      out.write("              <p>好きなものを好きなだけ購入できる仮想ショッピングサイトです</p>\n");
      out.write("              \n");
      out.write("              <p><form action=\"Searchresult\" method=\"GET\">\n");
      out.write("                  <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("                  <div class=\"input-group\">\n");
      out.write("                  <input class=\"form-control\" type=\"text\" name=\"ward\"placeholder=\"Search\">\n");
      out.write("                  <span class=\"input-group-btn\">\n");
      out.write("                  <button class=\"btn btn-default\" type=\"submit\">\n");
      out.write("                      <i class='glyphicon glyphicon-search'></i>\n");
      out.write("                 </button>\n");
      out.write("                  </span>\n");
      out.write("                  </div>\n");
      out.write("         \n");
      out.write("                  \n");
      out.write("              </form></p>\n");
      out.write("              \n");
      out.write("          </div>\n");
      out.write("      </header>\n");
      out.write("       \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
