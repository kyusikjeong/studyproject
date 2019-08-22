/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefrontproject;

import com.sun.javafx.geom.Vec2d;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author neo
 */
public class DataService implements Serializable{
    ArrayList<MemberQuestionPojo> mQuestionList;
    ArrayList arr; //제네릭을 건 곳을 제외한 곳 리턴받을 리스트 선언
    //테스트용
    FileManager fm;
    ArrayList<QuizWordPojo> qwList;
    public DataService() {
        fm = new FileManager();
        this.mQuestionList = fm.getmQuestionList(); //파일 데이터를 최대한 적게 출력하기 위해 생성자를 실행시 파일 리스트를 한번 불러와서 재사용 하도록 함
        qwList = fm.readQuizDataList();  
    }
   
    public int qMonthAverage(String id){
        ArrayList<MemberQuestionPojo> qMAverage = mSearchQuestion("test1");
        float average=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM");  //날짜를 저장하기 위해. 나중에 사용하려고 저장함
        Date date = new Date();

        int idx = 0;
 //       int arr[] = new int[qMAverage.size()];
        for(MemberQuestionPojo mq : qMAverage){
           if(sdf.format(date).equals(mq.getDate().substring(0,7))){//날짜를 월까지만 해서 비교
               //이번달의 데이터만 뽑아오기 위해 현재 날짜패턴과 동일한 값을 조건문에 사용
               average = (float)mq.getWinNum()/mq.getwTotalNum()*100;
//               arr[idx] = (int)average;
//
//               idx++;
            }
        }
          return (int)average;
        //return arr[idx-1]; //
    }
    
    public Vector qDayAverage(String id){
        ArrayList<MemberQuestionPojo> qDayAverage = mSearchQuestion(id);
        Vector v = new Vector();
        for(MemberQuestionPojo mq : qDayAverage){ //해당하는 아이디가 가지고 있는 문제 풀이 데이터를 다 불러와서 돌림
//           System.out.println("test :" + mq.getId()+ " , "+mq.getDate() + " ,"+mq.getWordNum()+ " ,"+
//                             mq.getDwinNum()+ " ,"+mq.getwTotalNum()+" , "+mq.getWinNum());
           float aver = (float)mq.getDwinNum()/mq.getWordNum() * 100;   //평균값을 구함 
           v.add((int)aver);  //벡터에 더하고..
        }
       return v;
    }
   
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList mSearchQuestion(String id){    //아이디를 검색해서 해당하는 아이디가 여태까지 풀었던 데이터를 검색해서 뽑은다음 어레이리스트에 저장하여 리턴하는 메서드
          arr = new ArrayList();            
         for(MemberQuestionPojo mq : mQuestionList){
             if(id.equals(mq.getId())){
                
//                  System.out.println("test :" + mq.getId()+ " , "+mq.getDate() + " ,"+mq.getWordNum()+ " ,"+
//                                  mq.getDwinNum()+ " ,"+mq.getwTotalNum()+" , "+mq.getWinNum());
                  arr.add(new MemberQuestionPojo(mq.getId(), mq.getDate(), mq.getWordNum(), mq.getDwinNum(), mq.getwTotalNum(), mq.getWinNum()));
             }
         }
         return arr;
    }
    public ArrayList randomQuizList(){   //문제파일에서 설정된 갯수의 단어를 랜덤한 순서로 뽑아내서 리스트를 반환시켜주는 메서드
     
        ArrayList<QuizWordPojo> tempList = new ArrayList();
        ArrayList<QuizWordPojo> qlist = qwList;     //퀴즈파일의 모든데이터를 가지고 있는 리스트 가져옴
        TreeSet<Integer> ts = new TreeSet();
        
        while(ts.size() != 5){
           int test1 = (int)(Math.random() * qlist.size());
           ts.add(test1);
        }
        for(int i : ts){
            tempList.add(new QuizWordPojo(qlist.get(i).getWord(),qlist.get(i).getMean()));     
        }
        return tempList;
    }
//  public static void main(String[] args) {
//        DataService ds = new DataService();
//       ArrayList arr = ds.randomQuizList();
//      
//    }
}
