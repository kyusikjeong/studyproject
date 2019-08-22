package ex1;

//��Ʈ��ũ���� �����ϴ� �������� ���
import conn.MyConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//connection ������ ��Ȱ�ϰ� �ȵ� ��찡 �ִ�.
//�̱���, ����ȭ�� ������ �ؾ� �Ѵ�.
public class JdbcJoinDeptDemo {
    //static �̶� � �����ΰ�?
    private static JdbcJoinDeptDemo jsda;
    //getJsdd()ȣ������ �� JdbcJoinDeptDemo
    //��ȯ�ϴ� static �޼���
    //�̱��� : �ϳ��� �����ؼ� �� ������ �������.
    public synchronized static JdbcJoinDeptDemo getJsda(){ //�̷������� ����ȭ�� �ɾ���� ��. 
        //2.t1,t2,t3 ���� �����ϴ� �����忡�� 
        //�����ϵ��� �ϰ� �������� �̹� ������
        //static �� �����ϴ� 
        //jsda �� �ּҸ� �޾Ƽ� ����ϵ��� �Ѵ�.
        if(jsda  == null){     //���� ������ ��ü�� �����ϸ� null�� �ƴϰ� �ǹǷ� �ᱹ ��ü�� �ϳ��� �����Ǵ� ��.
                               //�׷��� ����ȭ�� �ɾ���� ��. �����尡 ���ÿ� ���ͼ� ��ü�� ������ �����Ǹ� �ȵǹǷ�.
                               //
            jsda = new JdbcJoinDeptDemo();
        }
        return jsda; 
    }
    
    private JdbcJoinDeptDemo() {//1.�ܺο��� �����ڸ� �����ϸ� �ȵǹǷ� private �� �Ǵ�.
    
     // Dept�� �μ� ���̺��� ��
     // �ϳ��� row�� ������ ��ü -> DeptVO
     // ��� ������ Collection => List 
    }
    public List<DeptVO> getDeptList() throws SQLException{
        
            List<DeptVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append("select s.saname saname,s.deptno deptno,d.dname dname,s.sapay sapay from sawon s, dept d ");
            sql.append("where s.deptno = d.deptno order by 3 desc"); //saname �� ��� �������ΰ�.
            
            PreparedStatement pstm = con.prepareStatement(sql.toString());
            ResultSet rs = pstm.executeQuery();
            System.out.println("---"+rs);
            //Select ��� �˻��� �����(�ν��Ͻ�)�� Cursor�� ��ȯ
            //�������� ��� (�����͸�ŭ �ݺ�)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //��Ű���� �ν��Ͻ��� �̾Ƴ��� ���� �۾�
                SawonVO svo  = new SawonVO();
                svo.setSaname(rs.getString("saname"));
                svo.setSapay(rs.getInt("sapay"));
                vo.setSvo(svo);
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                list.add(vo);
            }
                    
            con.close();   
            return list;
        }
    //���� ��������) ������̺� �����ϱ�. 
    //��ĳ�ʷ� "��" => �ѹ���
    public List<DeptVO> getDeptList(String dname) throws SQLException{
        
            List<DeptVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append("select s.saname saname,s.deptno deptno,d.dname dname,s.sapay sapay from sawon s, dept d ");
            sql.append("where s.deptno = d.deptno and d.dname like ? order by 3 desc"); //saname �� ��� �������ΰ�.
            System.out.println("---"+dname);
            PreparedStatement pstm = con.prepareStatement(sql.toString());
            pstm.setString(1, "%"+dname+"%");
            ResultSet rs = pstm.executeQuery();
            System.out.println("---"+rs);
            //Select ��� �˻��� �����(�ν��Ͻ�)�� Cursor�� ��ȯ
            //�������� ��� (�����͸�ŭ �ݺ�)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //��Ű���� �ν��Ͻ��� �̾Ƴ��� ���� �۾�
                SawonVO svo  = new SawonVO();
                svo.setSaname(rs.getString("saname"));
                svo.setSapay(rs.getInt("sapay"));
                vo.setSvo(svo);
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                list.add(vo);
            }
                    
            con.close();   
            return list;
        }
    
    //GUI ���� �����غ���
    //cursor�� ó���ؼ� select �� ����� ����ϴ� ���
    //�̱��� ó���� �Բ� �н�.
    //���� ���͵� �����)
    //sawon ���̺��� ��� �ڷḦ �Է� / ��� �� �� �ִ� ���α׷��� ����. 
    public static void main(String[] args) throws SQLException {
        
        
        //��ĳ�ʸ� Ȱ���Ͽ� 
        //���ڿ� �Է��ϸ� �ش��ϴ� ���� �˻��Ǿ� ��µ�
      //  Scanner sc = new Scanner(System.in);
        List<DeptVO> dlist = JdbcJoinDeptDemo.getJsda().getDeptList();
        for(DeptVO e : dlist){
            System.out.println("-----------------------------------");
            System.out.println("�μ���ȣ : "+e.getDeptno());
            System.out.println("�μ��̸� : "+e.getDname());
            System.out.println("����̸� : "+e.getSvo().getSaname());
            System.out.println("�޿�     : "+e.getSvo().getSapay());
            
        }
        System.out.println("�� : "+dlist.size());
        
    }
     
    }
//    public DeptVO getDeptVO(){
//        return DeptVO;
//    }
        
    
    