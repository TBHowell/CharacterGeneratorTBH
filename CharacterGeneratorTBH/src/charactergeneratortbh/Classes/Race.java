/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file CharacterRace.java
 */
package charactergeneratortbh.Classes;

import java.util.Random; 

public class Race 
{
    Random Roller = new Random(); // A random object to do our dice rolls
    String RN; // Race Name
    String RD; // Race Description
    int[] A; /* Age Data
                For this array 0 index is starting age, 1 is which die to roll
                for additional years, 2 is how many of those dice to roll, 3 is
                the year multiplyer to apply to the dice roll */
    int [] H; /* Height Data
                 For this array 0 index is starting height, 1 is which die to
                 roll for additional inches, 2 is how many of those dice to 
                roll, 3 is the inches multiplyer to apply to the dice roll.
            */
    int SP; // Speed
    String SZ; // Size
    String[] L; /* Languages
                   For this array 0 to LKL are already known languages, every
                   index after is possible languages to choose from if the 
                   character's intelligence is high enough */
    int[] M; /* Ability Modifiers 
                For this array 0 index is STR, 1 is DEX, 2 is CON, 3 is INT,
                4 is WIS, 5 is CHA */
    Feature[] F; // Race Features
    String V; // Vision Type
    
    //Defalut Constructor that creates an invalid race, should somehow a new race be created without data
    public Race()
    {
        this.RN = "NO_RACE_NAME_DATA";
        this.RD = "NO_RACE_DESCRIPTION_DATA";
        this.A = new int[]{-1,-1,-1,-1};
        this.H = new int[]{-1,-1,-1,-1};
        this.SP = -1;
        this.SZ = "NO_SIZE_DATA";
        this.L = new String[]{"NO_LANGUAGE_DATA"};
        this.M = new int[]{-1,-1,-1,-1,-1,-1};
        this.F = new Feature[]{};
        this.V = "NO_VISION_DATA";           
    }
    
    //Constructor to fill out race data
    public Race(String rn, String rd, int[] a, int[] h, int sp, String sz, String[] l, int[] m, Feature[] f, String v)
    {
        this.RN = rn;
        this.RD = rd;
        this.A = a;
        this.H = h;
        this.SP = sp;
        this.SZ = sz;
        this.L = l;
        this.M = m;
        this.F = f;
        this.V = v;           
    }
    
    //This "Rolls" the dice and calculates the character age based off of the data from the A array
    public int CalcAge()
    {
        //Sets starting age and creates an int to track additional added age rolled
        int Age = A[0];
        int Additional = 0;
        
        //Rolls the dice specified number of times and adds the values up 
        for(int R = 0; R > A[2]; R++)
        {
            Additional += Roller.nextInt(A[1]);
        }
        
        //Adds the additional age (multiplied by the age multiplier to starting age)and returns
        Age += (A[3] * Additional);
        return Age;
    }
    
    //This "Rolls" the dice and calculates the character height based off of the data from the H array
    public int CalcHeight()
    {
        //Sets starting height and creates an int to track additional added height rolled
        int Height = H[0];
        int Additional = 0;
        
        //Rolls the dice specified number of times and adds the values up 
        for(int R = 0; R > H[2]; R++)
        {
            Additional += Roller.nextInt(H[1]);
        }
        
        //Adds the additional height (multiplied by the height multiplier) to starting height and returns
        Height += (A[3] * Additional);
        return Height;
    }
    
    //This gets the size modifier of the race, takes in wether being small is good or bad for this modifier
    public int GetSizeMod(boolean GS)
    {
        return 0;
    }
}
