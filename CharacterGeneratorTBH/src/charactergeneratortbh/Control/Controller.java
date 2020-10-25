/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergeneratortbh.Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
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
    GameCharacter OurCharacter;
    
    public Controller()
    {
        try 
        {
            SkillPopulator SP = new SkillPopulator(path+"//Skills.txt");
            FeaturePopulator FP = new FeaturePopulator(path+"//Features.txt");
            WeaponPopulator WP = new WeaponPopulator(path+"//Weapons.txt");
            ArmorPopulator AP = new ArmorPopulator(path+"//Armor.txt");
            RacePopulator RP = new RacePopulator(path+"//Races.txt");
            ClassPopulator CP = new ClassPopulator(path +"//Classes.txt");
            OurSkills = SP.getSkills();
            OurFeatures = FP.getFeatures();
            OurWeapons = WP.getWeapons();
            OurArmor = AP.getArmor();
            OurRaces = RP.getRaces();
            OurClasses = CP.getClasses();
        }
        catch(FileNotFoundException ex)
        {
            //GUI.ErrorMessage(ex);
        }
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
    
    public void SecondStage(Race R, int A, int H)
    {
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
        
        AddFeatures(R.F);
    }
    
    public void ThirdStage(GameClass C)
    {
        OurCharacter.CC = C;
        OurCharacter.CH = C.HD;
        OurCharacter.CalcCombat();
        AddFeatures(C.F);
        OurCharacter.CM = C.W;
    }
    
    public void FourthStage(List<String> sn)
    {
        int ri = 0;
        
        for(int i = 0; i < OurCharacter.CS.length; i++)
        {
            if(OurCharacter.CS[i].SN.equals(sn.get(ri)))
            {
                OurCharacter.CS[i].R += 1;
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
           if(OurFeatures.get(FI).N.equals(add.get(i)))
               NF.add(OurFeatures.get(FI));
           
           FI++;
       }
       
       OurCharacter.CF.addAll(NF);
    }
}
