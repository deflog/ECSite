/*
 * 検索結果をsession:syoに格納 Searchresult.jspに遷移
 */
package page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Searchresult", urlPatterns = {"/Searchresult"})
public class Searchresult extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        try{
        String access = request.getParameter("ac");
        if(access==null||(Integer)session.getAttribute("ac")!=Integer.parseInt(access)){
            throw new Exception("不正なアクセスです");
        }
        
        response.setContentType("text/html;charset=UTF-8");
       //session.removeAttribute("path");
       String st = request.getServletPath();
       request.setAttribute("path",st.substring(1));
      String disp = "/Searchresult.jsp";
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
        jums jums =new jums();
        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");
        String ward = request.getParameter("ward");
      
        if(ward==null&&session.getAttribute("syo")!=null){
            
            System.out.print("検索結果をもう一度");
        }else if(!ward.equals("")){
        
         
        
        URL url = new URL(jums.createUrl(ward));
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("GET");
        
          BufferedReader bufferReader
                = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String getResponse = new String();
        String str;

        while ((str = bufferReader.readLine()) != null) {
            getResponse = getResponse + str;

        }
        bufferReader.close();

        connection.disconnect();

        
        
       setSyouhin syo = new setSyouhin();
        
        session.setAttribute("syo",syo.setSyouhin(getResponse));
        }else{
        request.setAttribute("error","キーワードを入力してください。");
        request.getRequestDispatcher("Search").forward(request, response);
        }
        
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Searchresult.class.getName()).log(Level.SEVERE, null, ex);
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
            jums jums =new jums();
        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");
        String ward = request.getParameter("ward");
      
        if(ward==null&&session.getAttribute("syo")!=null){
            
            System.out.print("検索結果をもう一度");
        }else if(!ward.equals("")){
        
         
        
        URL url = new URL(jums.createUrl(ward));
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("GET");
        
          BufferedReader bufferReader
                = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String getResponse = new String();
        String str;

        while ((str = bufferReader.readLine()) != null) {
            getResponse = getResponse + str;

        }
        bufferReader.close();

        connection.disconnect();

        
        
       setSyouhin syo = new setSyouhin();
        
        session.setAttribute("syo",syo.setSyouhin(getResponse));
        }else{
        request.setAttribute("error","キーワードを入力してください。");
        request.getRequestDispatcher("Search").forward(request, response);
        }
        
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Searchresult.class.getName()).log(Level.SEVERE, null, ex);
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
