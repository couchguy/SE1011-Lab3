/*
 * SE-1011-001
 * Winter 2010-1011
 * Lab 3
 * Dan Kass
 * 01/04/11
 */

package kassd;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Lab3GUI {
	public static void main(String[] args) {
		String userInput;
		Scanner scan;
		int wordCount = 0;
		boolean go = true;
		boolean first = true;
		boolean firstWords = false;
		String shortest = "";
		String longest = "";
		int shortestLength = 0;
		int longestLength = 0;
		String currentWord = "";
		int firstWordLength = 0;
		String newWord = "";
		String newest = "";
		boolean readOnce = true;

		// Allows to operation to continue and repeat
		while (go) {
			userInput = JOptionPane
					.showInputDialog("Please enter your words here.");
			readOnce = true;
			
			// if the user didn't hit cancel
			if (userInput != null) {
				scan = new Scanner(userInput);
				while (scan.hasNext()) {
					currentWord = scan.next();
					// sets the first word so the rest can be compared to it
					if (first) {
						shortest = currentWord;
						shortestLength = shortest.length();
						longest = currentWord;
						longestLength = longest.length();
						firstWordLength = currentWord.length();
						wordCount++;
						first = false;
						// compares words to the shortest word and replaces it
						// if shorter
					} else if (shortestLength >= currentWord.length()) {
						if (firstWordLength != currentWord.length()) {
							newWord = currentWord;
						}
						shortest = currentWord;
						shortestLength = shortest.length();
						wordCount++;
						// compares words to the longest word and replaces it if
						// longer
					} else if (longestLength <= currentWord.length()) {
						if (firstWordLength != currentWord.length()) {
							newWord = currentWord;
						}
						longest = currentWord;
						longestLength = longest.length();
						wordCount++;
						// for the words that are in between the shortest and
						// longest words so they can be included in the word
						// count
					} else {
						if (firstWordLength != currentWord.length()) {
							newWord = currentWord;
						}
						wordCount++;
					}
					//makes sure that the first word used in the new string won't have a "|"
					if ((newWord.length() > firstWordLength) && (readOnce)){
						firstWords = false;
						readOnce = false;
					}
					//adds "|" to the word that will be added to the new string
					if ((firstWords) && (!(newWord.equals("")))) {
						newWord =  "|" + newWord;
						
					}
					//adds the newWord to the new string and then resets newWord
					newest = newest + newWord;
					newWord = "";
					firstWords = true;

				}
				// Displays the word count of the last sentence entered,
				// shortest word information and longest word information
				JOptionPane.showMessageDialog(null, "There are " + wordCount
						+ " words. \nThe shortest word is \"" + shortest
						+ "\", and it is " + shortestLength
						+ " characters long. \nThe longest word is \""
						+ longest + "\", and it is " + longestLength
						+ " characters long.");
				// New String
				JOptionPane.showMessageDialog(null, newest);
				// New String resets to nothing
				newest = "";

				// Resets the word count to zero for the next sentence.
				wordCount = 0;
				
				

				// The user hits cancel to end the operation.
			} else {
				JOptionPane.showMessageDialog(null, "Thank You");
				go = false;
			}

		}
	}
}
