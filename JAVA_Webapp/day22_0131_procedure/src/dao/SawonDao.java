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
        //프로시저 호출
        CallableStatement cs = con.prepareCall("begin p_sawon(?,?); end;");
        //입 / 출력 파라미터
        cs.setInt(1,deptno);
        //procedure 에서 out모드로 반환한 커서.
        cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        
        cs.execute();//실행
        ResultSet rs = (ResultSet) cs.getObject(2); // 2커서를 반환    //getObject 안의 인자는 순서이다. 1은 input, 2는 output
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
        입력 Dao
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
