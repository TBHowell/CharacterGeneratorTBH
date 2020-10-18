/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Weapon.java
 */
package charactergeneratortbh.Classes;

public class Weapon 
{
    String WN; // Weapon Name
    int THB; // To Hit Bonus
    int DB; // Damage Bonus
    int DD; // Damage Die
    boolean WT; // Weapon Type (Ranged/Melee) 
    char DT; // Damage Type
    String WC; // Weapon Category (Simple/Martial/Natural)
    
    //Defalut Constructor that creates an invalid weapon, should somehow a new weapon be created without data
    public Weapon()
    {
        this.WN = "NO_NAME_GIVEN";
        this.DB = -1;
        this.DD = -1;
        this.WT = false;
        this.DT = 'N';
        this.WC = "NO_WEAPON_CATEGORY_GIVEN";
    }
    
    //Constructor to fill out weapon data
    public Weapon(String wn, int db, int dd, boolean wt, char dt, String wc)
    {
        this.WN = wn;
        this.DB = db;
        this.DD = dd;
        this.WT = wt;
        this.DT = dt;
        this.WC = wc;
        this.THB = 0;
    }
    
    //Add any additional elements to damage bonus, for instance ability score bonus or class bonus
    public void AddDB (int bdb)
    {
        DB += bdb;
    }
    
    //Calculate To Hit Bonus, based off of ability score bonus, base attack bonus, and any other bonuses
    public void CalcTHB (int thb)
    {
        THB = thb;
    }
    
}
