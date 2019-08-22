
package ex1;

import dao.SawonDao;
import java.sql.SQLException;
import vo.SawonVO;
import java.util.List;
import java.util.Scanner;


public class SawonMain {
   
    public static void main(String[] args) throws SQLException {
        //순차(절차) , 제어 역행 (ioc) 
        SawonDao dao = SawonDao.getDao();
        //   Scanner sc = new Scanner(System.in);
        SawonVO v = new SawonVO();
        v.setDeptno(10);
        v.setSaname("새로미");
        v.setSgender("여자");
        v.setSapay(3000);
        v.setSajob("대리");
        
        dao.insertSawon(v);
        
        List <SawonVO> list = dao.sawonSearch(10);
        for(SawonVO e : list ){
            System.out.println("번호 : "+e.getSabun());
            System.out.println("이름  : "+e.getSaname());
            System.out.println("직업  : "+e.getSajob());
            System.out.println("연봉  : "+e.getSapay());
            
            System.out.println("===============================");
        }
        
     
        
            
    }
}
