


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Test {
    public static void main(String[] args) throws IOException {
           Scanner sc = new Scanner(System.in);  //��ĳ�ʷ� �ܺο��� �Է¹޴� �����͸� ���.
             //��ĳ�ʴ� ���۸� �����ϰ� ������, File �̳�, inputStream, Path �� �Ű������� ���� ���� �ִ�

           String msg = "";
           if (sc.hasNext()) {  //�Էµ� ���� ������ true��,������ false�� ��ȯ.
                //��ū�� ���๮�ڸ�(\n) �����ִ� ��쿡�� false�� ��ȯ������, ���๮�ڴ� �״�� �����ִ�.

                msg = sc.nextLine();  //�� ��(���๮��,����)�� �������� �Է��� �޴´�.

                System.out.println("Client Message Log : " + msg);
            }
            
            
    }
}
