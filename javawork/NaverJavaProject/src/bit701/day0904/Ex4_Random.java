package bit701.day0904;

import java.util.Scanner;

public class Ex4_Random {
	public static void main(String[] args) {
		
		/*
		 * 자바에서 난수 발생시키는 방법
		 * 1. Math.random()
		 * 2. new Random()
		*/
		
		for(int i = 1; i <= 5; i++) 
		{
			double r = Math.random();
			System.out.println(r);
		}
		System.out.println(" = ".repeat(10));
		
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()*10); // 0 ~ 9사이
			int n1 = (int)(Math.random()*10)+1; // 1 ~ 10사이
//			System.out.println(n);
			System.out.println(n1);
		}
		System.out.println(" = ".repeat(10));
		
		for(int i = 0; i < 5; i++) 
		{
			int n = (int)(Math.random()*26)+65; // 65 ~ 90사이
			System.out.println((char)n);
		}
		System.out.println(" = ".repeat(10));

		for(int i = 0; i < 5; i++) 
		{
			int n = (int)(Math.random()*26)+97; // 97 ~ 122사이
			System.out.println((char)n);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
