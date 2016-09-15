package com.github.alexaegis.task02;

import java.math.BigInteger;

public class Main {

	private Main() {

	}

	public static void main(String[] args) {
		for (String a : args) {
			long n = Long.parseLong(a);
			System.out.print(n);
			if(isPrime(n)) {
				System.out.println(" is a prime.");
			} else {
				System.out.println(" is not a prime.");
			}

		}
	}

	private static boolean isPrime(long n) {
		return BigInteger.valueOf(n).isProbablePrime(30);
	}

}