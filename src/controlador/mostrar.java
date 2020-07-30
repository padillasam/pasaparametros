package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class mostrar
 */
@WebServlet("/mostrar")
public class mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection conexion=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrar() {
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
		mensajes.println("<!DOCTYPE html>"
				+"<html>"
				+"<head>"
				+"<style>"
				+    "body{"
				+	 "background:grey;}"
				+"table{background:white;}"
				+ "body{font-family:arial;}"
				+"	</style>"
				+"</head>"
				+"<body>");
		mensajes.println("<table border=1>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","agendausuario","agendap");
			Statement s=conexion.createStatement();
			ResultSet resultado=s.executeQuery("SELECT * FROM entradas");
			while (resultado.next()) {
				mensajes.println("<tr><td>"+resultado.getObject("identrada")+"</td><td>"+resultado.getObject("nombre")+"</td><td>"+resultado.getObject("email")+"</td><td>"+resultado.getObject("fecha")+"</td></tr>");
			}			
			mensajes.println("Registro exitoso !!!!");
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		mensajes.println("</table>"
				+"</body>"
				+"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
