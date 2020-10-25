/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file WeaponPopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class RacePopulator {
    
    // An array list of Race so that we can dynamically fill the array
    private List<Race> Races = new ArrayList<>();
    
    public RacePopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the Race text file
        Scanner read = new Scanner(file); // Scanner to take in data from the Race file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        
        String[] SRD = new String[] {"","","",""}; // String Race Data
        int SPRD = 0; // Speed Race Data
        int[] ARD = new int[] {0,0,0,0}; // Age Race Data
        int[] HRD = new int[] {0,0,0,0}; // Height Race Data
        int[] MRD = new int[] {0,0,0,0,0,0}; // Modifier Race Data
        List<String> FRD = new ArrayList<>(); // Feature Race Data
        List<String> LRD = new ArrayList<>(); // Language Race Data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 21 then we know all the race data should be collected reset necessary variables
                if (lineCounter == 21)
                {
                    lineCounter = 0;
                    FRD = new ArrayList<>();
                    LRD = new ArrayList<>();
                }
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this weapon is missing");
                
                //Only approach this if no error is thrown, create a new race with collected data and put it in the list
                Races.add(new Race(SRD[0], SRD[1], ARD, HRD, SPRD, SRD[2], LRD, MRD, FRD, SRD[3]));
            }
            //If on the 0th to 1st line fill the first two slots of String data
            else if(lineCounter == 0 || lineCounter == 1)
            {
                SRD[lineCounter] = data;
                lineCounter++;
            }
            //If on the 2nd to 5th line fill the age data
            else if (lineCounter >= 2 && lineCounter <= 5)
            {
                ARD[lineCounter-2] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 6th-9th line fill the Height data
            else if (lineCounter >= 6 && lineCounter <= 9)
            {
                HRD[lineCounter-6] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 10th line fill the speed data
            else if (lineCounter == 10)
            {
                SPRD = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 11th line fill the 3rd slot of String data
            else if (lineCounter == 11)
            {
                SRD[2] = data;
                lineCounter++;
            }
            //If on the 12th line fill in the Language data
            else if (lineCounter == 12)
            {
                //Get an array from data by splitting strings at each existing comma in data as new indicies
                String[] in = data.split(",");
                Collections.addAll(LRD, in);
                lineCounter++;
            }
            //If on the 13-18th line fill Ability modifier data
            else if (lineCounter >= 13 && lineCounter <= 18)
            {
                MRD[lineCounter-13] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 19th line fill in Feature data
            else if (lineCounter == 19)
            {
                //Get an array from data by splitting strings at each existing comma in data as new indicies
                String[] in = data.split(",");
                Collections.addAll(FRD, in);
                lineCounter++;
            }
            //If on the 20th line fill in the final index of String data
            else if (lineCounter == 20)
            {
                SRD[3] = data;
                lineCounter++;
            }
            //If somehow more data exists on the 21st line then throw an error indicating too much data
            else if (lineCounter == 21)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collections of the Race list
    public List<Race> getRaces()
    {
        return Races;
    }
}
