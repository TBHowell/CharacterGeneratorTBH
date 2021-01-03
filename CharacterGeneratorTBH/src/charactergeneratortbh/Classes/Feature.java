/**
 * @author Trent Howell (howellt@spu.edu) TBHowell on Github
 * @file Feature.java
 */
package charactergeneratortbh.Classes;

import java.util.ArrayList;
import java.util.List;

public class Feature 
{
    private String N; // Feature Name
    private String D; // Feature Description
    private boolean MV; // Modifies a Value
    private boolean MS; // Modifies a Skill
    private boolean MA; // Modifies another Attribute
    private List<String> MVN = new ArrayList<>(); // Modified Value(s) Name
    private int M; // Modifier
    
    //Defalut Constructor that creates an invalid feature, should somehow a new feature be created without data
    public Feature()
    {
        this.N = "NO_FEATURE_NAME_GIVEN";
        this.D = "NO_DESCRIPTION_GIVEN";
        this.MV = false;
        this.MS = false;
        this.MA = false;
        this.MVN.add("NO_MODIFIED_VALUE_GIVEN");
        this.M = -1;
    }
    
    //Constructor to fill out feature data
    public Feature(String n, String d, boolean mv, boolean ms, boolean ma, List<String> mvn, int m)
    {
        this.N = n;
        this.D = d;
        this.MV = mv;
        this.MS = ms;
        this.MA = ma;
        this.MVN = mvn;
        this.M = m;
    }
    
    //Getter methods
    public String getName()
    {
        return N;
    }
    
    public String getDesc()
    {
        return D;
    }
    
    public boolean getMV()
    {
        return MV;
    }
    
    public boolean getMS()
    {
        return MS;
    }
    
    public boolean getMA()
    {
        return MA;
    }
}
