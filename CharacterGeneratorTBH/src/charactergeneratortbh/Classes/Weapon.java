/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Weapon.java
 */
package charactergeneratortbh.Classes;

public class Weapon 
{
    private String WN; // Weapon Name
    private String WD; // Weapon Description
    private int THB; // To Hit Bonus
    private int DB; // Damage Bonus
    private int DD; // Damage Die
    private int WR; // Weapon Range (if applicable)
    private int WA; // Weapon Ammo (if applicable)
    private int WP; // Weapon Price in Gold
    private boolean WT; // Weapon Type (Ranged/Melee) 
    private char DT; // Damage Type
    private String WC; // Weapon Category (Simple/Martial/Natural)
    
    //Defalut Constructor that creates an invalid weapon, should somehow a new weapon be created without data
    public Weapon()
    {
        this.WN = "NO_NAME_GIVEN";
        this.DB = -1;
        this.DD = -1;
        this.WR = -1;
        this.WA = -1;
        this.WP = -1;
        this.WT = false;
        this.DT = 'N';
        this.WC = "NO_WEAPON_CATEGORY_GIVEN";
        this.WD = "NO_WEAPON_DESCRIPTION_GIVEN";
    }
    
    //Constructor to fill out weapon data
    public Weapon(String wn, String wd, int db, int dd, int wr, int wa, int wp, boolean wt, char dt, String wc)
    {
        this.WN = wn;
        this.WD = wd;
        this.DB = db;
        this.DD = dd;
        this.WR = wr;
        this.WA = wa;
        this.WP = wp;
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
    
    //Getter methods
    public String getName()
    {
        return WN;
    }
    
    public String getDesc()
    {
        return WD;
    }
    
    public int getPrice()
    {
        return WP;
    }
    
}
