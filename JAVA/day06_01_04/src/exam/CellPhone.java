package exam;

public class CellPhone {
	private String model;
	private String color;
	
	
	
	
	void powerOn() {
		System.out.println("������ �մϴ�.");
	}
	void powerOff() {
		System.out.println("������ ���ϴ�.");
	}
	void bell() {
		System.out.println("���� �︳�ϴ�");
	}
	void sendVoice(String message) {
		System.out.println("�ڱ�: "+message);
	}
	void receiveVoice(String message) {
		System.out.println("���� : 	"+message);
	}
	void hangUp() {
		System.out.println("��ȭ�� �����ϴ�");
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
