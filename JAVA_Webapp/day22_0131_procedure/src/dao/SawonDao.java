package dao;

import vo.SawonVO;
import java.util.ArrayList;
import java.util.List;
import conn.MyConn;
import vo.DeptVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SawonDao {
    private static SawonDao dao;
    
    private SawonDao(){}

    public synchronized static SawonDao getDao() {
        if (dao == null ) dao = new SawonDao();
        return dao;
    }
    
    public List<SawonVO> sawonSearch(int deptno) throws SQLException{
        List<SawonVO> arlist = new ArrayList<>();
        Connection con  = MyConn.getConn();
        //���ν��� ȣ��
        CallableStatement cs = con.prepareCall("begin p_sawon(?,?); end;");
        //�� / ��� �Ķ����
        cs.setInt(1,deptno);
        //procedure ���� out���� ��ȯ�� Ŀ��.
        cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        
        cs.execute();//����
        ResultSet rs = (ResultSet) cs.getObject(2); // 2Ŀ���� ��ȯ    //getObject ���� ���ڴ� �����̴�. 1�� input, 2�� output
        while(rs.next()){
            //DeptVO vo = new DeptVO(); 
            SawonVO svo = new SawonVO();
            svo.setDeptno(rs.getInt("deptno"));
            svo.setSabun(rs.getInt("sabun"));
            svo.setSahire(rs.getString("sahire"));
            svo.setSajob(rs.getString("sajob"));
            svo.setSamgr(rs.getInt("samgr"));
            svo.setSaname(rs.getString("saname"));
            svo.setSapay(rs.getInt("sapay"));
            svo.setSgender(rs.getString("sgender"));
            
            //vo.setSvo(svo);
            arlist.add(svo);
        }
        con.close();
        return arlist;
    }
    /*
        �Է� Dao
    */
    public void insertSawon(SawonVO v) {
        CallableStatement cs = null;
        Connection con = null;
        try {
        con = MyConn.getConn();
       
        cs = con.prepareCall("begin ps_in(?,?,?,?,?); end;");
        cs.setString(1,v.getSaname());
        cs.setInt(2,v.getDeptno());
        cs.setString(3,v.getSajob());
        cs.setInt(4,v.getSapay());
        cs.setString(5,v.getSgender());
        
        cs.execute();
        con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        
    }
}
