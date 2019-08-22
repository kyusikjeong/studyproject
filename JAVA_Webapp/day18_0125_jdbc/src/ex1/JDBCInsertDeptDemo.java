package ex1;

import conn.MyConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCInsertDeptDemo {
    //�Է�,����,���� ó���� ����
   
    public static void main(String[] args) throws SQLException {
        Connection con = null;//Ŀ�ؼ��� �ݳ��ϱ� ���ؼ� ����
        PreparedStatement pstmt;
        try {
            //1.JDBC ����̹� ���� - Ŭ���� �ε�
            //Class.forName("oracle.jdbc.driver.OracleDriver");   //getConnection �޼��� ���� replection Ŭ������ forName  ���� ���ڿ��� ��ġ�� Ŭ������ �����ϸ� �װ����� Ŀ�ؼ��� ���´�..?
            //2.connection ȹ�� - ��ɿ� ���� ��üȭ ��Ŵ(new instance()ĸ��ȭ)                                //
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            String user = "bigdate";
//            String pwd = "big";
//            con = DriverManager.getConnection(url,user,pwd);
            con = MyConn.getConn();
            //3.PreparedStatement ���� ���ε�(?) �Ѵ�.
            String sql = "insert into dept values(?,?,?)";  //������ ? �κ��� ���ε��̶�� ���� ��
            pstmt = con.prepareStatement(sql);              //statement �� ��ӹ��� PreparedStatement
                                                            //statement �� ������ ������ ȿ���� ������ ���� ����ؼ��� �ȵȴ�.
                                                            //insert into table�� values (1,2,3,4) �̷����� �۾��ε� ���ڰ� ����� ��� ������ ������
                                                            //values ���� ���� ��ȭ�� �ɶ� ������ �۾��� �ϴ� ������ �߻��Ͽ�(������ ���� �˻���) �����ս��� �������Եȴ�.
                                                            //�� �� ���� �����Ͱ� �� Ȯ���� �ִ�. 
                                                            //prepareStatement �� ���ۿ� �ѹ� �����ؼ� ��ġ�� �׷� �˻��ϴ� �۾��� �Ȱ��ļ� ȿ���� ����
                                                            //���ȿ� ����. ���������� ���ε� (���ڿ� ó��?)�� �ϱ� ������. 
                                                            //���ν����� PreparedStatement ���� �ӵ��� ������.
                                                            
            pstmt.setInt(1,10);             //?�ϳ��� ���پ� ����. Į������ �������� �ʾ����Ƿ�.
            pstmt.setString(2, "�ѹ�3��");
            pstmt.setString(3, "����");
                
            //4.PreparedStatement ��ü�� ����ؼ� Query����
            int res = pstmt.executeUpdate();
            System.out.println("res = "+res);
            //5.��� connection �� �ݳ��Ѵ�.
            System.out.println("Connection : "+con);
        } catch (SQLException ex) {
           //���� ��ÿ��� �ݵ�� ex.printStackTrace()�� ������ Ȯ���ؾ� �Ѵ�.
           ex.printStackTrace();  //����Ŭ ����......
        } finally {
            if (con!= null) con.close();
        }
    }
}
