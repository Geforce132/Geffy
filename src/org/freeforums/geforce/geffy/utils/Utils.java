package org.freeforums.geforce.geffy.utils;

import java.util.Random;

public class Utils {
	
	public static int getRandomNumber(int max){
		Random random = new Random();
		return random.nextInt(max);
	}

}
