package main;

import java.security.NoSuchAlgorithmException;

import p.Md5;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(new Md5().of("Hello World! This is nice!"));
	}
}
