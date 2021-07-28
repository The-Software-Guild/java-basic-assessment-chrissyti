/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assessment;

/**
 *
 * @author christina tillery
 */

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    public static void main(String[] args) {
        
        
        //set boolean to true, so do while loop will run
        boolean repeat = true;
        
        //do-while loop to see id user wants to olay again
        do{
            //declare integers used later
            int maxRounds = 10;
            int minRounds = 1;
            int win = 0;
            int tie = 0;
            int loose = 0;
            
            // Declare and initialize our Scanner
            Scanner sc = new Scanner(System.in);
            //decalre and initialize Random
            Random rng = new Random();

            //See if input is integer or not
            try {
                // ask user how many rounds he'd like to play betw max and min rounds, 
                //specified earlier
                System.out.println("Please enter a number of rounds you would"
                        + "like to play(betw "+minRounds +" - "+maxRounds+ ")");

                //input from user        
                String input = sc.nextLine();
                //convert String to int
                int rounds = Integer.parseInt(input);
                //check if input is betw 1 and 10

                   
                //check if number is betw max and min number
                if (rounds < 1 || rounds > 10) {

                    System.out.println("ERROR:\n Min rounds played = "+ minRounds
                            + "\n Max roudns played = " + maxRounds+ 
                            "\nPlease run again!");
                    exit(0);

                }

                System.out.println("Welcome to Rock, Paper Scissors!"
                        + "\nRounds being palyed: "+ rounds);
                
                //for loop to play as many rounds as user said he wanted to play
                for(int i = 1; i < rounds+1; i++){
                    System.out.println("This is round "+i);


                    System.out.println("please select your choice:\n"
                            + "1: Rock; 2: Paper; 3: Scissor");

                    //ask user for input 1-3
                    input = sc.nextLine();
                    //convert String to int
                    int userChoice = Integer.parseInt(input);
                    
                    //prompt user to enter number 1-3 for choice of rock paper or scisor
                    while(userChoice < 1 || userChoice > 3){

                        System.out.println("ERROR:\n Please select number betw. 1-3.\\"
                                + "to exit please enter 9");

                        System.out.println("please select your choice:\n"
                            + "1: Rock; 2: Paper; 3: Scissor");

                        //ask user for input 1-3
                        input = sc.nextLine();
                        //convert String to int
                        userChoice = Integer.parseInt(input); 

                        if(userChoice == 9){
                            exit(0);
                        }

                    }

                    //generate random number btw 1-3; for Comp choice
                    int randomNumber = rng.nextInt(3) + 1;
                    
                    //array of what is rock, paper or scissor
                    String[] choices = {"Rock", "Paper", "Scissor"};
                    
                    //check who won
                    if(userChoice == randomNumber){

                        System.out.println("\n\nTie\nI chose " + choices[randomNumber-1]
                        + "\nyou chose " + choices[userChoice-1]);  
                        tie++;
                    }else if(userChoice == 1 && randomNumber == 3 || 
                            userChoice == 2 && randomNumber == 1 ||
                            userChoice == 3 && randomNumber == 2 ){

                        System.out.println("\n\nYou WIN! \nI chose " + choices[randomNumber-1]
                        + "\nyou chose " + choices[userChoice-1]);  
                        win++;
                    }else {

                        System.out.println("\n\nYou LOOSE! \nI chose " + choices[randomNumber-1]
                        + "\nyou chose " + choices[userChoice-1]);  
                        loose++;
                    }

                    System.out.println("\n\nYou won : "+win+ " times");
                    System.out.println("You lost: "+loose+ " times");
                    System.out.println("We tied: "+tie+ " times");

                }
                
                //check if user won more rounds than lost, else check if user 
                //lost more rounds than won; else it's a tie
                if(win>loose){
                    
                    System.out.println("\n\nYou are the overall winner, Congratulations!!");
                
                }else if(win<loose){
                    
                    System.out.println("\n\nI won overall!! Better Luck next time :)");
                
                }else{
                    
                    System.out.println("\n\nIt's a tie overall!! :)8 ");
                
                }
                    
                System.out.println("Would you like to play again? Please write y for yes "
                        + "and N for no");
                //ask user for input y
                input = sc.nextLine();
                
                //if user enters y, boolean set to true and program will run again, 
                //else boolean will be set to false and program will terminate 
                if (input.equals("y")){
                    repeat = true;
                }
                else {
                    repeat = false;
                }

            } catch(NumberFormatException ex) {
                System.out.println("ERROR: That was not a Number!");
            }
            
        }while(repeat);

        
    }
    
}
