/*
 *セッションにカート入れるまで終わり 

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
@WebServlet(name = "Additem", urlPatterns = {"/Additem"})
public class Additem extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        try{
        String access = request.getParameter("ac");
        if(access==null||(Integer)session.getAttribute("ac")!=Integer.parseInt(access)){
            throw new Exception("不正なアクセスです");
        }
        //session.removeAttribute("path");
       
        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Syouhindatabeans shd = (Syouhindatabeans)session.getAttribute("item");
        //ユーザーネーム+itemでArrayカート作成→nullなら
        
       
        String createcart="";
        //user名どっかで取得
        
        createcart = "cart";
        
        // ArrayList<Syouhindatabeans> cart = new ArrayList();
        //codeとnameをセッションに保管
        //全情報いれてください
        /* if(session.getAttribute(createcart)==null){
        ArrayList<Syouhindatabeans> cart = new ArrayList();
        cart.add(shd);
        session.setAttribute(createcart,cart);
        }else{
        ArrayList<Syouhindatabeans> cart=(ArrayList)session.getAttribute(createcart);
        cart.add(shd);
        session.setAttribute(createcart,cart);
        }
        Cookie cookie = new Cookie("cart",createcart);
        response.addCookie(cookie);*/
        if(session.getAttribute("cart")==null){
             ArrayList<Syouhindatabeans> cart = new ArrayList();
            session.setAttribute("cart",cart);
        }
        ArrayList<Syouhindatabeans> noname = (ArrayList)session.getAttribute("cart");
        noname.add(shd);
        session.setAttribute("cart",noname);
            request.setAttribute("path","Searchresult");
            String disp = "/Additem.jsp";
            RequestDispatcher dispatch = request.getRequestDispatcher(disp);
            dispatch.forward(request, response);
        }catch(Exception e){
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                
                }
        
       //ログイン処理がまだ確定していない
        
       /*tring disp = "/Additem.jsp";
               RequestDispatcher dispatch = request.getRequestDispatcher(disp);
               dispatch.forward(request, response);*/
        
        
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
            Logger.getLogger(Additem.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Additem.class.getName()).log(Level.SEVERE, null, ex);
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
