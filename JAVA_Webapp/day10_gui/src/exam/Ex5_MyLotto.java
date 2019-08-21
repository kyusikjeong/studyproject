package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;  //자동으로 만들어지긴 하지만, 해당 클래스들을 사용하려면 import 해주어야 한다


public class Ex5_MyLotto implements Ex5_LottoInter{ //implements 키워드를 사용해 Ex5_LottoInter 인터페이스를 구현. 
    private ArrayList<TreeSet<Integer>> tlist; //인스턴스변수. 해당 인스턴스가 생성되었을 시(new로 객체 생성시)
                                               //만들어진다.
    
    //ArrayList 안의 TreeSet객체를 넣는, 이중배열 구조와 같이 데이터를 넣기 위해 해당형식으로 인스턴스변수 선언.
    //ArrayList 타입 참조변수 tlist. 값을 넣지 않고 선언만 했으므로 디폴트 초기화가 되어있는 상태(null값)
    
    //제네릭을 사용한 이유는 해당타입이 아닌 다른 타입의 데이터가 들어오는것을 미연에 방지하기 위함이다.(물론 다른 용도도 있음)
    //<> 안에 들어가는 타입의 데이터가 아니면 컴파일이 안되는 형식.
    public Ex5_MyLotto() { //프로그램 순서: 2
                            
                            
                            //기본 생성자. 연산자 new로 객체 생성 뒤 해당 생성자를 호출하면 실행된다.
                            //new Ex5_MyLotto()  ->연산자 new로 Ex5_MyLotto클래스의 객체 생성
                            //() 안에 아무런 매개변수가 없으므로 기본생성자 호출한다는것을 알 수 있다.
                            
                            //생성자: 인스턴스가 생성될 때, 즉 연산자 new로 객체 생성될때 (다른방법으로 생성하는 방법도 있기는 하다.)
                            //호출되는 인스턴스 초기화 메서드. 
        
        this.tlist = new ArrayList<>(); //생성자 실행시 해당 코드 실행. ArrayList객체를 생성한 뒤 위에서 선언한 tlist에 주소값을 넣는다.
        //this.변수 형식으로 쓰이면 자기 자신 클래스(객체)에 선언된 변수를 말한다.
        
    }
    
    public static void main(String[] args) { //메인메소드. 프로그램 실행시 가장 먼저 실행되며, 메인메소드가 종료되면 프로그램이 종료된다.
        Ex5_MyLotto ref = new Ex5_MyLotto();  //객체생성. 객체를 생성해야 해당 객체의 멤버에 접근할 수 있게된다. 
        //프로그램 순서: 1                     //힙영역의 메모리에 객체의 모든 멤버들이 등록되며 참조변수 ref를 통해 해당 객체안의 
                                              //데이터에 접근할 수 있게 된다. ex) ref.test(); 하면 ref 객체 안의 test() 메소드를 실행
                                              
        //프로그램을 실행하면 랜덤한 숫자 1~45까지
        //6개를 중복없이 순서대로 출력
        
        //프로그램 순서: 3
        Scanner sc = new Scanner(System.in); //사용자에게 콘솔창에서 값을 입력받을 때 사용한 스캐너 클래스.매개변수로 System.in을 던져줘야 한다.
                                            
        System.out.println("금액 입력 :");
        int money = sc.nextInt();       //nextInt() - 스캐너 내부메소드로써 사용자로부터 int형식 값을 받음. 다른 형식을 입력받으면 exception발생
        ref.setLottoGameNum(money);     //참조변수 ref가 가리키고 있는 곳의 주소에 있는 메소드 실행.
                                        //여기선 Ex5_MyLotto 클래스. 위에서 객체 생성했으므로 내부의 메소드가 실행되겠지.
                                        //컨트롤 누르고 해당 메소드를 눌러 실행되는곳으로 바로 이동
    }
    
