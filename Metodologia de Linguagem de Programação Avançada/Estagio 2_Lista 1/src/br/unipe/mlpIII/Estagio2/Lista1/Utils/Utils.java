package br.unipe.mlpIII.Estagio2.Lista1.Utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {

	@SuppressWarnings("finally")
	private static char getChar() {
		char ch = 0;
		byte[] input = new byte[100];
		try {
			System.in.read(input);
			System.in.skip(System.in.available());
			ch = (char) input[0];
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return ch;
		}
	}

	public static boolean yesNo() {
		char ch = 0;
		ch = getChar();
		return ((ch == 'Y') || (ch == 'y') || (ch == 'S') || (ch == 's'));
	}

	public static char option(String options) {
		char ch = 0;
		char op = 0;
		ch = getChar();
		for (int i = 0; i < options.length(); i++) {
			char test = options.charAt(i);
			if (test == ch) {
				op = ch;
				break;
			}
		}
		return op;
	}

	public static String stringDeliverer(Scanner scan) {
		String token = "";
		scan.reset();
		if (scan.hasNextLong())
			token = Long.toString(scan.nextLong());
		if (scan.hasNextLine())
			token = scan.nextLine();
		scan.useDelimiter(Pattern.compile(System.lineSeparator()));
		if (scan.hasNext() && scan.hasNextLine())
			token = scan.nextLine();
		return (!token.equals("")) ? token : "";
	}

}
