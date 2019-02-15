package com.qsf.java.interfacedemo;



public class Demo2 {

	public static void main(String[] args) {
		SuperMaket suerMaket = new SuperMaket();
		suerMaket.insert(new Cup("高温杯",25));
	}
}
interface Goods{//商品
	public String getName();
	public double getPrice();
}
class SuperMaket{//超市
	private SingleLinkedList goods; //所有商品
	public SuperMaket(){
		this.goods = new SingleLinkedList();
	}
	public void insert(Goods g){
		this.goods.addHead(g);
	}
	public void delete(Goods g){
		this.goods.delete(g);
	}
//	public SingleLinkedList search(String keyWord){
//		re
//	}
	public SingleLinkedList getGoods(){
		return this.goods;
	}
}
class Cup implements Goods{
	public String name;
	public double price;
	public Cup(String name,double price){
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	public boolean equals(Object object){
		if(null == object){
			return false;
		}
		if(this == object){
			return false;
		}
		if(!(object instanceof Cup)){
			return false;
		}
		Cup cup = (Cup) object;
		if(this.name.equals(cup.getName())&& this.price == cup.getPrice()){
			return true;
		}
		return false;
	}
}