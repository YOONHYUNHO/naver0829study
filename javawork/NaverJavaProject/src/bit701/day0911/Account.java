package bit701.day0911;

public class Account {
	private String accountNo;
	private String accountName;
	private int money;
	
	// 3개의 값을 전달 받는 생성자
	public Account(String accountNo, String accountName, int money)
	{
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.money = money;
	}
	
	// 계좌번호가 맞을경 true를 반환해주는 메서드
	// isAccount(String accountNo) : 맞을경우 true, 틀릴경우 false
	public boolean isAccount(String accountNo) 
	{
		if(accountNo.equals(this.accountNo))
			return true;
		else
			return false;
	}
	// 외부에서 입금 시 money에 추가하는 메서드(addMoney)
	public void addMoney(int money)
	{
		this.money += money;
	}
	// 외부에서 출금 시 money에서 빼는 메서드(subMoney)
	public void subMoney(int money)
	{
		this.money -= money;
	}
	
	// 출력 계좌번호 예금주 잔액(accountWrite)
	public void accountWrite()
	{
		System.out.println(accountNo + "\t" + accountName + "\t" + money);
	}

	
	
	// getter method
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public int getMoney() {
		return money;
	}
	
}
