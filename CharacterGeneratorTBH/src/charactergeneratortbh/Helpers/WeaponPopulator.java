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
    private List<Weapon> Weapons = new ArrayList<>();
    
    public WeaponPopulator(String path) throws FileNotFoundException
    {
        File file = new File(path);
        Scanner read = new Scanner(file);
        String data;
        int lineCounter = 0;
        
        String[] SWD = new String[] {"","",""};
        char CWD = ' ';
        int[] IWD = new int[] {0,0,0,0,0};
        boolean BWD = false;
        
        while(read.hasNextLine())
        {
            data = read.nextLine();
            
            if (data.equals("NEXT"))
            {   
                if (lineCounter == 10)
                    lineCounter = 0;
                else
                    System.err.println("ERROR, keyword NEXT used but data for this weapon is missing");
                
                Weapons.add(new Weapon(SWD[0], SWD[1], IWD[0], IWD[1], IWD[2], IWD[3], IWD[4], BWD, CWD, SWD[2]));
            }
            else if(lineCounter == 0)
            {
                SWD[0] = data;
                lineCounter++;
            }
            else if (lineCounter == 1)
            {
                SWD[1] = data;
                lineCounter++;
            }
            else if (lineCounter == 2)
            {
                IWD[0] = Integer.parseInt(data);
                lineCounter++;
            }
            else if (lineCounter == 3)
            {
                IWD[1] = Integer.parseInt(data);
                lineCounter++;
            }
            else if (lineCounter == 4)
            {
                IWD[2] = Integer.parseInt(data);
                lineCounter++;
            }
            else if (lineCounter == 5)
            {
                IWD[3] = Integer.parseInt(data);
                lineCounter++;
            }
            else if (lineCounter == 6)
            {
                IWD[4] = Integer.parseInt(data);
                lineCounter++;
            }
            else if (lineCounter == 7)
            {
                if (data.equals("Melee"))
                    BWD = false;
                else if (data.equals("Ranged"))
                    BWD = true;
                lineCounter++;
            }
            else if (lineCounter == 8)
            {
                CWD = data.charAt(0);
                lineCounter++;
            }
            else if (lineCounter == 9)
            {
                SWD[2] = data;
                lineCounter++;
            }
            else if (lineCounter == 10)
            {
                System.err.println("ERROR Invalid Data after 8th line of this weapon data, expected NEXT got " + data);
            }
        }
    }
    
    public List<Weapon> getWeapons()
    {
        return Weapons;
    }
}
