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
        Connection con = null;//Ŀ�ؼ��� �ݳ��ϱ� ���ؼ� ����
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
            pstmt.setString(2, "�ָ�2�ΰ�");
            pstmt.setInt(3, 10);
            pstmt.setString(4, "����3");
            pstmt.setInt(5, 5000);
            pstmt.setString(6, "����");
            pstmt.setString(7, null);
            
                
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
