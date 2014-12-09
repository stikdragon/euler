package uk.co.stikman.euler.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class Resources {

	public static List<String> read(String name) {
		try (InputStream is = Resources.class.getResourceAsStream(name); Reader rdr = new InputStreamReader(is, Charsets.UTF_8)) {
			return IOUtils.readLines(rdr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
