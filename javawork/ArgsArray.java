public class ArgsArray {
	public static void main(String[] args) {
		// args�� �� ���� ���ڸ� �о ���
		String str1 = args[0];
		String str2 = args[1];
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("�� ���� �� = " + (str1 + str2));

		// String�� �⺻�� int�� ��ȯ
		// Integer��� Wrapper class�� �̿��ؼ� ��ȯ
		int su1 = Integer.parseInt(str1);
		int su2 = Integer.parseInt(str2);
		System.out.println("�� ���� �� = " + (su1 + su2));
		 
	}	
}