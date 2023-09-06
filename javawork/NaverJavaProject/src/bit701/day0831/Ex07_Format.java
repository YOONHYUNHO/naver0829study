package bit701.day0831;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Format {

	public static void main(String[] args) {

		// 패턴을 이용해서 다양하게 날짜, 시간 출력
		
		Date date = new Date();
		
		// 패턴1
		// EEE : 요일 짧게, HH : 24시간
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		System.out.println(dateFormat1.format(date));
		
		// 패턴2
		// a : 오전 오후 EEEE : 요일 길게 hh : 12시간
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시mm분ss초 EEEE"); 
		System.out.println(dateFormat3.format(date));

		// 숫자를 format 양식에 맞게 출력
		int money = 4567890;
		
		NumberFormat numberFormat1 = NumberFormat.getInstance(); // 컴마
		System.out.println(numberFormat1.format(money)); // 4,567,890
				
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(); // 지역 화폐단위
		System.out.println(numberFormat2.format(money));		
		
		double num = 456.12345;
		System.out.println(numberFormat1.format(num));
		
		numberFormat1.setMaximumFractionDigits(1);
		System.out.println(numberFormat1.format(num));
		
		
		
		
		
		
		
		
		
		
	}

}
