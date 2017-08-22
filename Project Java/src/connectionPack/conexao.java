/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionPack;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gilberto
 */
public class conexao {
   
   private static String DRIVE = "com.mysql.jdbc.Driver";
   
   private static String ip;
   private static String usuario;
   private static String senha;
   private static String banco;
   private static String porta; 

    
   public static void connectionBd()
   {
    porta   ="3306";
    ip      = "localhost";
    usuario = "root";
    banco   ="infoTech";
    senha   ="";
   }    
   
   public static Connection  obterConexao(){
       
       connectionBd();
       String url ="jdbc:mysql://"+ip+":"+porta+"/"+banco+""; 
           
       try {
           Class.forName(DRIVE);
           return DriverManager.getConnection(url, usuario ,senha);
       }
       catch (ClassNotFoundException | SQLException ex) {
         JOptionPane.showMessageDialog(null,"Ocorreu Um Erro Na Conexao"+ex);
         
       }
       return null;
   }
   
   public static void fecharConexao(Connection conn){
     if (conn!=null){
       try {
           conn.close();
       } catch (SQLException ex) {
           
       }
     }   
   }
      public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs){
   
          try {
           
           if(stmt != null || conn!= null || rs != rs ){
           stmt.close();
           rs.close();
           conn.close();
           }
           
       } catch (SQLException ex) {
       throw new RuntimeException ("Ocorreu Um Erro :",ex);    
       }
   }
         public static void fecharConexao(Connection conn, PreparedStatement stmt){
   
          try {
           
           if(stmt != null || conn!= null ){
           stmt.close();
           
           conn.close();
           }
           
       } catch (SQLException ex) {
       throw new RuntimeException ("Ocorreu Um Erro :",ex);    
       }
   }
   
}


