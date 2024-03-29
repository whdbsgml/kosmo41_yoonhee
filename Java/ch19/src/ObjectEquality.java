class INum
{
	private int num;
	public INum(int num)
	{
		this.num = num;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this.num == ((INum)obj).num)
			return true;
		else
			return false;
	}
}

public class ObjectEquality
{
	public static void main(String[] args)
	{
		INum num1 = new INum(10);
		INum num2 = new INum(12);
		INum num3 = new INum(10);
		
		if(num1.equals(num2))    // 인스턴스의 내용 비교를 위한 기능을 equals 메소드에 담아 정의한다.
			System.out.println("num1, num2 내용 동일하다.");
		else
			System.out.println("num1, num2 내용 다르다.");
		
		if(num1.equals(num3))    //equals는 Object 클래스의 메소드이다.
			System.out.println("num1, num3 내용 동일하다.");
		else
			System.out.println("num1, num3 내용 다르다.");
	}
}
