/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author KOSTA
 */
public class Ex1_File {
    public static void main(String[] args) {//mkdir -p 
        String path = "C:\\bigdataStudy\\java\\demo\\demo.txt";   //������ ����Է�
        //���� ��ü�� ���� : �ش� �����̳� ��ΰ� ��� �߻����� ��� ����
        File f = new File(path); //���� �����ڿ� ������ ��θ� �����ٴ� ���� �װ� �޾��ִ� �����ڰ� �ִٴ� ��.
        //���� �����ڴ� ���ڿ� path�� ������ ��θ� �����Ͽ� File��ü�� �����Ѵ�.
        
        System.out.println("test �� �����ϴ°�"+f.exists());
        
        if(f.exists()){   //exists() �޼ҵ�� ���丮 �Ǵ� ������ �ش��ο� �����Ѵٸ� true �� �����ϰ� �ƴϸ� false�� ����
            System.out.println("���� ����");
            
        }
        System.out.println("test.txt�� �����ΰ�?"+f.isFile());     //page 1020 api����. 
        System.out.println("������ �����Ѱ�?"+f.canExecute());
        System.out.println("�ۼ��� �����Ѱ�?"+f.canWrite());
        System.out.println("������"+f.getAbsolutePath());
        System.out.println("���丮�ΰ�? "+f.isDirectory());
        System.out.println("���� �� �ִ� �����ΰ�?"+f.canRead());
        System.out.println("������ �̸��� ����"+f.getName());
        System.out.println("�θ� ���丮�� ����?"+f.getParent());
        
        
        
        File f2 = new File("C:\\bigdataStudy\\java\\demo\\asdf.txt");
         if(!f2.exists()){   // ������ ������ !�� ��������Ƿ� �ش��ο� ������ ���ٸ� true�� ��. 
             
            try{                    //try catch�� �����ڰ� ���� ����� �߻��� �� �ִ� ������ ����ؼ� 
                                    //�غ��ص� �ڵ带 �����Ű�� ���̶�� �����ϸ� ����.
                                    //try �ȿ� ������ ���� �����ϰ� ���⼭ ����(����)�� �߻���
                                    //catch(�Ű�����) �Ű����� ��ġ�� ������ �ش��ϴ� exception �� �����صθ� 
                                    //catch ������ �̵��ؼ� �ش� ������ �����ϰ� ����ȴ�.
                                    
                 System.out.println("���� asdf �� ����ڽ��ϴ�");   //������ ������ �� ������ ���ͼ� ������ ����.
                 //0byte ¥�� ������ ����� �ش�. unix ���� touch��ɾ�
                 f2.createNewFile();//���ο� ������ �����.
            } catch(IOException ex){       
                ex.printStackTrace();
            }
         }else {
             System.out.println("�̹� �����մϴ�."); //������ �����.
         }
            
       //f3�̶� ���� ��ü��
       //�ش� ������ �ѹ��� ����� �ʹٸ�...
       //mkdirs - �߻����� ���� ���丮 ���� ����
        File f3 = new File("C:\\bigdataStudy\\java\\demo\\works\\work1");
                                //���� ��ο� ������ ������
        if(!f3.exists()){       //�ٷ����� ����ó�� ������ ������ true. if���� ����  
             f3.mkdirs();      //�ش� �޼ҵ带 ���� ��ο� ������ ��� ���� ���丮 ���� ����

        } else {
                System.out.println("�̹� ���� �մϴ�"+f3.getAbsolutePath()); //������ �̹� ������ ����� �ͼ� ������ �����θ� ���.
        }
     }
}

