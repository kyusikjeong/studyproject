package ex1;

import conn.MyConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class NewClass {
//  1.Ŭ�����ε� - ����̹� ����
//  2.Ŀ�ؼ� ����
//3. �� ���ε�
//        4. ��������
//                5.Ŀ�ؼ� ��ȯ
//                        
    public static void main(String[] args) throws SQLException {
        Connection con=null;
        PreparedStatement pstm;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in,"UTF-8");
        try {
            
            
            con = MyConn.getConn();
            
            String sql = "insert into dept values (?,?,?)";
            
            pstm = con.prepareStatement(sql);
           
            
            System.out.print("ptno :");
            pstm.setInt(1, sc1.nextInt());
            System.out.print("loc :");
            pstm.setString(2, sc2.nextLine());
            System.out.print("dname :");
            pstm.setString(3, sc2.nextLine());
            
            
            
            
            int res  = pstm.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) con.close();
        }
        
        
    }
  
   
}
