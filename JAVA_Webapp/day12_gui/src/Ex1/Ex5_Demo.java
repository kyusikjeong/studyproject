/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ex5_Demo {

 
    public static void main(String[] args) {
        try {
            BufferedReader br = null;
            String path="https://news.naver.com/main/read.nhn?oid=052&sid1=103&aid=0001240445&mid=shm&mode=LSD&nh=20190114114615";
            URL url = new URL(path);
           
            //��¿�� ���� ����Ʈ ��Ʈ������ �޾ƿ� ��ü��
            //���ڽ�Ʈ������ �����Ϸ��� �� ���� �ִ�.
            //InputStreamReader(inputStream,���ڵ�)
            // => Scanner �� ��ü �����ϴ�.(InputStreamReader x)            //������ ���� ��� temperary? �ӽ� ������ ���� ����Ǵµ� �װ� �о�´�.
            //��������: Scanner �� API �����ؼ�
            //�Ȱ��� ������� Ex5_ScannerDemo���� �����Ͻÿ�
            //url.openStream() : InputStream  ������ �ҽ��� �ҷ��´�.
            br = new BufferedReader(
                    new InputStreamReader(url.openStream(),"euc-kr"));  //������ �ҽ��� euc-kr�������� ���ڵ�
            String str = null;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException ex) {
            
        }
}
}
