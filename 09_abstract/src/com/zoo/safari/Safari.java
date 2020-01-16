package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo{
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
//		zoo.giraffe();
//		zoo.elephant();
//		zoo.lion();
		
		Safari safari =  (Safari) new Zoo();
		safari.tiger();
		safari.giraffe();
//		safari.elephant();
//		safari.lion();
		
		
	}
	
}
