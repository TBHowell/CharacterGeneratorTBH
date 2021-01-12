/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergeneratortbh.Control;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

import charactergeneratortbh.Classes.*;
import charactergeneratortbh.Helpers.*;
import charactergeneratortbh.GUI.*;

public class Controller 
{
    String path = System.getProperty("user.dir") + "//resources";
    List<Skill> OurSkills = new ArrayList<>();
    List<Feature> OurFeatures = new ArrayList<>();
    List<Weapon> OurWeapons = new ArrayList<>();
    List<Armor> OurArmor = new ArrayList<>();
    List<Race> OurRaces = new ArrayList<>();
    List<GameClass> OurClasses = new ArrayList<>();
    public GameCharacter OurCharacter;
    
    public String WeaponList;
    public String[] Races;
    public String[] Classes;
    private List<String> Skills = new ArrayList<>();
    public String[] Features;
    public String[] Weapons;
    public String[] Armors;
    
    int[] AS;
    
    public Controller()
    {
        MainGUI GUI = new MainGUI(this);
        WeaponList = "Weapons: \n";
        
        try 
        {
            SkillPopulator SP = new SkillPopulator(path+"//Skills.txt");
            FeaturePopulator FP = new FeaturePopulator(path+"//Features.txt");
            WeaponPopulator WP = new WeaponPopulator(path+"//Weapons.txt");
            ArmorPopulator AP = new ArmorPopulator(path+"//Armor.txt");
            RacePopulator RP = new RacePopulator(path+"//Races.txt");
            ClassPopulator CP = new ClassPopulator(path +"//Classes.txt");
            OurSkills = SP.getSkills();
            Skills = SP.getSkillNames();
            OurFeatures = FP.getFeatures();
            OurWeapons = WP.getWeapons();
            OurArmor = AP.getArmor();
            OurRaces = RP.getRaces();
            OurClasses = CP.getClasses();
        }
        catch(FileNotFoundException ex)
        {
            GUI.ErrorMessage(ex.getMessage());
            System.out.println("ERROR FileNotFound");
        }
        
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < OurRaces.size(); i++)
        {
            temp.add(OurRaces.get(i).getName());
        }
        Races = new String[temp.size()];
        Races = temp.toArray(Races);
        temp = new ArrayList<>();
        for(int i = 0; i < OurClasses.size(); i++)
        {
            temp.add(OurClasses.get(i).getName());
        }
        Classes = new String[temp.size()];
        Classes = temp.toArray(Classes);
        temp = new ArrayList<>();
        for(int i = 0; i <OurFeatures.size(); i++)
        {
            temp.add(OurFeatures.get(i).getName());
        }
        Features = new String[temp.size()];
        Features = temp.toArray(Features);
        temp = new ArrayList<>();
        for(int i = 0; i < OurWeapons.size(); i++)
        {
            temp.add(OurWeapons.get(i).getName());
        }
        Weapons = new String[temp.size()];
        Weapons = temp.toArray(Weapons);
        temp = new ArrayList<>();
        for(int i = 0; i < OurArmor.size(); i++)
        {
            temp.add(OurArmor.get(i).getName());
        }
        Armors = new String[temp.size()];
        Armors = temp.toArray(Armors);
    }
    
    public void StartCharacter(String pn, String cn)
    {
        if (cn.equals(""))
            OurCharacter = new GameCharacter(pn);
        else
            OurCharacter = new GameCharacter(cn,pn);
    }
    
    public void FirstStage(int str, int dex, int con, int in, int wis, int cha)
    {
        OurCharacter.AS = new int[] {str,dex,con,in,wis,cha};
    }
    
    public void SecondStage(int Ri, int A, int H)
    {
        Race R = OurRaces.get(Ri);
        OurCharacter.CR = R;
        if (A >= 0)
            OurCharacter.CD[2] = A + "";
        else
            OurCharacter.CD[2] = R.CalcAge() + "";
        
        if (H >= 0)
        {
           int feet = H/12;
           int inches = H%12;
           OurCharacter.CD[3] = feet + "'" + inches + "\"";
        }
        else
        {
            int total = R.CalcHeight();
            int feet = total/12;
            int inches = H%12;
            OurCharacter.CD[3] = feet + "'" + inches + "\"";
        }
        
        AddFeatures(R.getF());
    }
    
    public void ThirdStage(int Ci)
    {
        GameClass C = OurClasses.get(Ci);
        OurCharacter.CC = C;
        OurCharacter.CH = C.getHD();
        OurCharacter.CalcCombat();
        AddFeatures(C.getF());
        OurCharacter.CM = C.getW();
    }
    
    public void FourthStage(List<String> sn)
    {
        int ri = 0;
        
        for(int i = 0; i < OurCharacter.CS.length; i++)
        {
            if(OurCharacter.CS[i].getName().equals(sn.get(ri)))
            {
                int r = OurCharacter.CS[i].getR();
                OurCharacter.CS[i].setR(r + 1);
                ri++;
            }
        }
    }
    
    public void FifthStage(Feature F)
    {
        OurCharacter.CF.add(F);
    }
    
    public void SixthStage(List<Weapon> W, Armor[] A)
    {
        OurCharacter.CW = W;
        OurCharacter.CA = A;
        OurCharacter.CalcDefense();
    }
    
    public void SeventhStage(String[] SD)
    {
        //TODO get final character details
        for(int i = 0; i < OurCharacter.CF.size(); i++)
        {
            OurCharacter.ApplyFeature(OurCharacter.CF.get(i));
        }
        
    }
    
    public void AddFeatures(List<String> add)
    {
       List<Feature> NF = new ArrayList<>();
       int FI = 0;
       
       for(int i = 0; i < add.size(); i++)
       {
           if(OurFeatures.get(FI).getName().equals(add.get(i)))
               NF.add(OurFeatures.get(FI));
           
           FI++;
       }
       
       OurCharacter.CF.addAll(NF);
    }
    
    public String GetRaceInfo(int index)
    {
        String Desc = OurRaces.get(index).getDesc();
        return fieldFormat(Desc);
    }
    
    public String GetClassInfo(int index)
    {
        String Desc = OurClasses.get(index).getDesc();
        return fieldFormat(Desc);
    }
    
    public int GetSkillRanks()
    {
        int SR = OurCharacter.CC.getSR() + OurCharacter.CalcAM(3);
        return SR;
    }
    
    public String GetFeatureInfo(int index)
    {
        String Desc = OurFeatures.get(index).getDesc();
        return fieldFormat(Desc);
    }
    
    public String GetWeaponInfo(int index)
    {
        String Desc = OurWeapons.get(index).getDesc();
        return fieldFormat(Desc);
    }
    
    public String GetArmorInfo(int index)
    {
        String Desc = OurArmor.get(index).getDesc();
        return fieldFormat(Desc);
    }
    
    public String GetWeaponCost(int index)
    {
        String Price = OurWeapons.get(index).getPrice() + " Gold";
        return Price;
    }
    
    public String GetGold()
    {
        return "Current Gold: " + OurCharacter.CM[1];
    }
    
    public void AddWeapon(int index)
    {
        WeaponList += OurWeapons.get(index).getName() + "\n";
        OurCharacter.CW.add(OurWeapons.get(index));
        OurCharacter.CM[1] -= OurWeapons.get(index).getPrice();
    }
    
    public String FinalCharacterDetails()
    {
        //TODO create a string containing all of the character details formated and return
        return "Nothing here yet";
    }
    
    public String GetName()
    {
        return OurCharacter.CD[0];
    }
    
    public void RollAbilities()
    {
        AS = new int[] {0,0,0,0,0,0};
        AS[0] = (int)(Math.random() * 17 + 2);
        AS[1] = (int)(Math.random() * 17 + 2);
        AS[2] = (int)(Math.random() * 17 + 2);
        AS[3] = (int)(Math.random() * 17 + 2);
        AS[4] = (int)(Math.random() * 17 + 2);
        AS[5] = (int)(Math.random() * 17 + 2);
    }
    
    public int[] GetAS()
    {
        return AS;
    }
    
    public String[] getSkills()
    {
        String[] ret = new String[Skills.size()];
        ret = Skills.toArray(ret);
        return ret;
    }
    
    public void SetAS(int[] OurAS)
    {
        OurCharacter.AS = OurAS;
    }
    
    //Helper to automatically force text wrap and other helpful html formating for text onto sent out descriptions
    private String fieldFormat(String toFormat)
    {
        return "<html><p>" + toFormat + "<html><p>";
    }
}
