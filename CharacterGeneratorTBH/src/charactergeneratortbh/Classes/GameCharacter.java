/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Armor.java
 */

package charactergeneratortbh.Classes;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GameCharacter 
{
    Random Roller = new Random(); // Dice roller for determining certain stats
    public List<Feature> CF = new ArrayList<>(); // Character Features
    public Skill[] CS; // Character Skills
    public int[] AS; // Ability Scores
    public int[] AM; // Ability Modifiers
    public Race CR; // Character Race
    public GameClass CC; // Character Class
    public Armor[] CA; // Character Armor
    public List<Weapon> CW; // Character Weapons
    public int[] CM; // Character Money
    public int CH; // Character Health
    public int[] CCS; // Character Combat Stats
    public int[] CDS; // Character Defensive Stats
    public String[] CD; // Character Details
    
    // Creates a new character with the character and player name specified in the start of creation
    public GameCharacter(String cn, String pn)
    {
        CD[0] = cn;
        CD[1] = pn;
    }
    
    // Creates a new character with only the player name specified in the start of creation
    public GameCharacter(String pn)
    {
        CD[0] = "Character Name Here";
        CD[1] = pn;
    }
    
    // Applies any modification of skill or other attribute from the Feature
    public void ApplyFeature(Feature F)
    {
        if(F.MV)
        {
            if(F.MS)
            {
                //TODO: Add logic to find skill modified and modify it
            }
            else if (F.MA)
            {
                //TODO: Add logic to find attribute and modify it
            }
        }
    }
    
    // Handler to calculate the characters combat modifiers
    public void CalcCombat()
    {
        CCS[0] = CC.BAB;
        CCS[1] = AM[0] + CC.BAB;
        CCS[2] = 10 + CC.BAB + AM[0] + AM[1] + CR.GetSizeMod(true);
        CCS[3] = CC.BAB + AM[CC.AB.ordinal()];
        CCS[4] = CC.BAB + AM[1];
    }
    
    // Handler to calculate the characters combat modifiers
    public void CalcDefense()
    {
        int DB = GetACDexBonus(CA[0].MDB);
        if (GetACDexBonus(CA[1].MDB) > DB)
            DB = GetACDexBonus(CA[1].MDB);
        
        CDS[0] = 10 + CR.GetSizeMod(true) + CA[0].ACB + CA[1].ACB + DB;
        CDS[1] = 10 + CR.GetSizeMod(true) + DB;
        CDS[2] = 10 + CR.GetSizeMod(true) + CA[0].ACB + CA[1].ACB;
        CDS[3] = AM[2] + CC.SV[0];
        CDS[4] = AM[1] + CC.SV[1];
        CDS[5] = AM[4] + CC.SV[2];
    }
    
    // Handler to determine what dexterity bonus to grant for Armor Class calculations
    public int GetACDexBonus(int max)
    {
        if (AM[1] > max)
            return max;
        else
            return AM[1];
    }
    
    // Handler to add new features to the character's feature list
    public Feature[] AddFeatures(List<String> add)
    {
        Feature[] NF = new Feature[] {};
        
        //TODO change from an array to an array list and then add features to the character features should the feature name match the string in included array
        return NF;
    }
}
