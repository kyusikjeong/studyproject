package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConn {
    //�ʱ��ڿ� : ���θ޼��庸�� ����! 
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   //getConnection �޼��� ���� replection Ŭ������ forName  ���� ���ڿ��� ��ġ�� Ŭ������ �����ϸ� �װ����� Ŀ�ؼ��� ���´�..?
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException{
        //properties ���Ϸ� ���� ����. ������ �����Ǿ��ִ� ���̹Ƿ� ���� ����ɶ����� �������� ���� �ؾ� �Ѵٴ� ������ ����.
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "bigdate";
        String pwd = "big";
        return DriverManager.getConnection(url,user,pwd);
    }
}
