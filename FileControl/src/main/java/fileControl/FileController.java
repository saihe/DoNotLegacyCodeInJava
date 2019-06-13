package fileControl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * ファイル操作クラス.
 */
public class FileController {

	/**
	 * モダンなファイル読み込み
	 * オートクロージャブルな実装
	 * @param fileFullPath
	 */
	public void printFileContentModern(Path fileFullPath) {
		try {
			System.out.println("=============モダンな実装=============");
			Files.readAllLines(fileFullPath).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * レガシーなファイル読み込み
	 * オートクロージャブルな実装
	 * @param fileFullPath
	 */
	public void printFileContentLegacy(String fileFullPath) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileFullPath)));) {
			System.out.println("=============レガシーな実装=============");
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * モダンなファイル書き込み
	 * オートクロージャブル、ファイルが存在しても新規置き換えする
	 * @param inputFileFullPath
	 * @param outputFileFullPath
	 */
	public void writeFileModern(Path inputFileFullPath, Path outputFileFullPath) {
		try {
			System.out.println("=============モダンな実装=============");
			List<String> contents = Files.readAllLines(inputFileFullPath);
			contents.add("追加した行");
			Files.write(
					outputFileFullPath, contents, new OpenOption[] {
							StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE
					});
			contents.forEach(System.out::println);
			System.out.println("書き込み正常終了");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * レガシーなファイル書き込み
	 * オートクロージャブル、ファイルが存在しても新規置き換えする
	 * @param inputFileFullPath
	 * @param outputFileFullPath
	 */
	public void writeFileLegacy(String inputFileFullPath, String outputFileFullPath) {
		File f = new File(outputFileFullPath);
		try {
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileFullPath)));
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));) {
			System.out.println("=============レガシーな実装=============");
			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
				sb.append(System.getProperty("line.separator"));
			}
			sb.append("追加した行");
			sb.append(System.getProperty("line.separator"));
			pw.write(sb.toString());
			System.out.println(sb.toString());
			System.out.println("書き込み正常終了");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
