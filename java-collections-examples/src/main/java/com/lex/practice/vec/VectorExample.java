package com.lex.practice.vec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author : Lex Yu
 * @date : 2023/7/4
 */
public class VectorExample {
	public static void main(String[] args) throws InterruptedException {
		int size = 1_000_000;

		//-------------------------------------------------------------------------------------------------------------
//		/*
		List<Integer> arrayList = new ArrayList<>();
		long start = System.nanoTime();

		for (int i = 0; i < size; i++) {
			arrayList.add(i);
		}

		long end = System.nanoTime();

		long millisecs = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);

		System.out.println("Added " + size + " elements to arraylist: " + millisecs);
		System.out.println("Size : " + arrayList.size());

//		 */
		//-------------------------------------------------------------------------------------------------------------
		List<Integer> vector = new Vector<>();

		start = System.nanoTime();

		for (int i = 0; i < size; i++) {
			vector.add(i);
		}

		end = System.nanoTime();

		millisecs = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);

		System.out.println("Added " + size + " elements to vector: " + millisecs);
		System.out.println("Size : " + vector.size());

		//-------------------------------------------------------------------------------------------------------------

		List<Integer> multiThreadSafeArrayList = Collections.synchronizedList(new ArrayList<>());
		List<Integer> multiThreadArrayList = new ArrayList<>();

		start = System.nanoTime();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < size; i++) {
				multiThreadSafeArrayList.add(i);
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < size; i++) {
				multiThreadSafeArrayList.add(i);
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		end = System.nanoTime();

		millisecs = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);

		System.out.println("Added " + size + " elements to multiThreadArrayList: " + millisecs);
//		System.out.println("Size : " + multiThreadArrayList.size());
		System.out.println("Size : " + multiThreadSafeArrayList.size());
		//-------------------------------------------------------------------------------------------------------------
		List<Integer> multiThreadVector = new Vector<>();
		start = System.nanoTime();

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < size; i++) {
				multiThreadVector.add(i);
			}
		});
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < size; i++) {
				multiThreadVector.add(i);
			}
		});
		t3.start();
		t4.start();
		t3.join();
		t4.join();

		end = System.nanoTime();

		millisecs = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);

		System.out.println("Added " + size + " elements to multiThreadVector: " + millisecs);
		System.out.println("Size : " + multiThreadVector.size());


	}
}
