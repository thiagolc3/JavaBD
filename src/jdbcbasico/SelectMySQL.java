/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbasico;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMySQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/colecaocd","aluno","unicarioca");
                Statement stmt = (Statement) con.createStatement();) {

            ResultSet rs = stmt.executeQuery("select * from estilo;");

            while (rs.next()){
                System.out.println("Estilo: " + rs.getString("nome"));
            }
        }
    }
}
