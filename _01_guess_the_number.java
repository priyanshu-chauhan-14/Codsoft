//This is the first project : Guess the number game 

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class _01_guess_the_number{
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int num = rand.nextInt(100);
        int key=0, count = 0;
        do{
            System.out.println("Guess the number");
            try{
                key = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Enter a valid input "+e);
            }
            if(key==num){
                System.out.println("You won the number was "+num); 
                System.out.println("You guessed the number in "+count+" chance/chances");break;
            }
            else if (key>num){
                System.out.println("The number is less than "+key); ++count;
            }
            else if(key<num){
                System.out.println("The number is more than "+key);
                ++count;
            }
        }while(true);
        sc.close();
    }
}