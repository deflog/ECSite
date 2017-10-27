/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
@WebServlet(name = "Resultdetail", urlPatterns = {"/Resultdetail"})
public class Resultdetail extends HttpServlet {

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
       //session.removeAttribute("path");
       request.setAttribute("path","Searchresult");
        
            /* TODO output your page here. You may use following sample code. */
         String disp = "/Resultdetail.jsp";
      RequestDispatcher dispatch = request.getRequestDispatcher(disp);
      dispatch.forward(request, response);
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
        HttpSession session = request.getSession(false);
           jums jums =new jums();
        request.setCharacterEncoding("UTF-8");
       String ward = request.getQueryString();
       if(!ward.equals("")){
       StringBuilder sb= new StringBuilder(ward);
       ward = sb.delete(0,3).toString();
        URL url = new URL(jums.createCode(ward));
        
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
        
        session.setAttribute("item",syo.codeSyouhin(getResponse));
       }else{
       request.setAttribute("error","セッションがありません");
       request.getRequestDispatcher("/error.jsp").forward(request, response);
       }
        
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
