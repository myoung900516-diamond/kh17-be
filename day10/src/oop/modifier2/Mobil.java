package oop.modifier2;

public class Mobil {
	private String model;
	private int memory;
	private String telecom;
	private int mobilPrice;
	private int period;
	
	public void setModel(String model) {
		this.model = model;
	}
	public void setMemory(int memory) {
		switch(memory) {
		case 64, 128, 256, 512:
			this.memory = memory;
		}
//		if(memory != 64)return;
//		if(memory != 128)return;
//		if(memory != 256)return;
//		if(memory != 512)return;
	}
	public void setTelecom(String telecom) {
		switch(telecom) {
		case "SKT", "KT", "LG", "알뜰폰":
		this. telecom = telecom;
		}
	}
	public void setMobilPrice(int mobilPrice) {
		if(mobilPrice <0 )return;
		this.mobilPrice = mobilPrice;
	}
	public void setPeriod(int period) {
		switch(period) {
		case 0, 24, 36:
			this.period = period;
		}
	}
	public String getModel() {
		return this.model;
	}
	public int getMemory() {
		return this.memory;
	}
	public String getTelecom() {
		return this.telecom;
	}
	public int getMobilPrice() {
		return this.mobilPrice;
	}
//		if(this.period == 0) {
//			return this.mobilPrice*(100 + 10)/100;
//		}
//		else{
//			return this.mobilPrice/12;
//		}
//	}
//		int getMobilPrice() {
//			if(period == 0) {
//			return this.mobilPrice*(100 + 10)/100;
//		}		
//	}
	public int getPeriod() {
		return this.period;
	}
	public boolean isContractExist() { 
		return this.period > 0;
	}
	public int getMonthlyPrice() {
		if(this.period == 0) return 0;
		return this.mobilPrice / this.period;
	}
	public int getExtraPrice() {
		return this.mobilPrice * (100 + 10)/100;
	}
	
//	public int getPricePerMonth() {
//		return this.mobilPrice/12;
//	}
//	int getSurCharge() {
//		return this.mobilPrice*(100-10)/100;
//	}
	public void init(String model, int memory, String telecom, int mobilPrice) {
		this.init(model, memory, telecom, mobilPrice, 0);
	}
	public void init(String model, int memory, String telecom, int mobilPrice, int period) {
		this.setModel(model);
		this.setMemory(memory);
		this.setTelecom(telecom);
		this.setMobilPrice(mobilPrice);
		this.setPeriod(period);
	}
	public void show() {
		System.out.println("<" + this.getModel() + ">");
		System.out.println("메모리 : " + this.getMemory() + "GB");
		System.out.println("통신사 : " + this.getTelecom());
		if(this.isContractExist()) {
			System.out.println("판매가 : " + this.getMobilPrice() + "원 (월" + this.getMonthlyPrice() + "원)");
			System.out.println("약정기간 : " + this.getPeriod() + "개월");
		}
		else {
			System.out.println("판매가 : " + this.getExtraPrice() + "원 (약정기간 없을 경우 10% 인상됩니다.)");
		}
			
		//System.out.println("판매가 : " + this.getMobilPrice() + "원");
	}

}
