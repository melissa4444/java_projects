class QuartsToGallons {   
public static void main(String[] args)
{  
    final int quartsInGallon = 4; 
    int noOfQuarts = 15;
    int noOfQuartS = 2;
    int noOfQuartSs = 8;
    int noOfGallons;
    int noOfGallonS;
    int noOfGallonSs;
    int quartsNeeded;
    int quartsNeedeD;
    int quartsNeedeDd;
    
    
    
    noOfGallons = noOfQuarts / quartsInGallon;
    quartsNeeded = noOfQuarts % quartsInGallon;

    noOfGallonS = noOfQuartS / quartsInGallon;
    quartsNeedeD = noOfQuartS % quartsInGallon;
    
    noOfGallonSs = noOfQuartSs / quartsInGallon;
    quartsNeedeDd = noOfQuartSs % quartsInGallon;
    
    System.out.println("A job that needs " + noOfQuarts + " quarts requires " +
    noOfGallons + " gallons plus " + quartsNeeded + " quarts.");
    
    System.out.println("A job that needs " + noOfQuartS + " quarts requires " +
    noOfGallonS + " gallons plus " + quartsNeedeD + " quarts.");
    
    System.out.println("A job that needs " + noOfQuartSs + " quarts requires " +
    noOfGallonSs + " gallons plus " + quartsNeedeDd + " quarts.");
    
    
}
}

