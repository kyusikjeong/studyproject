package ex1;


//DeptVO (Value Object) = Pojo;
public class DeptVO {
    //Dept table 의 컬럼명과 동일
    private int deptno;
    private String dname,loc;
    

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
}
