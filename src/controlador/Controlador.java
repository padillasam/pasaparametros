package controlador;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private java.sql.Connection conexion=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter mensajes=response.getWriter();
		mensajes.println("Yo voy a recibir la información");
		mensajes.println("El nombre enviado desde el JSP es "+request.getParameter("nombre")+"<br>");
		mensajes.println("El email enviado desde el JSP es "+request.getParameter("email")+"<br>");
		mensajes.println("La fecha enviada desde el JSP es "+request.getParameter("fecha")+"<br>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","agendausuario","agendap");
			Statement s=conexion.createStatement();
			s.executeUpdate("INSERT INTO entradas VALUES(NULL,'"+request.getParameter("nombre")+"','"+request.getParameter("email")+"','"+request.getParameter("fecha")+"')");
			mensajes.println("Registro exitoso !!!!");
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
