package exam;

public class DmbCellPhone extends CellPhone{
	private int channel;
	
	DmbCellPhone(String model, String color){
		setColor(color);
		setModel(model);
		
	}

	
	void turnOnDmb() {
		System.out.println("ä�� :"+ channel+" �� DMB��� ������ �����մϴ�");
		
	}
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("ä�� :"+ channel+" ������ �ٲߴϴ�.");
		
	}
	void turnOffDmb() {
		System.out.println("DMB��� ������ ����ϴ�.");
	}
	
	public int getChannel() {
		return channel;
	}
	
	
}
