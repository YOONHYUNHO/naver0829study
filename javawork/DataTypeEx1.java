public class DataTypeEx1 {
	public static void main (String[] args) {
		// �� ������ ����๮�Դϴ�.
		/* 
			2023.08.30
		  	����Ÿ Ÿ�� ����
		*/

		// byte�� 1byte ũ���� ������ Ÿ���Դϴ�.
		// ũ��� -128 ~ 127 ���� ����
		byte a = 127;
		System.out.println("a = " + a);
	
		byte b = (byte)200; // ���� �߻� , ���� ����ȯ
		System.out.println("b = " + b); // ���� ����ȯ ���� ��� ���ս� �߻�

		// ���� �� ����(�Ű� ����, �Ķ����)�� �Ѿ���� ���ڿ�
		System.out.println(args[0]); // �迭�� ù ���ڿ� ���
		
	}
}	