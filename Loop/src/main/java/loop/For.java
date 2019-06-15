package loop;

import java.util.List;

public class For {

	/**
	 * モダンな実装
	 * ただコンソール出力するだけ
	 * @param stringList
	 */
	public void forModern(List<String> stringList) {
		System.out.println("=====モダンな実装=====");
		stringList.forEach(System.out::println);
	}

	/**
	 * レガシーな実装
	 * ただコンソール出力するだけ
	 * @param stringList
	 */
	public void forLegacy(List<String> stringList) {
		System.out.println("=====レガシーな実装=====");
		for(String str: stringList) {
			System.out.println(str);
		}
	}

	/**
	 * モダンな実装
	 * １行目をスキップしてコンソール出力する
	 * @param stringList
	 */
	public void skipModern(List<String> stringList) {
		System.out.println("=====モダンな実装=====");
		stringList.stream().skip(1).forEach(System.out::println);
	}

	/**
	 * レガシーな実装
	 * １行目をスキップしてコンソール出力する
	 * @param stringList
	 */
	public void skipLegacy(List<String> stringList) {
		System.out.println("=====レガシーな実装=====");
		for(int lineIndex = 0; lineIndex < stringList.size(); lineIndex++) {
			if (lineIndex == 1) {
				continue;
			}
			System.out.println(stringList.get(lineIndex));
		}
	}

	/**
	 * モダンな実装
	 * 文字列を検索してヒットしたらコンソール出力
	 * @param stringList
	 * @param conditionString
	 */
	public void findModern(List<String> stringList, String conditionString) {
		System.out.println("=====モダンな実装=====");
		stringList.stream().filter(str -> str.contains(conditionString)).forEach(System.out::println);
	}

	/**
	 * レガシーな実装
	 * 文字列を検索してヒットしたらコンソール出力
	 * @param stringList
	 * @param conditionString
	 */
	public void findLegacy(List<String> stringList, String conditionString) {
		System.out.println("=====レガシーな実装=====");
		for(String str: stringList) {
			if (str.contains(conditionString)) {
				System.out.println(str);
			}
		}
	}
}