                //어노테이션은 컴파일러에게 문법 에러를 체크하도록 정보를 제공한다던가 개발자들이 개발할때 오버라이딩 해야 할 메소드들이
                //제대로 되어있는지 확인하기 쉽게 쓰이는 것이다... 
    @Override   //Override 어노테이션.용도가 있는 주석이라고 보면 될듯. 
    public String getLottoNum(){  //프로그램 순서: 8
      
        StringBuffer sb = new StringBuffer();  //최종적으로 출력할 문장을 만들기 위해 StringBuffer클래스를 사용.
                                              //String 클래스와의 차이는 이전 예제 참조
       int i =0;      //출력하는 값에 번호를 붙이기 위해 사용하는 변수                    
       
       for(TreeSet<Integer> e : tlist){  //향상된 for문. 객체,배열안의 데이터를 뽑아서 옆의 임시 변수에 값을 전달한다.
                                        //양쪽의 타입은 일치해야 하나,여기선 위에 제네릭에 TreeSet 타입 데이터를 받는다고 선언했으므로 유효하다. 우측 인자에 들어있는 데이터의 수만큼 반복한다.
                                        //tlist는 위에서 생성한 번호들의 주소값을 가지고 있다. 구조->
                                        //2차원 배열이라고 생각하자.tlist가 가지고 있는 주소값의 값을 TreeSet e 변수에 넘겨준다.
                                        
           sb.append("No[").append(i).append("]");//로또번호 앞에 붙일 넘버링 문장생성하기 위한 작업. 
           //버퍼 sb에 해당 텍스트와 위에 넘버링을 위한 int i 변수를 더함.
           
           for(Integer f : e){ //2중반복문이 실행되고 있다는걸 확인할 수 있다.
                               //위에서 tlist에서 받은 주소값을 Integer 타입 임시변수 f에 저장하면
                               //메모리에 들어있는 번호가 처음부터 끝까지 반복되면서 출력된다.
               sb.append(f).append(" ");//번호 붙이고 한칸띄우기 위해 공백도 붙이는 과정
               
           }sb.append("\n");  //번호를 다 뽑아주고 줄바꿈을 하기 위해 더해준다.
           i++;               //출력하는 값에 번호를 붙이는 변수니까 여기서 1씩 증가하면 출력이 끝나고 1씩 늘어나겠지
       } return sb.toString();  //모든 텍스트가 완성되면 저장한 sb값을 String 데이터형으로 변환시켜주는 toString() 메소드를 사용하여 리턴시킴
    }
    
    public TreeSet<Integer> execute(){ //프로그램 순서: 6
        TreeSet<Integer> ts = new TreeSet();   //중복을 제거하고 자동 정렬해주는 TreeSet 타입 객체 생성.
        
        while(ts.size() != 6){// 6개의 난수를 ts 에 저장. size() 메소드는 TreeSet에 크기를 알려주는 메소드. 
                              //treeSet의 크기가 6이 아니면 true이므로 계속 돈다.
                              //한마디로 6개의 값이 저장되면 false가 되면서 종료된다는 것
                              
            int rnum = (int)(Math.random()*45)+1;  //랜덤값 생성함수 매스랜덤. +1을 해주는 이유는 랜덤 값이 0부터 시작되기 때문에 데이터를 1부터 생성하기 위함이다.
            
            ts.add(rnum);   //생성한 랜덤값을 TreeSet에 저장. 여기서 반복되면서 여섯개가 저장되겠지.
                            //이후엔 위에 조건식이 false가 되며 아래 return 문으로 이동
        }
        return ts;  //TreeSet 의 주소값을 가진 참조변수 ts 리턴. (TreeSet 객체에 여섯개의 데이터가 저장되어 있는 상태)
    }
    
    @Override
    public void setLottoGameNum(int num){//프로그램 순서: 4
      //금액에 따른 게임 횟수를 연산하는 메소드.
      //매개변수로 받은 num은 사용자가 입력한 금액이며, 매개변수의 이름은 아무렇게나 지어도 된다. 그래도 바로 알아볼 수 있게 짓는것이 좋음
      
      num = num/1000;      //받은 금액을 게임비용인 1000으로 나눠서 게임횟수를 정함.
                           //10000원 넣었으면 10이 나오겠지
      
         for(int i = 0; i<num; i++){ //반복문. for문 빠져나가면 사라지는 지역변수 int i,
                                  //조건식은... 위에서 num이 10이였다면 반복문은 10번 돈다.//해당 조건이 true라면 계속 반복되는것. 
                                  //i++는 후위연산자(변수의 값을 읽어서 사용후에 값을 증가시킴)
                                  //여기선 i=0인 상태로 for문 한바퀴 돌고 1증가된 값으로 또 한바퀴 돌고 이런식이다.
                                  
          //TreeSet을 주소를 반환받아서 ArrayList에 저장
          //프로그램 순서: 5
         tlist.add(execute()); //ArrayList에 execute메소드 실행결과를 저장. 
          //반복문이 돌아가는 동안 해당 구문은 계속 실행됨
          //컨트롤 클릭으로 execute 클릭해서 이동
      }
        System.out.println(getLottoNum()); //프로그램 순서: 7
        //print메소드 안에 메소드가 들어있다는것은 콘솔창에 출력할 수 있는 리턴값이 있다는 뜻이다.
        //getLottoNum() 메소드를 실행하고 리턴받는 값을 출력. 컨트롤 클릭해서 ㄱ
        
        
        
        
        //값을 리턴받고 출력하고 나면 더 이상 수행되는 코드가 없으므로 사실상 이곳에서 프로그램이 종료된다.
                                           
    }
  
    
    
}
