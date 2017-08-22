/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import connectionPack.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberto
 */
public class login {
 
    
    public static Boolean logar(String Usuario, String Senha) throws SQLException{
    
        Connection conn = conexao.obterConexao();
        PreparedStatement stmt = null;
        String select;        
        select = "SELECT nomeUsuario, pass, Nome, email, nascimento,endereco, cpf, rg, setor, funcao, nivel FROM usuario WHERE nomeUsuario ='"+Usuario+"' and pass ='"+Senha+"'";
        
        try{
            
        stmt = conn.prepareStatement(select);
         
            ResultSet log = stmt.executeQuery();
        
            if (log.next()){
             
            
                    return true;
            } 
            else {
                
                return false;
            }   
        }            
        catch(SQLException error){
                 JOptionPane.showMessageDialog(null,"Ocorreu Um Erro Na Conexao"+error);
        
                }        
        return null;
        
    }
          
}
