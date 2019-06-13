package For;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		For f = new For();
		List<String> stringList = new ArrayList<String>();
		stringList.add("1行目");
		stringList.add("2行目");
		stringList.add("3行目");

		// ただコンソール出力
		System.out.println("*****ただコンソール出力*****");
		f.forModern(stringList);
		f.forLegacy(stringList);

		// 1行目をスキップしてコンソール出力
		System.out.println("*****1行目をスキップしてコンソール出力*****");
		f.skipModern(stringList);
		f.skipLegacy(stringList);

		// 指定した文字列を検索してコンソール出力
		System.out.println("*****指定した文字列を検索してコンソール出力*****");
		f.findModern(stringList, "2");
		f.findLegacy(stringList, "2");
	}

}
