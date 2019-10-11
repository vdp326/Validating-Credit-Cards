
/**
 * Vu Pham 
 * CSC 501
 * Assignment #6
 * Project: Validating Credit Cards 
 */

import java.util.Scanner;

public class Exercise06_31 {

	public static void main(String[] args) {

		long cardnum = 0;
		// getcardnum() method is used to get card number from user and return it.
		cardnum = getCardNum();

		// below code will print the validity of credit card
		if (validateCard(cardnum)) {
			System.out.println(cardnum + " is valid");
		} else {
			System.out.println(cardnum + " is invalid");
		}

	}

	static long getCardNum() {
		long cardnum;
		// scanner object is used to get long data from user.
		Scanner getnum = new Scanner(System.in);
		System.out.print("Enter a credit card number as a long integer: ");
		cardnum = getnum.nextLong();
		getnum.close();

		// this will return card number entered by user.
		return cardnum;

	}

	static boolean validateCard(long cardnum) {
		long tempnum, dcurrent, dfirst = 0, dfirsttwo = 0;
		int dcount = 0;
		long digitsum = 0;
		boolean iseven = false;

		tempnum = cardnum;

		// below code is used to check card validity
		for (; tempnum > 0;) {
			// dcurrent stores current ditig while dcount will count total digits of card
			// number.
			// dfirst and dfirsttwo are used to store first and first two digits of card
			// number.

			dcurrent = tempnum % 10;
			dcount = dcount + 1;

			// below condition will check for first two digit and store it.
			if (tempnum / 100 == 0 && tempnum % 100 > 9) {
				dfirsttwo = tempnum;

				if (dfirsttwo != 37) {
					dfirst = dfirsttwo / 10;
				}

			}

			// below condition will check for even digit and perform required steps
			if (iseven == true) {
				dcurrent = dcurrent * 2;
				digitsum = digitsum + (dcurrent / 10);
			}

			digitsum = digitsum + (dcurrent % 10);

			iseven = !iseven;
			tempnum = tempnum / 10;
		}

		// below condition will check all required flags and return boolean result
		if (digitsum % 10 == 0 && (dfirsttwo == 37 || dfirst == 4 || dfirst == 5 || dfirst == 6)
				&& (dcount >= 13 && dcount <= 16)) {
			return true;
		} else {
			return false;
		}

	}

}
