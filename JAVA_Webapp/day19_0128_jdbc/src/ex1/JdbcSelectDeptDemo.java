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
public class JdbcSelectDeptDemo {
    //static �̶� � �����ΰ�?
    private static JdbcSelectDeptDemo jsda;
    //getJsdd()ȣ������ �� JdbcSelectDeptDemo
    //��ȯ�ϴ� static �޼���
    //�̱��� : �ϳ��� �����ؼ� �� ������ �������.
    public synchronized static JdbcSelectDeptDemo getJsda(){ //�̷������� ����ȭ�� �ɾ���� ��. 
        //2.t1,t2,t3 ���� �����ϴ� �����忡�� 
        //�����ϵ��� �ϰ� �������� �̹� ������
        //static �� �����ϴ� 
        //jsda �� �ּҸ� �޾Ƽ� ����ϵ��� �Ѵ�.
        if(jsda  == null){     //���� ������ ��ü�� �����ϸ� null�� �ƴϰ� �ǹǷ� �ᱹ ��ü�� �ϳ��� �����Ǵ� ��.
                               //�׷��� ����ȭ�� �ɾ���� ��. �����尡 ���ÿ� ���ͼ� ��ü�� ������ �����Ǹ� �ȵǹǷ�.
                               //
            jsda = new JdbcSelectDeptDemo();
        }
        return jsda; 
    }
    
    private JdbcSelectDeptDemo() {//1.�ܺο��� �����ڸ� �����ϸ� �ȵǹǷ� private �� �Ǵ�.
    
     // Dept�� �μ� ���̺��� ��
     // �ϳ��� row�� ������ ��ü -> DeptVO
     // ��� ������ Collection => List 
    }
    public List<DeptVO> getDeptList() throws SQLException{
        
            List<DeptVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            String sql  = "select deptno,dname,loc from dept";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            //Select ��� �˻��� �����(�ν��Ͻ�)�� Cursor�� ��ȯ
            //�������� ��� (�����͸�ŭ �ݺ�)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //��Ű���� �ν��Ͻ��� �̾Ƴ��� ���� �۾�
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                vo.setLoc(rs.getString("loc"));
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
            String sql  = "select deptno,dname,loc from dept where dname like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, "%"+dname+"%");
            ResultSet rs = pstm.executeQuery();
            //Select ��� �˻��� �����(�ν��Ͻ�)�� Cursor�� ��ȯ
            //�������� ��� (�����͸�ŭ �ݺ�)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //��Ű���� �ν��Ͻ��� �̾Ƴ��� ���� �۾�
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                vo.setLoc(rs.getString("loc"));
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
        Scanner sc = new Scanner(System.in);
        List<DeptVO> dlist = JdbcSelectDeptDemo.getJsda().getDeptList(sc.nextLine());
        for(DeptVO e : dlist){
            System.out.println("�μ���ȣ : "+e.getDeptno());
            System.out.println("�μ��̸� : "+e.getDname());
            System.out.println("�μ����� : "+e.getLoc());
        }
        
        
    }
     
    }
//    public DeptVO getDeptVO(){
//        return DeptVO;
//    }
        
    
    