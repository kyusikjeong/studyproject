/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class FileManager1 {
    
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringTokenizer st;
   
    private FileManager fm;
    private ArrayList<String> userList;
    private MemberData mData;

    public FileManager(){
      mData = new MemberData();
    }
   
    
    
    public ArrayList<String> getMemo() throws FileNotFoundException, IOException {
        ArrayList<String> ar = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberData.properties"));
        String rdv = null;
        // readLine() �� ��Ʈ���� ���ؼ� ���ڿ��� ���� ������ �о�´�.
        // ��������  null 
        while((rdv = br.readLine()) != null){
            //�о�� ���ڿ��� �� �� �� ArrayList�� ����
            ar.add(rdv);
        }
        br.close();
        return ar;
    }
    
    
    public MemberData printTest(String s){//id �˻���
        int idx =0;
        try {
            
            userList = getMemo();
           
             for(String e : userList){
                 st = new StringTokenizer(e);
                 while(st.hasMoreTokens()){
                   String id =   st.nextToken("////");
                   String pw = st.nextToken("////");
                   int wordNum = Integer.parseInt(st.nextToken("////"));
                   int totalNum = Integer.parseInt(st.nextToken("////"));
                   int wNum = Integer.parseInt(st.nextToken("////"));
                   
                   //���� ���̵� �˻�κ�.
                   if(id.equals("test")){
                       System.out.println("���� ����մϴ�");
                       System.out.println("totalNum"+totalNum);
                       mData.setwTotalNum(totalNum);
                       mData.setWinNum(wNum);
                       mData.setWordNum(wordNum);
                       
                   } 
               }
            }
        } catch (IOException ex) {
        }
//                     mdata.setId(st.nextToken("////"));
//                     mdata.setPw(st.nextToken("////"));
//                     mdata.setWordNum(Integer.parseInt(st.nextToken("////")));
//                     mdata.setwTotalNum(Integer.parseInt(st.nextToken("////")));
//                     mdata.setWinNum(Integer.parseInt(st.nextToken("////")));
            System.out.println("return");          
            return mData;
    
    }
    
    
    public MemberData getMdata() {
        return mData;
    }
    
    
    public void userDataInput(String userData){
//        userList = new ArrayList();
//        userList.add(userData);
//        
    }
    
    public void idCheck(String id){
        try {
            br = new BufferedReader(new FileReader("C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberData.properties"));
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                  
                  
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(MemberData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
