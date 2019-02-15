package TestEnum;

public class Singleton {

	private enum EnumSingleton {
		Singleton ;//enum变量
		private Singleton8 singleton8;
		
		private EnumSingleton() {
			singleton8 = new Singleton8();
		}
		public Singleton8 getInstance(){
			return singleton8;
		}
	}
	
	public static Singleton8 getInstance(){
		return EnumSingleton.Singleton.getInstance();
	}
}

class Singleton8{
	public Singleton8(){}
}
