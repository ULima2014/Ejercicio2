package edu.ulima.servlets;

import edu.ulima.daos.TbalumnoDAO;
import edu.ulima.daos.TbcarreraDAO;
import edu.ulima.entidades.Tbalumno;
import edu.ulima.entidades.Tbcarrera;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet03", urlPatterns = {"/s03"})
public class Servlet03 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo"));
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        int carreraE = Integer.parseInt(request.getParameter("carreraElegida"));
        
        TbcarreraDAO dao1 = new TbcarreraDAO();
        Tbcarrera c = dao1.retornarEspecifico(carreraE);
        
        TbalumnoDAO dao2= new TbalumnoDAO();
        System.out.println("**********************"+carreraE);
        
        Tbalumno a = new Tbalumno(id, nombre, apellido, sexo, password);
        a.setFkeycarrera(c);
        
        System.out.println(a);
        dao2.persist(a);
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
