/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file FeaturePopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.Feature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class FeaturePopulator 
{
// An array list of Feature so that we can dynamically fill the array
    private List<Feature> Features = new ArrayList<>();
    
    public FeaturePopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the feature text file 
        Scanner read = new Scanner(file); // Scanner to take in data from the feature file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        
        String[] SFD = new String[] {"",""}; // Feature String Data
        boolean[] BFD = new boolean[] {false,false,false}; // Feature Boolean Data
        List<String> MFD = new ArrayList<>(); // Feature Modified Value Data
        int IFD = 0; // Feature integer data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 7 then we know all the feature data should be collected reset lineCounter
                if (lineCounter == 7)
                {
                    MFD = new ArrayList<>();
                    lineCounter = 0;
                }
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this feature is missing");
                
                //Only approach this if no error is thrown, create a new feature with collected data and put it in the list
                Features.add(new Feature(SFD[0],SFD[1],BFD[0],BFD[1],BFD[2],MFD,IFD));
            }
            //If on the 0th-1st line fill the string data
            else if(lineCounter == 0 || lineCounter == 1)
            {
                SFD[lineCounter] = data;
                lineCounter++;
            }
            //If on the 2nd-4th line fill boolean data
            else if (lineCounter >= 2 && lineCounter <= 4)
            {
                if (data.equals("yes"))
                    BFD[lineCounter-2] = true;
                else if (data.equals("no"))
                    BFD[lineCounter-2] = false;
                else
                    System.err.println("ERROR, incorrect data used, looking for yes/no got " + data);
                lineCounter++;
            }
            //If on the 5th line fill the modified value data
            else if (lineCounter == 5)
            {
                Collections.addAll(MFD, data.split(","));
                lineCounter++;
            }
            //if on the 6th line fill the integer data
            else if (lineCounter == 6)
            {
                IFD = Integer.parseInt(data);
                lineCounter++;
            }
            //If somehow more data exists on the 7th line then throw an error indicating too much data
            else if (lineCounter == 7)
            {
                System.err.println("ERROR Invalid Data after 8th line of this feature data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collection of the Feature list
    public List<Feature> getFeatures()
    {
        return Features;
    }        
}
