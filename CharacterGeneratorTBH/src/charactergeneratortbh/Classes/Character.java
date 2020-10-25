/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Armor.java
 */

package charactergeneratortbh.Classes;

import java.util.Random;

public class Character {
    Random Roller = new Random(); // Dice roller for determining certain stats
    Feature[] CF; // Character Features
    Skill[] CS; // Character Skills
    int[] AS; // Ability Scores
    int[] AM; // Ability Modifiers
    Race CR; // Character Race
    GameClass CC; // Character Class
    Armor CA; // Character Armor
    Weapon[] CW; // Character Weapons
    int[] CM; // Character Money
    int CH; // Character Health
    int[] CCS; // Character Combat Stats
    int[] CDS; // Character Defensive Stats
    String[] CD; // Character Details
    
    // Creates a new character with the character and player name specified in the start of creation
    public Character(String cn, String pn)
    {
        CD[0] = cn;
        CD[1] = pn;
    }
    
    // Creates a new character with only the player name specified in the start of creation
    public Character(String pn)
    {
        CD[0] = "Character Name Here";
        CD[1] = pn;
    }
    
    // Banks the initial ability scores the player determines on the second part of creation
    public void BankAbilityScores(int str, int dex, int con, int in, int wis, int cha)
    {
        AS = new int[] {str,dex,con,in,wis,cha};
    }
    
    // Adds Character Race on the third part of creation
    public void AddRace(Race R, int H, int A)
    {
        CR = R;
    }
    
    //Adds Character Class on the fourth part of creation
    public void AddClass(GameClass C)
    {
        CC = C;
        CH = CC.HD;
        CalcCombat();
        CF = AddFeatures(new String[] {"TOFIX"});
        CM = C.W;
        
    }
    
    //Adds Ranks to the charcters skills on the fifth part of creation
    public void AddSkillRanks(String[] sn)
    {
        int ri = 0;
        
        for(int i = 0; i < CS.length; i++)
        {
            if(CS[i].SN == sn[ri])
            {
                CS[i].R += 1;
                ri++;
            }
        }
    }
    
    //Fifth part of creation is adding an additional feature, this will be handled by the AddFeature method
    
    //For the sixth part of creation armor and weapons will be added, this will be handled in the main
    
    //Adds character details for the final part of creation
    public void AddDetails()
    {
        //TODO: Handle adding final details to the character
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
        int DB = GetACDexBonus(CA.MDB);
        CDS[0] = 10 + CR.GetSizeMod(true) + CA.ACB + DB;
        CDS[1] = 10 + CR.GetSizeMod(true) + DB;
        CDS[2] = 10 + CR.GetSizeMod(true) + CA.ACB;
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
    public Feature[] AddFeatures(String[] add)
    {
        Feature[] NF = new Feature[] {};
        
        //TODO change from an array to an array list and then add features to the character features should the feature name match the string in included array
        return NF;
    }
}
