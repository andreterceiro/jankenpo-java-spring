package com.example.jankenpo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        String userOption = Main.receiveUserOption();

        Jankenpo.evaluateAndShowResult(userOption);
    }

    /**
     * Receives the user option
     * 
     * @return String
     */
    private static String receiveUserOption() {
    	Scanner scanner = new Scanner(System.in);
    	String option = "";
    	
    	while ((!option.equals("R")) && (!option.equals("P")) && (!option.equals("S")) ) {
        	System.out.print("Please insert 'P' for 'paper' or 'R' for 'rock' or 'S' for 'scissors': ");
        	option = scanner.nextLine();
    	}
    	scanner.close();
    	
    	return option;
    }

}