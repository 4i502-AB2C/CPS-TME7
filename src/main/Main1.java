package main;

import java.util.HashMap;

import services.MapService;
import components.MapImplem;
import contracts.MapContract;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapService map = new MapContract(new MapImplem(5,6,new HashMap()));

	}

}
