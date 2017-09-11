/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.classes;

import java.awt.List;
import principal.classes.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus
 */
public class Crud {
    
    ArrayList<Pessoa> pessoas = new ArrayList();
    public Pessoa[] vetor = new Pessoa[50];

    public void create(Pessoa p) throws SQLException {
        PreparedStatement pstmt = null;
        int updateQuery = 0;
        Connection conn = ConexaoBanco.getConnection();
        boolean retorno = true;

        try {
            String queryString = "INSERT INTO pessoa(nome, idade) VALUES(?,? )";
            pstmt = conn.prepareStatement(queryString);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getIdade());
            pstmt.executeUpdate();
            
            if (updateQuery != 0) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            } else {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void read(Pessoa p) throws SQLException {
        Connection conn = ConexaoBanco.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa WHERE id = " + p.getId());
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getString("idade"));
            }
            JOptionPane.showMessageDialog(null, "Código: " + p.getId() + "\n\nNome: " + p.getNome() + "\n\nIdade: " + p.getIdade());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void update(Pessoa p) throws SQLException {
        PreparedStatement pstmt = null;

        Connection conn = ConexaoBanco.getConnection();
//        boolean retorno = true;
        try {
            String queryString = "UPDATE pessoa SET id = ?, nome = ?, idade = ? WHERE id = " + p.getId();
            pstmt = conn.prepareStatement(queryString);
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getNome());
            pstmt.setString(3, p.getIdade());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void delete(Pessoa p) throws SQLException {
        try {
            Connection conn = ConexaoBanco.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM pessoa WHERE id= " + p.getId());
            JOptionPane.showMessageDialog(null, "excluido com sucesso!");
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ArrayList<Pessoa> getLista() throws SQLException {
       
        Connection conn = ConexaoBanco.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa");
            
            
            while(rs.next()){
     
//               if (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getString("idade"));
                    pessoas.add(p);
//                }
//      
            }
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return pessoas;
    }

}
