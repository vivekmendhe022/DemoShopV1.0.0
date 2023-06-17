package com.generic.utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomValue() {
		Random random = new Random();
		int value = random.nextInt(1000);
		return value;
	}

	public static String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}

	public String getSystemDateinFormate() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String date = split[2];
		String month = split[1];
		String year = split[5];
		String time = split[3].replace(":", "-");
		return date + " " + month + " " + year + " " + time;
	}

}
