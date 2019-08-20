package exam;

public class DmbCellPhone extends CellPhone{
	private int channel;
	
	DmbCellPhone(String model, String color){
		setColor(color);
		setModel(model);
		
	}

	
	void turnOnDmb() {
		System.out.println("채널 :"+ channel+" 번 DMB방송 수신을 시작합니다");
		
	}
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 :"+ channel+" 번으로 바꿉니다.");
		
	}
	void turnOffDmb() {
		System.out.println("DMB방송 수신을 멈춥니다.");
	}
	
	public int getChannel() {
		return channel;
	}
	
	
}
