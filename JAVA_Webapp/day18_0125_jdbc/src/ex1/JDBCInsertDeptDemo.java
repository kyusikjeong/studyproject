package ex1;

import conn.MyConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCInsertDeptDemo {
    //입력,수정,삭제 처리에 적용
   
    public static void main(String[] args) throws SQLException {
        Connection con = null;//커넥션을 반납하기 위해서 선언
        PreparedStatement pstmt;
        try {
            //1.JDBC 드라이버 연결 - 클래스 로딩
            //Class.forName("oracle.jdbc.driver.OracleDriver");   //getConnection 메서드 안의 replection 클래스는 forName  안의 문자열에 위치한 클래스가 존재하면 그곳에서 커넥션을 얻어온다..?
            //2.connection 획득 - 기능에 따라서 객체화 시킴(new instance()캡슐화)                                //
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            String user = "bigdate";
//            String pwd = "big";
//            con = DriverManager.getConnection(url,user,pwd);
            con = MyConn.getConn();
            //3.PreparedStatement 값을 바인딩(?) 한다.
            String sql = "insert into dept values(?,?,?)";  //여기의 ? 부분이 바인딩이라고 보면 됨
            pstmt = con.prepareStatement(sql);              //statement 를 상속받은 PreparedStatement
                                                            //statement 는 보안의 이유나 효율성 문제로 직접 사용해서는 안된다.
                                                            //insert into table명 values (1,2,3,4) 이런식의 작업인데 숫자가 상수일 경우 무리가 없으나
                                                            //values 안의 값이 변화가 될때 동일한 작업을 하는 문제가 발생하여(일일히 값을 검사함) 퍼포먼스가 떨어지게된다.
                                                            //또 한 거짓 데이터가 들어갈 확률이 있다. 
                                                            //prepareStatement 는 버퍼에 한번 저장해서 패치나 그런 검사하는 작업을 안거쳐서 효율이 좋고
                                                            //보안에 좋음. 내부적으로 바인딩 (문자열 처리?)를 하기 때문에. 
                                                            //프로시져는 PreparedStatement 보다 속도가 빠르다.
                                                            
            pstmt.setInt(1,10);             //?하나에 한줄씩 들어간다. 칼럼명을 설정하지 않았으므로.
            pstmt.setString(2, "총무3부");
            pstmt.setString(3, "강원");
                
            //4.PreparedStatement 객체를 사용해서 Query전송
            int res = pstmt.executeUpdate();
            System.out.println("res = "+res);
            //5.모든 connection 을 반납한다.
            System.out.println("Connection : "+con);
        } catch (SQLException ex) {
           //개발 당시에는 반드시 ex.printStackTrace()로 오류를 확인해야 한다.
           ex.printStackTrace();  //오라클 에러......
        } finally {
            if (con!= null) con.close();
        }
    }
}
