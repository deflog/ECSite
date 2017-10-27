/*
 * DB管理で商品情報とったほうがよさそう。
 *とりあえずセッションのみで管理します。
 */
package page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author geust1Day
 */
@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
      
        try{
        String access = request.getParameter("ac");
        if(access==null||(Integer)session.getAttribute("ac")!=Integer.parseInt(access)){
            throw new Exception("不正なアクセスです");
        }
        String usercart = null;
        if(session.getAttribute("user")!=null){
        String user = (String)session.getAttribute("user");
        
        usercart = user+"cart";
        }else{
        String st = request.getServletPath();
        request.setAttribute("path",st.substring(1));
        session.setAttribute("path",(String)request.getParameter("path"));
        String disp = "/Cart.jsp";
        RequestDispatcher dispatch = request.getRequestDispatcher(disp);
        dispatch.forward(request, response);
        }
        /* Cookie cookie[]= request.getCookies();
        String cart="";
        if(cookie!=null){
        for(int i=0;i<cookie.length;i++){
        if(cookie[i].getName().equals(usercart)){
        cart=cookie[i].getValue();
        }
        }
        }*/
      
        if(usercart!=null&&(ArrayList)session.getAttribute(usercart)==null){
           ArrayList<Syouhindatabeans> shd = new ArrayList();
           session.setAttribute(usercart,shd);
           /* Cookie cok = new Cookie(usercart,usercart);
           response.addCookie(cok);*/
        }
        if((ArrayList)session.getAttribute("cart")!=null){
        ArrayList<Syouhindatabeans> ucart = (ArrayList)session.getAttribute(usercart);
        ArrayList<Syouhindatabeans> noname = (ArrayList)session.getAttribute("cart");
        ucart.addAll(noname);
        
        session.setAttribute(usercart,ucart);
        }
        session.removeAttribute("cart");
        request.setAttribute("cart",usercart);
        String st = request.getServletPath();
        request.setAttribute("path",st.substring(1));
        session.setAttribute("path",(String)request.getParameter("path"));
        String disp = "/Cart.jsp";
        RequestDispatcher dispatch = request.getRequestDispatcher(disp);
        dispatch.forward(request, response);
        
        
        }catch(Exception e){
        request.setAttribute("error", e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
