
package ex1;

import dao.SawonDao;
import java.sql.SQLException;
import vo.SawonVO;
import java.util.List;
import java.util.Scanner;


public class SawonMain {
   
    public static void main(String[] args) throws SQLException {
        //����(����) , ���� ���� (ioc) 
        SawonDao dao = SawonDao.getDao();
        //   Scanner sc = new Scanner(System.in);
        SawonVO v = new SawonVO();
        v.setDeptno(10);
        v.setSaname("���ι�");
        v.setSgender("����");
        v.setSapay(3000);
        v.setSajob("�븮");
        
        dao.insertSawon(v);
        
        List <SawonVO> list = dao.sawonSearch(10);
        for(SawonVO e : list ){
            System.out.println("��ȣ : "+e.getSabun());
            System.out.println("�̸�  : "+e.getSaname());
            System.out.println("����  : "+e.getSajob());
            System.out.println("����  : "+e.getSapay());
            
            System.out.println("===============================");
        }
        
     
        
            
    }
}
