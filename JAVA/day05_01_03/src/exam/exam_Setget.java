package exam;


// 1.������ ������ ������ ��ü
// �м� -> ����( ��������ų�, ����)
// 2.�����ͺ��̽� ����� ��ƼƼ�� �ٷ� ���۰���!
// �ڵ����� ��������, �׻� ���� ����. 
public class exam_Setget {
// ȸ���� ������ ����
	//����ʵ�, �������� =>�ݵ�� �ҹ��ڷ� �ۼ��ؼ�... ����Ģ ����
	private int num; //ȸ����ȣ
	private int age;
	private String name, id;//ȸ���� ������
	private boolean agree;// ���� ����
	
	//setter /getter�� �޼��带 �����Ѵ�.
	// Alt + shift + s -> setter /getter generate
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//boolean���� getter�̴�. ************
	public boolean isAgree() {
		return agree;
	}//*********************************
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	
	
}
