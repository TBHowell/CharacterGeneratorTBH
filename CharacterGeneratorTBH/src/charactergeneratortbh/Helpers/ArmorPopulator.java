/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file WeaponPopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.Armor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmorPopulator {

    // An array list of Race so that we can dynamically fill the array
    private List<Armor> Armor = new ArrayList<>();
    
    public ArmorPopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the Armor text file 
        Scanner read = new Scanner(file); // Scanner to take in data from the Armor file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        
        String[] SAD = new String[] {"","",""}; // String Weapon Data
        int[] IAD = new int[] {0,0,0,0,0}; // Integer Weapon Data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 10 then we know all the race data should be collected reset lineCounter
                if (lineCounter == 8)
                    lineCounter = 0;
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this weapon is missing");
                
                //Only approach this if no error is thrown, create a new weapon with collected data and put it in the list
                Armor.add(new Armor(SAD[0], SAD[1], IAD[0], IAD[1], IAD[2], IAD[3], IAD[4], SAD[2]));
            }
            //If on the 0th to 1st line fill the first two slots of String data
            else if(lineCounter == 0 || lineCounter == 1)
            {
                SAD[lineCounter] = data;
                lineCounter++;
            }
            //If on the 2nd to 6th line fill the integer data
            else if (lineCounter >= 2 && lineCounter <= 6)
            {
                IAD[lineCounter-2] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 7th line fill final index of String data
            else if (lineCounter == 7)
            {
                SAD[2] = data;
                lineCounter++;
            }
            //If somehow more data exists on the 10th line then throw an error indicating too much data
            else if (lineCounter == 8)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collections of the Weapon list
    public List<Armor> getWeapons()
    {
        return Armor;
    }
}
