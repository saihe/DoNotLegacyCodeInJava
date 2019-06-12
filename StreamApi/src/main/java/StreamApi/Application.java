package StreamApi;

import StreamApi.fileController.FileReader;

public class Application {

	public static void main(String[] args) {
//		System.out.println(System.getProperties().get("java.class.path"));
		new FileReader().run();
	}
}
