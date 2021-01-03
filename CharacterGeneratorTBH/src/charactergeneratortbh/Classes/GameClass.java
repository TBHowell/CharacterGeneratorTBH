/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file CharacterClass.java
 */
package charactergeneratortbh.Classes;

import java.util.List;
import java.util.ArrayList;

public class GameClass 
{
    private String CN; // Class Name
    private String CD; // Class Description
    private int HD; // Class Hit Die
    private List<String> SK = new ArrayList<>(); // Class Skills
    private int SR; // Skill Ranks
    private int BAB; // Base Attack Bonus
    private int[] SV; // Saving Throw Bonuses
    private List<String> F = new ArrayList<>(); // Class Features
    private int[] W; // Wealth
    private List<String> P = new ArrayList<>(); // Weapon and Armor Proficiencies
    private AbilityScore AB; // Weapon Ability Score Modifier
    
    //Default constructor that creates an invalid class, should somehow a new class be created without data
    public GameClass()
    {
        this.CN = "NO_NAME_GIVEN";
        this.CD = "NO_DESCRIPTION_DATA";
        this.HD = -1;
        this.SK.add("NO_SKILLS_GIVEN");
        this.SR = -1;
        this.BAB = -1;
        this.SV = new int[]{-1,-1,-1};
        this.F.add("NO_FEATURE_DATA");
        this.W = new int[]{-1,-1,-1,-1};
        this.P.add("NO_WEAPON_PROFICIENCIES_GIVEN");
        this.AB = AbilityScore.WIS;
    }
    
    //Constructor to fill out class data
    public GameClass(String cn, String cd, int hd, List<String> sk, int sr, int bab, int[] sv, List<String> f, int[] w, List<String> p, AbilityScore ab) {
        this.CN = cn;
        this.CD = cd;
        this.HD = hd;
        this.SK = sk;
        this.SR = sr;
        this.BAB = bab;
        this.SV = sv;
        this.F = f;
        this.W = w;
        this.P = p; 
        this.AB = ab;
    }
    
    //Getter
    public String getName()
    {
        return CN;
    }
    
    public String getDesc()
    {
        return CD;
    }
    
    public int getHD()
    {
        return HD;
    }
    
    public int getSR()
    {
        return SR;
    }
    
    public List<String> getF()
    {
        return F;
    }
    
    public int[] getW()
    {
        return W;
    }
    
    public int getBAB()
    {
        return BAB;
    }
    
    public AbilityScore getAB()
    {
        return AB;
    }
    
    public int[] getSV()
    {
        return SV;
    }
}
