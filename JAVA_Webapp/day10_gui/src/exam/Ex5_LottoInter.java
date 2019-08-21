package exam;

public interface Ex5_LottoInter { //인터페이스
    
    //추상메서드. 해당 인터페이스를 implements 를 통해 구현하는 클래스는 반드시 해당 메소드들을 전부
    //오버라이딩 해야한다. 인터페이스를 사용하는 이유는 프로그램간의 결합도를 줄이고, 클래스의 실제 내용은 보여주지 않으면서
    //사용방법만(프로그래밍 인터페이스)보여주고자 사용(캡슐화)
    //또는 인터페이스의 참조변수로 인터페이스를 구현한 다양한 클래스들을 참조할때 사용(다형성)
    //또는 관계없는 클래스들간의 공통점을 잡을때 사용하여 개발이 용이하게 하기 위함 등등 여러가지 이유가 있다.
    public String getLottoNum();    
    public void setLottoGameNum(int num);
}
