/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

 import jakarta.servlet.ServletException;
 import jakarta.servlet.annotation.WebServlet;
 import jakarta.servlet.http.HttpServlet;
 import jakarta.servlet.http.HttpServletRequest;
 import jakarta.servlet.http.HttpServletResponse;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.*;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 
 /**
  *
  * @author gunja
  */
 @WebServlet(urlPatterns = {"/loginServlet"})
 public class loginServlet extends HttpServlet {
 
     private static final long serialVersionUID = 1L;
     
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         response.setContentType("text/Html");
         PrintWriter out=response.getWriter();
         String usernam;
         usernam = request.getParameter("usernam");
         String password=request.getParameter("password");
         
         try {
             Class.forName("com.mysql.jdbc.Driver");
             try (Connection con = DriverManager.getConnection("","root","")) {
                 Statement stm=con.createStatement();
                 ResultSet rs=stm.executeQuery("select*from login where usernam='"+usernam+"'and password='"+password+"'");
                 if(con!=null)
                 {
                     System.out.println("successfull");
                 }
                 if(rs.next())
                 {
                     response.sendRedirect("Home.html");
                 }
                 else
                 {
                     out.print("user name or password is not correct");
                 }
             }
         }
             
             
         catch (ClassNotFoundException e) {
             System.out.println(e.getMessage());
         
         
     }   catch (SQLException ex) {
             Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
 
     
     }
 }