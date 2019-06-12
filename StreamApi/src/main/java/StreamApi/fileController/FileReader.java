package StreamApi.fileController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;

import org.supercsv.prefs.CsvPreference;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;

import StreamApi.fileController.model.Person;

public class FileReader {
	private Properties properties = new Properties();

	public void run() {
		try {
			properties.load(
					Files.newInputStream(
							Paths.get(
									ClassLoader.getSystemResource("application.properties").toURI())));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
			System.exit(9);
		}
		printProperties();
		printCsvContents();
	}

	private void printProperties() {
		Collections.list(properties.keys())
				.forEach(key -> System.out.println("key：[" + key + "]、value：[" + properties.get(key) + "]"));
	}

	private void printCsvContents() {
		try {
//			Files.readAllLines(
//					Paths.get(
//							properties.getProperty("file.path"), properties.getProperty("file.name")))
//					.forEach(System.out::println);
			CsvAnnotationBeanReader<Person> csvReader = new CsvAnnotationBeanReader<Person>(
					Person.class,
					Files.newBufferedReader(
							Paths.get(
									properties.getProperty("file.path"), properties.getProperty("file.name")),
							StandardCharsets.UTF_8),
					CsvPreference.STANDARD_PREFERENCE);

			csvReader.readAll().forEach(System.out::println);

			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(9);
		}
	}
}
