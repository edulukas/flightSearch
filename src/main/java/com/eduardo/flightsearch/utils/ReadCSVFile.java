package com.eduardo.flightsearch.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * <p>Class that contains the method to read the csv file.</p>
 *
 * @author Eduardo de Diego Lucas
 * @see <a href="http://eduardodediegolucas.es">eduardodediegolucas.es</a>
 */
@Slf4j
public class ReadCSVFile {

	/**
	 * Name of the csv file
	 */
	public static final String FILE_FLIGHTS_NAME = "flights.csv";
	/**
	 * Charset of out project: UTF-8
	 */
	private static final Charset encoding = StandardCharsets.UTF_8;

	/**
	 * Read line by line the csv file and stores each line in a list of string.
	 *
	 * @param fileName
	 * @return a list of string containing all flights
	 */
	public List<String> readCSVFile(String fileName) {
		List<String> listFlights = null;
		Path path = null;
		//We obtain where the csv file is located
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(fileName);
		try {
			path = Paths.get(url.toURI());
			listFlights = Files.readAllLines(path, encoding);
		} catch (URISyntaxException uriException) {
			log.error("Error reading path", uriException);
		} catch (IOException ioException) {
			log.error("Error while performing I/O operations", ioException);
		}
		return listFlights;
	}

}
