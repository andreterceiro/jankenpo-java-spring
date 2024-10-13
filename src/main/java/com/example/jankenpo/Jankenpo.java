package com.example.jankenpo;

import java.util.concurrent.ThreadLocalRandom;

public class Jankenpo {
	/**
	 * All the computer options 
	 */
	private static char[] computerOptions = new char[3];
	
	/**
	 * Integer constants to define the winner
	 */
	private static final byte COMPUTER_WINS = -1;
	private static final byte DRAW = 0;
	private static final byte USER_WINS = 1;

    /**
     * Compares the user option with the random computer option and returns
     * the winner
     * 
     * @param userOption option selected by the user
     * 
     * @return int
     */
    public static void evaluateAndShowResult(String userOption) {
        if (Jankenpo.computerOptions[0] != 'R') {
            Jankenpo.initializeComputerOptions();
        }
    
    	char computerOption = Jankenpo.getComputerOption();
    	Jankenpo.showResult(
			Jankenpo.getWinner(
				userOption, 
				computerOption
			),
			computerOption
		);
    }
    
    /**
     * Returns the computer option:
     * - "P" for "paper"
     * - "R" for "rock"
     * - "S" for "scissors"
     * 
     * @return char
     */
    private static char getComputerOption() {
        int randomNumber = ThreadLocalRandom.current().nextInt(3);
        return Jankenpo.computerOptions[randomNumber];
    }
    
    /**
     * Initialize an array of computer options
     * - "P" for "paper"
     * - "R" for "rock"
     * - "S" for "scissors"
	 *
	 * @return void
     */
    private static void initializeComputerOptions() {
    	Jankenpo.computerOptions[0] = 'P';
    	Jankenpo.computerOptions[1] = 'R';
    	Jankenpo.computerOptions[2] = 'S';
    }
    
    /**
     * Return the winner
     * - 1  - user (Jankenpo.USER_WINS)
     * - 0  - draw (Jankenpo.DRAW)
     * - -1 - computer (Jankenpo.COMPUTER_WINS
     * )
     * @param userOption     A string of the user option (first char of the word - 
     *                       'Paper' or 'Rock' or 'Scissor'
     * @param computerOption A char of the computer option (first char of the word - 
     *                       'Paper' or 'Rock' or 'Scissor'
     * 
     * @return return a byte related of the winner (Jankenpo.USER_WINS or Jankenpo.DRAW or
     *         Jankenpo.COMPUTER_WIN 
     */
    private static byte getWinner(String userOption, char computerOption) {
        byte dataToReturn = Jankenpo.DRAW; 
        if ((userOption.equals("P") && computerOption == 'R') || (userOption.equals("R") && computerOption == 'S') || (userOption.equals("S") && computerOption == 'P')) {
        	return Jankenpo.USER_WINS;
        } else if (! userOption.equals(String.valueOf(computerOption))) {
            return Jankenpo.COMPUTER_WINS;
        }

    	return dataToReturn;
    }
    
    /**
     * Displays a human readable text of the result
     * 
     * @param result         Byte representing the result (Jankenpo.USER_WINS or Jankenpo.DRAW or
     *                       Jankenpo.COMPUTER_WIN)
     * 
     * @param computerOption The computer random option to show to the user
     * 
     * @return void
     */
    private static void showResult(byte result, char computerOption) {
    	String stringComputerOption = Jankenpo.getStringOption(computerOption);
    	if (result == Jankenpo.DRAW) {
        	System.out.printf(
    			"Draw. Computer choosed '%s'\nR", 
    			stringComputerOption
			);
        } else if (result == Jankenpo.COMPUTER_WINS) {
        	System.out.printf(
    			"Computer wins. Computer choosed '%s'\n", 
    			stringComputerOption
			);        	
        } else {
        	System.out.printf(
    			"User wins. Computer choosed '%s'\n", 
    			stringComputerOption
			);        	
        }
    }
    
    /**
     * Return a string related to the option
     * - "Paper" - 'P'
     * - "Rock" - 'R'
     * - "Scissors" - S
     *
     * @param option The char related to the option
     * 
     * @return Return a string related to the option
     */
    private static String getStringOption(char option) {
    	if (option == 'P') {
    		return "Paper";
    	} else if (option == 'R') {
    		return "Rock";
    	}
    	return "Scissors";    	
    }
}