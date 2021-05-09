import java.util.*;
class QuartsToGallonssInteractive 
{   
public static void main(String[] args)
    {  
   final int quartsInGallon = 4;
   int noOfQuarts;
   int noOfGallons;
   int quartsNeeded;

   Scanner console  = new Scanner(System.in);
   System.out.print("Enter quarts needed >> ");
   noOfQuarts = console.nextInt();

   noOfGallons = noOfQuarts / quartsInGallon;
   quartsNeeded = noOfQuarts % quartsInGallon;
   System.out.println("A job that needs " + noOfQuarts + " quarts requires " + noOfGallons +
   " gallons plus " + quartsNeeded + " quarts.");
}
}