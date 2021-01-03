/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Armor.java
 */
package charactergeneratortbh.Classes;

public class Armor 
{
    private String AN; // Armor Name
    private String AD; // Armor Description
    private int ACB; // Armor Class Bonus
    private int SFC; // Spell Failure Chance
    private int MDB; // Max Dex Bonus
    private int MP; // Movement Penalty
    private int AP; // Armor Price
    private String AT; //Armor Type
            
    
    //Defalut Constructor that creates an invalid armor, should somehow a new armor be created without data
    public Armor()
    {
        this.AN = "NO_ARMOR_NAME_GIVEN";
        this.AD = "NO_DESCRIPTION_DATA";
        this.ACB = -1;
        this.SFC = -1;
        this.MDB = -1;
        this.MP = -1;
        this.AP = -1;
        this.AT = "NO_ARMOR_TYPE_GIVEN";
    }
    
    //Constructor to fill out armor data
    public Armor(String an, String ad, int acb, int sfc, int mdb, int mp, int ap, String at)
    {
        this.AN = an;
        this.AD = ad;
        this.ACB = acb;
        this.SFC = sfc;
        this.MDB = mdb;
        this.MP = mp;
        this.AP = ap;
        this.AT = at;
    }
    
    
    //Getter methods
    public String getName()
    {
        return AN;
    }
    
    public String getDesc()
    {
        return AD;
    }
    
    public int getMDB()
    {
        return MDB;
    }
    
    public int getACB()
    {
        return ACB;
    }
    
    //Setter methods
    public void setName(String an)
    {
        AN = an;
    }
    
    public void setDesc(String ad)
    {
        AD = ad;
    }
}
