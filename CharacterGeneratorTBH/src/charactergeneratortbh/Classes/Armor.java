/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Armor.java
 */
package charactergeneratortbh.Classes;

public class Armor 
{
    String AN; // Armor Name
    int ACB; // Armor Class Bonus
    int SFC; // Spell Failure Chance
    int MDB; // Max Dex Bonus
    int MP; // Movement Penalty
    String AT; //Armor Type
    
    //Defalut Constructor that creates an invalid armor, should somehow a new armor be created without data
    public Armor()
    {
        this.AN = "NO_ARMOR_NAME_GIVEN";
        this.ACB = -1;
        this.SFC = -1;
        this.MDB = -1;
        this.MP = -1;
        this.AT = "NO_ARMOR_TYPE_GIVEN";
    }
    
    //Constructor to fill out armor data
    public Armor(String an, int acb, int sfc, int mdb, int mp, String at)
    {
        this.AN = an;
        this.ACB = acb;
        this.SFC = sfc;
        this.MDB = mdb;
        this.AT = at;
    }
}
