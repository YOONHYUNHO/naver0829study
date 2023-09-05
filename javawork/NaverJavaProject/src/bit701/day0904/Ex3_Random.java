package bit701.day0904;

import java.util.Random;
import java.util.Scanner;

public class Ex3_Random {
	public static void main(String[] args) {
		
		/*
		 * 자바에서 난수 발생시키는 방법
		 * 1. Math.random()
		 * 2. new Random()
		*/
		
		Random r = new Random();
		for(int i = 0; i < 5; i++)
		{
			int n = r.nextInt();
			System.out.println(n);
		}
		System.out.println(" = ".repeat(10));
		
		for(int i = 0; i < 5; i++)
		{
			int n = r.nextInt(100)+1; // 1 ~ 100
			System.out.println(n);
		}
		System.out.println(" = ".repeat(10));
		
		for(int i = 0; i < 5; i++)
		{
			int n = r.nextInt(26)+65;
			System.out.println((char)n); 
		}
		System.out.println(" = ".repeat(10));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
