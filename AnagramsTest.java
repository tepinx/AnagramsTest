package com.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsTest {

	public static void main(String[] args) {
		try {
			// Change the wordlist.txt location
			File fileDir = new File("C:/wordlist.txt");

			HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String str;
			while ((str = in.readLine()) != null) {
				String sorted = str.toLowerCase().chars().sorted()
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

				if (hmap.get(sorted) != null) {
					hmap.get(sorted).add(str);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(str);
					hmap.put(sorted, list);
				}

			}

			hmap.forEach((k, v) -> {
				if (hmap.get(k).size() > 1) {
					System.out.println(v);
				}
			});

			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
