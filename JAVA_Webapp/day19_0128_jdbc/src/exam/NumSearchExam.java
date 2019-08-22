
package exam;

import conn.MyConn;
import ex1.JdbcSelectSawon;
import ex1.SawonVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NumSearchExam {
    private static NumSearchExam nse;
    private String sql;
    private PreparedStatement pstm;
    public synchronized static NumSearchExam getNse(){
            
            if(nse  == null){     //���� ������ ��ü�� �����ϸ� null�� �ƴϰ� �ǹǷ� �ᱹ ��ü�� �ϳ��� �����Ǵ� ��.
                               //�׷��� ����ȭ�� �ɾ���� ��. �����尡 ���ÿ� ���ͼ� ��ü�� ������ �����Ǹ� �ȵǹǷ�.
                               //
            nse = new NumSearchExam();
        }
        return nse; 
    }
    
    public ArrayList<MemberPhoneVO> getSearchList(String pnum) throws SQLException{
            ArrayList<MemberPhoneVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
           
            if(pnum.equals("[����]")){
                sql = "select num,name,pnum from memphone";
                pstm = con.prepareStatement(sql);
            } else {
                sql = "select num,name,pnum from memphone where substr(pnum,1,instr(pnum,')')-1) = ?";
                pstm= con.prepareStatement(sql);
                pstm.setInt(1,Integer.parseInt(pnum));
                
            } 
             ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                MemberPhoneVO vo = new MemberPhoneVO();   
                vo.setNum(rs.getInt("num"));
                vo.setName(rs.getString("name"));
                vo.setPnum(rs.getString("pnum"));
                list.add(vo);
            }
            con.close();   
            return list;
        }
    }
    
