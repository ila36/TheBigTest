package com.test.utils;

import static com.jayway.restassured.RestAssured.sessionId;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.pages.PageObject;

public final class CookieFileStore {

	final static Logger logger = LoggerFactory.getLogger("manualLogger");
	final static Path filePath = Paths.get("/home/ila/git/testGitRepo/ATest/src/test/resources/cookiefiles");

	public static void writeCookiesToFile(String filename, PageObject page) {

		try {

			File file = new File(filePath.toFile(), filename);
			Files.createDirectories(filePath);
			file.delete();
			file.createNewFile();
			FileWriter fwriter = new FileWriter(file, true);
			BufferedWriter bwriter = new BufferedWriter(fwriter);

			for (Cookie c : page.getDriver().manage().getCookies()) {

				bwriter.write(c.getName() + ";" + c.getValue() + ";" + c.getDomain() + ";" + c.getPath() + ";"
						+ c.getExpiry() + ";" + c.isSecure());
				bwriter.newLine();
			}
			bwriter.flush();
			bwriter.close();
			fwriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readCookiesFromFile(String filename, PageObject page) throws ParseException {

		try {

			File file = new File(filePath.toFile(), filename);
			FileReader freader = new FileReader(file);
			BufferedReader breader = new BufferedReader(freader);

			String line;
			String name = null;
			String value = null;
			String domain = null;
			String path = null;
			Date expiry = null;
			Boolean isSecure = false;

			while ((line = breader.readLine()) != null) {

				String[] token = line.split(";");

				for (int x = 0; x < token.length; x++) {

					name = token[0];
					value = token[1];
					domain = token[2];
					path = token[3];
					String val;
					if (!(val = token[4]).equals("null")) {
						DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
						expiry = df.parse(val);
					}
					isSecure = new Boolean(token[5]).booleanValue();
				}
				Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
				// This will add the stored cookie to your current session
				page.getDriver().manage().addCookie(ck);
				logger.debug("ADD COOKIE TO BROWSER :" + ck);
			}
			breader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}