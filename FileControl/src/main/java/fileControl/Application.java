package fileControl;

import java.nio.file.Paths;

public class Application {

	public static void main(String[] args) {
		String dirPath = "/Users/kyohei/Documents/work/eclipse/DoNotLegacyCodeInJava/FileControl/files";
		String inputFileName = "input.txt";
		String outputFileNameLegacy = "legacy_output.txt";
		String outputFileNameModern = "modern_output.txt";

		FileController fc = new FileController();
		// ファイル読み込み
		fc.printFileContentLegacy(dirPath + "/" + inputFileName);
		fc.printFileContentModern(Paths.get(dirPath, inputFileName));

		// ファイル書き込み
		fc.writeFileLegacy(dirPath + "/" + inputFileName, dirPath + "/" + outputFileNameLegacy);
		fc.writeFileModern(Paths.get(dirPath, inputFileName), Paths.get(dirPath, outputFileNameModern));
	}

}
