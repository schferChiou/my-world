package TestEnum;

public enum ExampleEnum {
	
	ITEM_1("math","1"),
	ITEM_2("english","2"),
	ITEM_3("chinese","3"),;

	private String item ;
	private String number;
	
	
	public static void main(String[] args) {
		System.out.println("111==="+ExampleEnum.ITEM_1.getItem());
		System.out.println("111==="+ExampleEnum.ITEM_1.values());
	}
	private ExampleEnum(String item, String number) {
		this.item = item;
		this.number = number;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

