package exam;

public class SmartPhone extends CellPhone{
	
	private boolean bluetoothBtn;
	private boolean wifiBtn;
	


	SmartPhone(String model, String color){
		setColor(color);
		setModel(model);
		
	}
	
	void bluetoothOn() {
		System.out.println("블루투스가 켜졌습니다.");
		bluetoothBtn = true;
	}
	void bluetoothOff() {
		System.out.println("블루투스가 꺼졌습니다.");
		bluetoothBtn = false;
	}
	void wifiOn() {
		System.out.println("와이파이가 켜졌습니다.");
		wifiBtn = true;
	}
	void wifiOff() {
		System.out.println("와이파이가 꺼졌습니다.");
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
		System.out.println("현재 블루투스 상태는 "+ (bluetoothBtn?"on":"off") +" 상태이고,"+
						  " 와이파이 상태는 "+(wifiBtn? "on":"off")+ "입니다");
	}
}
