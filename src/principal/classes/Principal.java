/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import principal.form.frmCrud;

/**
 *
 * @author Mateus
 */
public class Principal {

    public static void main(String args[]) throws SQLException {
        frmCrud f = new frmCrud();
        f.setVisible(true);
    }

}
