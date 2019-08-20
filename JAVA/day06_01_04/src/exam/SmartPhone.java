package exam;

public class SmartPhone extends CellPhone{
	
	private boolean bluetoothBtn;
	private boolean wifiBtn;
	


	SmartPhone(String model, String color){
		setColor(color);
		setModel(model);
		
	}
	
	void bluetoothOn() {
		System.out.println("��������� �������ϴ�.");
		bluetoothBtn = true;
	}
	void bluetoothOff() {
		System.out.println("��������� �������ϴ�.");
		bluetoothBtn = false;
	}
	void wifiOn() {
		System.out.println("�������̰� �������ϴ�.");
		wifiBtn = true;
	}
	void wifiOff() {
		System.out.println("�������̰� �������ϴ�.");
		wifiBtn = false;
	}

	public boolean isBluetoothBtn() {
		return bluetoothBtn;
	}

	public boolean isWifiBtn() {
		return wifiBtn;
	}
	public void setBluetoothBtn(boolean bluetoothBtn) {
		this.bluetoothBtn = bluetoothBtn;
	}

	public void setWifiBtn(boolean wifiBtn) {
		this.wifiBtn = wifiBtn;
	}
	void status() {
		System.out.println("���� ������� ���´� "+ (bluetoothBtn?"on":"off") +" �����̰�,"+
						  " �������� ���´� "+(wifiBtn? "on":"off")+ "�Դϴ�");
	}
}
