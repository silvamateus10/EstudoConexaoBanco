/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus
 */
public class ConexaoBanco {
   private ConexaoBanco(){
       PreparedStatement pstmt = null;
   }
   
   static{
       try{
           Class.forName("com.mysql.jdbc.Driver");
           
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, ex);
           System.exit(-1);
       }
   }
   public static Connection getConnection(){
       Connection conn=null;
       try{
           conn = DriverManager.getConnection(
           "jdbc:mysql://localhost/pg",
           "root",
           ""
           );
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
           
       }
       return conn;
   }
   
}
