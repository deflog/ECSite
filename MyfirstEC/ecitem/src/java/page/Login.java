/*
 * アクセス元のページurlを渡して！
 */
package page;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author geust1Day
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        try{
        String access = request.getParameter("ac");
        if(access==null||(Integer)session.getAttribute("ac")!=Integer.parseInt(access)){
            throw new Exception("不正なアクセスです");
        }
        
        String bl = "0";
        
        if(session.getAttribute("user")==null){
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        UserData ud = new UserData();
        ud.setName(id);
        ud.setPassword(pass);
        UserDataDAO udd = new UserDataDAO();
       
        
        try{
             udd.checkLogin(ud);
        if(id.equals(udd.checkLogin(ud).getName())&&pass.equals(udd.checkLogin(ud).getPassword())){
        bl="1";
       
        session.setAttribute("user",id);
        session.removeAttribute("ud");
        }
       
        
        }catch(SQLException e){
        System.out.print(e.getMessage());
        }
        }else{
        session.removeAttribute("user");
        session.removeAttribute("cart");
        bl="2";
        }
        String st = request.getParameter("path");
        session.setAttribute("path",st);
              
                request.setAttribute("check",bl);
               String disp = "/Login.jsp";
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
        processRequest(request, response);
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
        processRequest(request, response);
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
