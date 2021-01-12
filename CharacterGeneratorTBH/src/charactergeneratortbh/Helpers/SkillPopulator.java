/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file SkillPopulator.java
 */
package charactergeneratortbh.Helpers;

import charactergeneratortbh.Classes.AbilityScore;
import charactergeneratortbh.Classes.Skill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillPopulator 
{
// An array list of Skill so that we can dynamically fill the array
    private List<Skill> Skills = new ArrayList<>();
    private List<String> SkillNames = new ArrayList<>();
    
    public SkillPopulator(String path) throws FileNotFoundException
    {
        File file = new File(path); // File object with the filepath leading to the skill text file 
        Scanner read = new Scanner(file); // Scanner to take in data from the skill file
        String data; // String to contain the current line of data we're getting from the file
        int lineCounter = 0; // lineCounter to track what kind of data we're looking at
        AbilityScore[] AS = AbilityScore.values(); // Array to hold the different values of AbilityScores
        
        String NSD = ""; // Skill Name Data
        AbilityScore ASD = AS[1]; // Skill Ability Score Data
        
        //Starts streaming in data while data still exists in the file
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            //If keyword NEXT is used then check lineCounter
            if (data.equals("NEXT"))
            {   
                //If line counter indicates 2 then we know all the skill data should be collected reset lineCounter
                if (lineCounter == 2)
                    lineCounter = 0;
                //Otherwise throw an error indicating not all the necessary data has been collected
                else
                    System.err.println("ERROR, keyword NEXT used but data for this skill is missing");
                
                //Only approach this if no error is thrown, create a new skill with collected data and put it in the list
                Skills.add(new Skill(NSD, ASD));
                SkillNames.add(NSD);
                
            }
            //If on the 0th line fill the name data
            else if(lineCounter == 0)
            {
                NSD = data;
                lineCounter++;
            }
            //If on the 1st line fill ability score data
            else if (lineCounter == 1)
            {
                ASD = AS[Integer.parseInt(data)];
                lineCounter++;
            }
            //If somehow more data exists on the 2nd line then throw an error indicating too much data
            else if (lineCounter == 2)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    //Getter function to allow for the collection of the Skill list
    public List<Skill> getSkills()
    {
        return Skills;
    }

    public List<String> getSkillNames()
    {
        return SkillNames;
    }
}
