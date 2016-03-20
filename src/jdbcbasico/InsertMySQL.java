/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbasico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMySQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/colecaocd","aluno","unicarioca");
                Statement stmt = con.createStatement();){
            
            int regAlterados = stmt.executeUpdate("insert into estilo(`indice`, `nome`) VALUES (NULL, 'Samba');");
            
            System.out.println("Foram alterados " + regAlterados + " registros.");
        }
    }
}
