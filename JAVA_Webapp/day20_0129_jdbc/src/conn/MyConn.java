package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //properties 파일로 변경 가능. 지금은 고정되어있는 값이므로 값이 변경될때마다 컴파일을 새로 해야 한다는 단점이 있음.
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "bigdate";
        String pwd = "big";
        return DriverManager.getConnection(url,user,pwd);
    }
}
