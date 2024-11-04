package GSach;

public class Sach {
	private int mas;
	private String tens;
	private String nhaxb;
	private int namsx;
	private float gia;
	
	public Sach() {
		
	}
	public Sach(int mas, String tens, String nhaxb, int namsx, float gia) {
		this.mas = mas;
		this.tens = tens;
		this.nhaxb = nhaxb;
		this.namsx = namsx;
		this.gia = gia;
	}
	
	public void setMas(int mas) {
		this.mas = mas;
	}
	public void setTens(String tens) {
		this.tens = tens;
	}
	public void setNhaxb(String nhaxb) {
		this.nhaxb = nhaxb;
	}
	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getMas() {
		return mas;
	}
	public String getTens() {
		return tens;
	}
	public String getNhaxb() {
		return nhaxb;
	}
	public int getNamsx() {
		return namsx;
	}
	public float getGia() {
		return gia;
	}
	
	public int Khuyenmai() {
		if(namsx < 2019) {
			return 25;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] arg) {
		Sach a = new Sach();
	}
	
}
