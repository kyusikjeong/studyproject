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
public class JdbcSelectSawon {
    //static �̶� � �����ΰ�?
    private static JdbcSelectSawon jsda;
    //getJsdd()ȣ������ �� JdbcSelectDeptDemo
    //��ȯ�ϴ� static �޼���
    //�̱��� : �ϳ��� �����ؼ� �� ������ �������.
    public synchronized static JdbcSelectSawon getJsda(){ //�̷������� ����ȭ�� �ɾ���� ��. 
        //2.t1,t2,t3 ���� �����ϴ� �����忡�� 
        //�����ϵ��� �ϰ� �������� �̹� ������
        //static �� �����ϴ� 
        //jsda �� �ּҸ� �޾Ƽ� ����ϵ��� �Ѵ�.
        if(jsda  == null){     //���� ������ ��ü�� �����ϸ� null�� �ƴϰ� �ǹǷ� �ᱹ ��ü�� �ϳ��� �����Ǵ� ��.
                               //�׷��� ����ȭ�� �ɾ���� ��. �����尡 ���ÿ� ���ͼ� ��ü�� ������ �����Ǹ� �ȵǹǷ�.
                               //
            jsda = new JdbcSelectSawon();
        }
        return jsda; 
    }
    
    private JdbcSelectSawon() {//1.�ܺο��� �����ڸ� �����ϸ� �ȵǹǷ� private �� �Ǵ�.
    
     // Dept�� �μ� ���̺��� ��
     // �ϳ��� row�� ������ ��ü -> DeptVO
     // ��� ������ Collection => List 
    }
    //���� ��������) ������̺� �����ϱ�. 
    //��ĳ�ʷ� "��" => �ѹ���
    public List<SawonVO> getSawonList(String dname) throws SQLException{
        
            List<SawonVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            String sql  = "select saname,sapay,sajob from sawon where saname like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, "%"+dname+"%");
            ResultSet rs = pstm.executeQuery();
            //Select ��� �˻��� �����(�ν��Ͻ�)�� Cursor�� ��ȯ
            //�������� ��� (�����͸�ŭ �ݺ�)
            while(rs.next()){
                SawonVO vo = new SawonVO();    //��Ű���� �ν��Ͻ��� �̾Ƴ��� ���� �۾�
                vo.setSapay(rs.getInt("sapay"));///������ �̾ƿ��� �����Ϳ� �����ϴ� ������ ��ġ�ؾ��Ѵ�. 
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                
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
        //���ڿ� �Է��ϸ� �ش��ϴ� ���� �˻��Ǿ� ��µ�.
        Scanner sc = new Scanner(System.in);
        System.out.println("�̸� �˻�");
        List<SawonVO> dlist = JdbcSelectSawon.getJsda().getSawonList(sc.nextLine());
        for(SawonVO e : dlist){
            System.out.println("����̸� : "+e.getSaname());
            System.out.println("��å�̸� : "+e.getSajob());
            System.out.println("���� : "+e.getSapay());
        }
        
        
    }
     
    }
//    public DeptVO getDeptVO(){
//        return DeptVO;
//    }
        
    
    