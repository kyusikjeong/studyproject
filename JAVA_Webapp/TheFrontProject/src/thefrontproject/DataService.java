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
    ArrayList arr; //���׸��� �� ���� ������ �� ���Ϲ��� ����Ʈ ����
    //�׽�Ʈ��
    FileManager fm;
    ArrayList<QuizWordPojo> qwList;
    public DataService() {
        fm = new FileManager();
        this.mQuestionList = fm.getmQuestionList(); //���� �����͸� �ִ��� ���� ����ϱ� ���� �����ڸ� ����� ���� ����Ʈ�� �ѹ� �ҷ��ͼ� ���� �ϵ��� ��
        qwList = fm.readQuizDataList();  
    }
   
    public int qMonthAverage(String id){
        ArrayList<MemberQuestionPojo> qMAverage = mSearchQuestion("test1");
        float average=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM");  //��¥�� �����ϱ� ����. ���߿� ����Ϸ��� ������
        Date date = new Date();

        int idx = 0;
 //       int arr[] = new int[qMAverage.size()];
        for(MemberQuestionPojo mq : qMAverage){
           if(sdf.format(date).equals(mq.getDate().substring(0,7))){//��¥�� �������� �ؼ� ��
               //�̹����� �����͸� �̾ƿ��� ���� ���� ��¥���ϰ� ������ ���� ���ǹ��� ���
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
        for(MemberQuestionPojo mq : qDayAverage){ //�ش��ϴ� ���̵� ������ �ִ� ���� Ǯ�� �����͸� �� �ҷ��ͼ� ����
//           System.out.println("test :" + mq.getId()+ " , "+mq.getDate() + " ,"+mq.getWordNum()+ " ,"+
//                             mq.getDwinNum()+ " ,"+mq.getwTotalNum()+" , "+mq.getWinNum());
           float aver = (float)mq.getDwinNum()/mq.getWordNum() * 100;   //��հ��� ���� 
           v.add((int)aver);  //���Ϳ� ���ϰ�..
        }
       return v;
    }
   
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList mSearchQuestion(String id){    //���̵� �˻��ؼ� �ش��ϴ� ���̵� ���±��� Ǯ���� �����͸� �˻��ؼ� �������� ��̸���Ʈ�� �����Ͽ� �����ϴ� �޼���
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
    public ArrayList randomQuizList(){   //�������Ͽ��� ������ ������ �ܾ ������ ������ �̾Ƴ��� ����Ʈ�� ��ȯ�����ִ� �޼���
     
        ArrayList<QuizWordPojo> tempList = new ArrayList();
        ArrayList<QuizWordPojo> qlist = qwList;     //���������� ��絥���͸� ������ �ִ� ����Ʈ ������
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
