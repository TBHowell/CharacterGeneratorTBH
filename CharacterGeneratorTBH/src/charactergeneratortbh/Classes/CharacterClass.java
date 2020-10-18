/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file CharacterClass.java
 */
package charactergeneratortbh.Classes;

public class CharacterClass 
{
    String ClassName;
    String HD;
    String[] Skills;
    int SkillRanks;
    int BAB;
    int[] Saves;
    String[] Feats;
    int[] Wlth;
    String[] Prof;
    
    public CharacterClass(String name, String hd, String[] skills, int sr, int bab, int[] saves, String[] feats, int[] wlth, String[] prof) {
        this.ClassName = name;
        this.HD = hd;
        this.Skills = skills;
        this.SkillRanks = sr;
        this.BAB = bab;
        this.Saves = saves;
        this.Feats = feats;
        this.Wlth = wlth;
        this.Prof = prof; 
    }
}
