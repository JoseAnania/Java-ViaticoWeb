
package Servlets;

import Controlador.Conexion;
import Modelo.Viatico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAltaViatico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Conexion C=new Conexion();
            ArrayList lista=C.comboE();
            request.setAttribute("lista", lista);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaViatico.jsp");
            rd.forward(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String legajo=request.getParameter("cboEmpleado");
        String concepto=request.getParameter("concepto");
        String importe=request.getParameter("importe");
        
        Viatico V=new Viatico();
        
        V.setLegajo(Integer.parseInt(legajo));
        V.setConcepto(concepto);
        V.setImporte(Float.parseFloat(importe));
        
        Conexion C=new Conexion();
        C.agregarViatico(V);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Viáticos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"index.html\">Volver</a></li>");
            out.println("<h1>Se cargo el Viático exitosamente</h1>");
            out.println("</body>");
            out.println("</html>");
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
