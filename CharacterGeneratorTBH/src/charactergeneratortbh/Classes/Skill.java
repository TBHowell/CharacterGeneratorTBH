/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Skill.java
 */
package charactergeneratortbh.Classes;

public class Skill 
{
    private String SN; // Skill Name
    private boolean CS; // Class Skill
    private AbilityScore AS; // Ability Score associated with skill
    private int MM; // Miscillaneous Modifiers
    private int R; // Skill Ranks
    private int TSM; // Total Skill Modifier
    
    //Defalut Constructor that creates an invalid skill, should somehow a new skill be created without data
    public Skill()
    {
        this.SN = "NO_SKILL_NAME_GIVEN";
        this.CS = false;
        this.AS = AbilityScore.WIS;
        this.MM = -1;
        this.R = -1;
        this.TSM = -1;
    }
    
    //Constructor to fill out skill data
    public Skill(String sn, AbilityScore as)
    {
        this.SN = sn;
        this.AS = as;
        this.CS = false;
        this.MM = 0;
        this.R = 0;
        this.TSM = 0;
    }
    
    //Increases Ranks in the skill
    public void AddRank()
    {
        R++;
    }
    
    //Sets the misc modifier to a value that's given
    public void setMM(int mm)
    {
        MM = mm;
    }
    
    //Calculates Total Skill Modifier by adding the misc modifier, and then adding 2 plus the skill ranks if it's a class skill, otherwise just adds the skill ranks
    public void CalcTSM()
    {
        TSM += MM;
        
        if(CS)
        {           
            if(R >= 1)
            {
                TSM += (2+R);
            }
        }
        else
        {
            TSM += R;
        }
    }
    
    //Getter methods
    public String getName()
    {
        return SN;
    }
    
    public int getR()
    {
        return R;
    }
    
    //Setter methods
    public void setR(int r)
    {
        R = r;
    }
}
