package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //������ �������� ������ 
        String path = "C:\\bigdataStudy\\java\\asdfasdf.txt";
        FileOutputStream fos = null;
        
        try {
            //������ ������ ������ �����Ѵ�.
            //�ι�° ���ڿ� �����͸� append
            fos = new FileOutputStream(path,true);     //���� ��� �ڿ� true�� �߰��ϸ� ������ ���� ���� ���� �����͸� �߰��ϰ� �ȴ�.
            fos.write(66); 
            fos.write(65);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex); 
         // �ݺ��� ���� �����޼��� �κп��� Surround Statement with try-catch �޴��� �ڵ������ϸ� �����Ǵ� �޼ҵ�...������ �߻��ϴ� ��ġ�� ���� �޼����� �Բ� �ֿܼ� ����Ѵ�.
            ex.printStackTrace(); //������ �߻��� �޼ҵ��� ȣ���� ���
        } finally {
            if(fos != null){
                fos.flush();
                fos.close();   //�۾��� ������ ������ �ݾ��ش�.
            } 
        }
    }
}
