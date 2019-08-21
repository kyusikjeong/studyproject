package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_FileInputStreamDemo {
    public static void main(String[] args) {
        String path = "C:\\00_GUISpace\\temptemaap.txt";
        //���� ������ ���� �� �ʱ�ȭ
        //1�� ��Ʈ��, ����Ʈ ��Ʈ��
        //try �� scope ���� ������ �����ϴ� ������ �����غ���.
        
        FileInputStream fis = null; //�� Ŭ������ ���Ϸκ��� ����Ʈ ������ �о���϶� ����ϴ� ����Ʈ ��� �Է� ��Ʈ���̴�.
                                    //�׸�, �����, ����, �ؽ�Ʈ ���� �� ��� ������ ������ ���� �� �ִ�.
                                    //page 1021 ����
        try {
            //�Ϲ����� ����(�����Ͽ���)
            fis = new FileInputStream(path);   //������ String ������ ���� ��θ� ���� ��ü ����.
            int rdv = 0;
            //������ �������������� EOF(������ ��)���� �о���̴� 
            //�ݺ���, read():1byte �� �о���� �޼���. �� -1 �� ��ȯ
            int test = fis.read();
            System.out.println(test);
            while((rdv = fis.read()) != -1){   //�ش� ������ false�� �ɶ����� �ݺ�. Ǯ���
                                               //fis.read() �� �ش� ��Ʈ���� ����Ʈ�� �����Ѵ�. 1����Ʈ�� �о���鼭 ������ ������ ������ -1�� �����Ѵ�.
                                               //�׷��Ƿ� ��ȣ���� rdv = fis.read()�� �ϴ� ������ ������ int�� ������ ������ ������ ��ü ���� ������ ����Ʈ�� 1����Ʈ�� �о�鿩 �����ϰ� 
                                               //������ �� ���� �ʾ����� != -1 ������ ������ �ȵǾ� true �ϱ� ��� ���ٰ�
                                               //������ �� �а� -1�� ���� ������ != -1 ������ �����Ͽ� false�� �Ǹ鼭 ����ȴ�.
               System.out.print((char)rdv);   //���� ������ ������ ���ڷ� ����ϱ� ���� char������ ����ȯ �Ͽ� ���. 
            }
            //������ ������ �߻��Ǵ� ����
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("������ �������� �������");
        } catch (IOException ex) { 
            Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("�о���̴� ����");
        } finally { //finally ������ ���� try catch �������� exception�� �߻��ϵ� ���� �������� ����Ǵ� �����̴�.
            try {
                if(fis !=null){
                     fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
        
    }
}
