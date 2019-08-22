/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import conn.MyConn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author KOSTA
 */
public class JDBCInsertSawonDemo {
    
   
    public static void main(String[] args) throws SQLException {
        Connection con = null;//커넥션을 반납하기 위해서 선언
        PreparedStatement pstmt;
        
//       
//        java.util.Date myDate = new java.util.Date();
//        java.sql.Date sysdate = new java.sql.Date(myDate.getTime());
    
        
        try {
            
            con = MyConn.getConn();
             //String sql = "insert into sawon(sabun,saname,deptno,sajob,sapay,sahire,sgender,samgr) values(?,?,?,?,?,?,?,?)"; 
            String sql = "insert into sawon values(?,?,?,?,?,sysdate,?,?)"; 
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1,15);            
            pstmt.setString(2, "주말2인가");
            pstmt.setInt(3, 10);
            pstmt.setString(4, "부자3");
            pstmt.setInt(5, 5000);
            pstmt.setString(6, "남자");
            pstmt.setString(7, null);
            
                
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
