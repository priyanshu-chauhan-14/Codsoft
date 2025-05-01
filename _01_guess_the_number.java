//This is the first project : Guess the number game 

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class _01_guess_the_number{
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int num = rand.nextInt(100)+1;
        int key=0, count = 0;
        while(true){
            System.out.println("Guess the number from 1 - 100");
            try{
                    key = sc.nextInt();
                    count++;
                if(key==num){
                    System.out.println("You won ! The number was "+num); 
                    System.out.println("You guessed the number in "+count+" chance/chances");break;
                }
                else if (key>num){
                    System.out.println("The number is less than "+key);
                }
                else if(key<num){
                    System.out.println("The number is more than "+key);
                }
            }
            catch(InputMismatchException e){
                System.out.println("Enter a valid input "+e);
            }
        }
        sc.close();
    }
}
