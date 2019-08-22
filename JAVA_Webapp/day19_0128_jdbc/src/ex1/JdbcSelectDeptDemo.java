package ex1;

//네트워크에서 접근하는 스레드일 경우
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

//connection 관리가 원활하게 안될 경우가 있다.
//싱글톤, 동기화로 관리를 해야 한다.
public class JdbcSelectDeptDemo {
    //static 이란 어떤 공간인가?
    private static JdbcSelectDeptDemo jsda;
    //getJsdd()호출했을 때 JdbcSelectDeptDemo
    //반환하는 static 메서드
    //싱글톤 : 하나만 생성해서 잘 나눠서 사용하자.
    public synchronized static JdbcSelectDeptDemo getJsda(){ //이런식으로 동기화를 걸어줘야 됨. 
        //2.t1,t2,t3 먼저 접근하는 스레드에게 
        //생성하도록 하고 나머지는 이미 생성된
        //static 에 존재하는 
        //jsda 의 주소를 받아서 사용하도록 한다.
        if(jsda  == null){     //누가 들어오든 객체가 생성하면 null이 아니게 되므로 결국 객체는 하나만 생성되는 셈.
                               //그러나 동기화를 걸어줘야 됨. 스레드가 동시에 들어와서 객체가 여러개 생성되면 안되므로.
                               //
            jsda = new JdbcSelectDeptDemo();
        }
        return jsda; 
    }
    
    private JdbcSelectDeptDemo() {//1.외부에서 생성자를 실행하면 안되므로 private 를 건다.
    
     // Dept는 부서 테이블의 값
     // 하나의 row를 저장할 객체 -> DeptVO
     // 모두 저장할 Collection => List 
    }
    public List<DeptVO> getDeptList() throws SQLException{
        
            List<DeptVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            String sql  = "select deptno,dname,loc from dept";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            //Select 경우 검색된 결과값(인스턴스)을 Cursor를 반환
            //다중행일 경우 (데이터만큼 반복)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //스키마의 인스턴스를 뽑아내기 위한 작업
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                vo.setLoc(rs.getString("loc"));
                list.add(vo);
            }
                    
            con.close();   
            return list;
        }
    //응용 연습문제) 사원테이블에 적용하기. 
    //스캐너로 "총" => 총무부
    public List<DeptVO> getDeptList(String dname) throws SQLException{
        
            List<DeptVO> list = new ArrayList<>();
            Connection con = MyConn.getConn();
            String sql  = "select deptno,dname,loc from dept where dname like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, "%"+dname+"%");
            ResultSet rs = pstm.executeQuery();
            //Select 경우 검색된 결과값(인스턴스)을 Cursor를 반환
            //다중행일 경우 (데이터만큼 반복)
            while(rs.next()){
                DeptVO vo = new DeptVO();    //스키마의 인스턴스를 뽑아내기 위한 작업
                vo.setDeptno(rs.getInt("deptno"));
                vo.setDname(rs.getString("dname"));
                vo.setLoc(rs.getString("loc"));
                list.add(vo);
            }
                    
            con.close();   
            return list;
        }
    
    //GUI 에서 구현해볼것
    //cursor를 처리해서 select 된 결과를 출력하는 방법
    //싱글톤 처리도 함께 학습.
    //오후 스터디 결과물)
    //sawon 테이블의 모든 자료를 입력 / 출력 될 수 있는 프로그램을 개발. 
    public static void main(String[] args) throws SQLException {
        
        
        //스캐너를 활용하여 
        //문자열 입력하면 해당하는 값이 검색되어 출력됨
        Scanner sc = new Scanner(System.in);
        List<DeptVO> dlist = JdbcSelectDeptDemo.getJsda().getDeptList(sc.nextLine());
        for(DeptVO e : dlist){
            System.out.println("부서번호 : "+e.getDeptno());
            System.out.println("부서이름 : "+e.getDname());
            System.out.println("부서지역 : "+e.getLoc());
        }
        
        
    }
     
    }
//    public DeptVO getDeptVO(){
//        return DeptVO;
//    }
        
    
    