/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file CharacterClass.java
 */
package charactergeneratortbh.Classes;

public class GameClass 
{
    String CN; // Class Name
    String CD; // Class Description
    int HD; // Class Hit Die
    String[] SK; // Class Skills
    int SR; // Skill Ranks
    int BAB; // Base Attack Bonus
    int[] SV; // Saving Throw Bonuses
    Feature[] F; // Class Features
    int[] W; // Wealth
    String[] P; // Weapon and Armor Proficiencies
    AbilityScore AB; // Weapon Ability Score Modifier
    
    //Default constructor that creates an invalid class, should somehow a new class be created without data
    public GameClass()
    {
        this.CN = "NO_NAME_GIVEN";
        this.CD = "NO_DESCRIPTION_DATA";
        this.HD = -1;
        this.SK = new String[]{"NO_SKILLS_GIVEN"};
        this.SR = -1;
        this.BAB = -1;
        this.SV = new int[]{-1,-1,-1};
        this.F = new Feature[] {new Feature()};
        this.W = new int[]{-1,-1,-1,-1};
        this.P = new String[]{"NO_WEAPON_PROFICIENCIES_GIVEN"};
        this.AB = AbilityScore.WIS;
    }
    
    //Constructor to fill out class data
    public GameClass(String cn, String cd, int hd, String[] sk, int sr, int bab, int[] sv, Feature[] f, int[] w, String[] p, AbilityScore ab) {
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
}
