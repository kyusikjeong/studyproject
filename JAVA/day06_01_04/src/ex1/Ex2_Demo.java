package ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_Demo extends JFrame{
	private JPanel p; //�г� ��ü
	private JButton b; //��ư ��ü
	public Ex2_Demo() {
		setTitle("�׽�Ʈ!"); //JFrame �θ��� �ڿ��� ���
		add(p = new JPanel()); //��������
		p.add(b=new JButton("Click"));
		//event �ڵ鸵!
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi!!");
				p.setBackground(Color.green);
			}
		});
		p.setBackground(Color.red);
		//���α׷� ����!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,300,200);
		//â�� Ȱ��ȭ
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex2_Demo();
	}

}
