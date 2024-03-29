import java.util.Iterator;
import java.util.LinkedList;

//기본 자료형 데이터의 저장과 참조
public class A7_PrimitiveCollection {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		// 저장 과정에서 오토 박싱
		list.add(10);
		list.add(20);
		list.add(30);

		int n;
		for (Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			n = itr.next();
			System.out.println(n + "\t");
		}
		System.out.println();
	}
}
