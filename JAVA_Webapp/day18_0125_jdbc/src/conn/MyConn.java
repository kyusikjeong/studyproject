/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class MyConn {
    //초기자원 : 메인메서드보다 선행! 
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   //getConnection 메서드 안의 replection 클래스는 forName  안의 문자열에 위치한 클래스가 존재하면 그곳에서 커넥션을 얻어온다..?
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException{
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "bigdate";
        String pwd = "big";
        return DriverManager.getConnection(url,user,pwd);
    }
}
