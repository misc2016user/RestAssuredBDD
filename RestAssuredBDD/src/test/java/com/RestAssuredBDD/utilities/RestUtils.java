package com.RestAssuredBDD.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	 public static String getRandomName() {
         return RandomStringUtils.randomAlphabetic(4);
 }
 
 public static String getRandomSalary() {
         return RandomStringUtils.randomNumeric(5);
 }
 
 public static String getRandomJob() {
         return RandomStringUtils.randomAlphabetic(5);
 }


}
