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
public class Ex1_File1 {
    public static void main(String[] args) {//mkdir -p 
        String path = "demo.txt";   //������ ����Է�
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
        System.out.println("�θ� ���丮�� ����?"+f.getPath());
        
        
        
      
}

