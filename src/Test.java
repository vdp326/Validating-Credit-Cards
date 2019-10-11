
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myList = { 1, 2, 3, 4, 5, 6 };

		for (int i = 1; i < myList.length; i++) {
			myList[i] = myList[i -1];
		}

		for (int i = 0; i < myList.length; i++)
			System.out.print(myList[i] + " ");

	}

}
