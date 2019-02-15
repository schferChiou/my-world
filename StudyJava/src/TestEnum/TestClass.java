package TestEnum;

import java.lang.reflect.Field;

public class TestClass {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Object obj = new A();
		
		Class<?> clz = obj.getClass();
		Field field = clz.getDeclaredField("name");
		field.setAccessible(true);
		String value = (String) field.get(obj);
		System.out.println(value);
		System.out.println(clz.getSimpleName());
	}
}
class A {
	private String name = "fs";
	private String age = "16";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}