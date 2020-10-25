/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file WeaponPopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.Weapon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class WeaponPopulator 
{
    // An array list of Weapon so that we can dynamically fill the array
    private List<Weapon> Weapons = new ArrayList<>();
    
    public WeaponPopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the Weapon text file 
        Scanner read = new Scanner(file); // Scanner to take in data from the Weapon file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        
        String[] SWD = new String[] {"","",""}; // String Weapon Data
        char CWD = ' '; // Character Weapon Data
        int[] IWD = new int[] {0,0,0,0,0}; // Integer Weapon Data
        boolean BWD = false; // Boolean Weapon Data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 10 then we know all the weapon data should be collected reset lineCounter
                if (lineCounter == 10)
                    lineCounter = 0;
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this weapon is missing");
                
                //Only approach this if no error is thrown, create a new weapon with collected data and put it in the list
                Weapons.add(new Weapon(SWD[0], SWD[1], IWD[0], IWD[1], IWD[2], IWD[3], IWD[4], BWD, CWD, SWD[2]));
            }
            //If on the 0th to 1st line fill the first two slots of String data
            else if(lineCounter == 0 || lineCounter == 1)
            {
                SWD[lineCounter] = data;
                lineCounter++;
            }
            //If on the 2nd to 6th line fill the integer data
            else if (lineCounter >= 2 && lineCounter <= 6)
            {
                IWD[lineCounter-2] = Integer.parseInt(data);
                lineCounter++;
            }
            //If on the 7th line determine what the boolean data should be
            else if (lineCounter == 7)
            {
                if (data.equals("Melee"))
                    BWD = false;
                else if (data.equals("Ranged"))
                    BWD = true;
                lineCounter++;
            }
            //If on the 8th line determine what the character data should be
            else if (lineCounter == 8)
            {
                CWD = data.charAt(0);
                lineCounter++;
            }
            //If on the 9th line fill the final index of string data
            else if (lineCounter == 9)
            {
                SWD[2] = data;
                lineCounter++;
            }
            //If somehow more data exists on the 10th line then throw an error indicating too much data
            else if (lineCounter == 10)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collections of the Weapon list
    public List<Weapon> getWeapons()
    {
        return Weapons;
    }
}
