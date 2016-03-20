/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcbasico;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lsfo
 */
public class SelectPrepStatement {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/colecaocd","aluno","unicarioca");
                PreparedStatement pstmt = con.prepareStatement("select * from estilo where nome <> ?;");){

            pstmt.setString(1, "Soul");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Estilo: " + rs.getString("nome"));
            }
        }
    }
}
