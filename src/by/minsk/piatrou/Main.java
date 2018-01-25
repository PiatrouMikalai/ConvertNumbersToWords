package by.minsk.piatrou;

import java.io.IOException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		ConvertNumbersToWords converter = new ConvertNumbersToWords();
		Scanner in = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("Введите число:");
				
				BigInteger number = in.nextBigInteger();
				System.out.println(converter.converter(number));
			}
		}catch(InputMismatchException | NullPointerException e) {
			e.printStackTrace();
		}
	}
}
