package bit701.day0904;

public class Ex9_String {
	
	public static void main(String[] args) {
	
		String str1 = "apple";
		String str2 = "Apple";
		String str3 = "Have a Good Day";
		String str4 = "   Happy   ";
		
		System.out.println(str3.length()); 					// str3의 총 길이 : 15
		System.out.println(str1.toLowerCase()); 			// str1을 모두 소문자로 변환
		System.out.println(str2.toUpperCase()); 			// str2를 모두 대문자로 변환
		System.out.println(str3.substring(5)); 				// 5번 인덱스부터 끝까지 출력
		System.out.println(str3.substring(7, 11)); 			// 7번부터 10번까지 출력
		System.out.println(str3.charAt(0)); 				// str3에서 0번 문자 출력
		System.out.println(str3.charAt(7)); 				// str3에서 7번 문자 출력
		System.out.println(str1.indexOf('e')); 				// str1에서 첫번째 'a'의 인덱스 값
		System.out.println(str3.lastIndexOf('a')); 			// str3에서 마지막 'a'의 위치
		System.out.println(str4.length()); 					// 앞, 뒤 공백을 포함한 전체 길이
		System.out.println(str4.trim().length()); 			// trim : 앞, 뒤 공백을 제거 후 길이 구하기, 중간 공백은 제외
		System.out.println(str3.startsWith("Have")); 		// str3가 Have로 시작하면 true
		System.out.println(str3.endsWith("day")); 			// str3가 Day로 끝나면 true
		System.out.println(str1.equals(str2)); 				// str1, str2가 대소문자까지 같으면 true
		System.out.println(str1.equalsIgnoreCase(str2)); 	// 대소문자 상관 없이 철자만 같으면 true
		System.out.println(str1.compareTo(str2)); 			// str1과 str2의 차이 (양수 값: str1이 큰 값, 음수 값 : str2이 큰 값)
		System.out.println(str1.compareTo("apple")); 		// 완전 같을 경우 : 0
		
	}
}
