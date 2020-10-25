/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file ClassPopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.GameClass;
import charactergeneratortbh.Classes.AbilityScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class ClassPopulator {

    // An array list of Race so that we can dynamically fill the array
    private List<GameClass> Classes = new ArrayList<>();
    
    public ClassPopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the Class text file
        Scanner read = new Scanner(file); // Scanner to take in data from the Class file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        
        String[] SCD = new String[] {"",""}; // String Class Data
        int[] ICD = new int[] {0,0,0}; // Integer Class Data
        int[] SVCD = new int[] {0,0,0}; // Save Throw Class Data
        int[] WCD = new int[] {0,0,0,0}; // Wealth Class Data
        AbilityScore ACD = AbilityScore.WIS; // Modifier Race Data
        List<String> FCD = new ArrayList<>(); // Feature Class Data
        List<String> SKCD = new ArrayList<>(); // Skill Class Data
        List<String> PCD = new ArrayList<>(); // Proficency Class Data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 16 then we know all the race data should be collected reset necessary variables
                if (lineCounter == 16)
                {
                    lineCounter = 0;
                    FCD = new ArrayList<>();
                    SKCD = new ArrayList<>();
                    PCD = new ArrayList<>();
                }
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this weapon is missing");
                
                //Only approach this if no error is thrown, create a new race with collected data and put it in the list
                Classes.add(new GameClass(SCD[0], SCD[1], ICD[0], SKCD, ICD[1], ICD[2], SVCD, FCD, WCD, PCD, ACD));
            }
            //If on the 0th to 1st line fill the String data
            else if(lineCounter == 0 || lineCounter == 1)
            {
                SCD[lineCounter] = data;
                lineCounter++;
            }
            //If on the 2nd line fill the skill data
            else if (lineCounter == 2)
            {
                String[] in = data.split(",");
                Collections.addAll(SKCD, in);
                lineCounter++;
            }
            //if on the 3rd line fill Feature data
            else if (lineCounter == 3)
            {
                String[] in = data.split(",");
                Collections.addAll(FCD, in);
                lineCounter++;
            }
            //if on the 4th line fill the proficency data
            else if (lineCounter == 4)
            {
                String[] in = data.split(",");
                Collections.addAll(PCD, in);
                lineCounter++;
            }
            //If on the 5th-7th line fill the integer data
            else if (lineCounter >= 5 && lineCounter <= 7)
            {
                ICD[lineCounter-5] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 8th-10th line fill the speed data
            else if (lineCounter >= 8 && lineCounter <= 10)
            {
                SVCD[lineCounter-8] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 11th-14th line fill the speed data
            else if (lineCounter >= 11 && lineCounter <= 14)
            {
                WCD[lineCounter-11] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 15th line fill the Ability Score data
            else if (lineCounter == 15)
            {
                if (data.equals("WIS"))
                    ACD = AbilityScore.WIS;
                else if (data.equals("CHA"))
                    ACD = AbilityScore.CHA;
                else if (data.equals("INT"))
                    ACD = AbilityScore.INT;
                else if (data.equals("STR"))
                    ACD = AbilityScore.STR;
                else if (data.equals("CON"))
                    ACD = AbilityScore.CON;
                else if (data.equals("DEX"))
                    ACD = AbilityScore.DEX;
                lineCounter++;
            }
            //If somehow more data exists on the 16th line then throw an error indicating too much data
            else if (lineCounter == 16)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collections of the Class list
    public List<GameClass> getRaces()
    {
        return Classes;
    }
}
