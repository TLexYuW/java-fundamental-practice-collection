package com.lex.practice.sealed.marker_interface;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		Z<A> az = new Z<>();
		Z<B> bz = new Z<>();
//		Z<String> sz = new Z<>(); // err
	}
}