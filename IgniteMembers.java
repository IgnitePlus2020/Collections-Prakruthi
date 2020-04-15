package com.tgt.igniteplus;
import java.util.List;
import java.util.Set;

public class IgniteMembers
{
    private String Name;
    private String College;
    private String Department;
    private Set<String> Skills;
    private int Age;
    public IgniteMembers(String name, String college, String department, Set<String> skills, int age)
    {
        Name = name;
        College = college;
        Department = department;
        Skills = skills;
        Age = age;
    }
    public String toString()
    {
        return("Ignite Members:\n" + "Name: '" + Name + '\t' + "\tCollege: '" + College + '\'' + "\tDepartment: '" + Department + '\'' + "\tSkills: " + Skills + "\tAge: " + Age);
    }
    public String getName()
    {
        return Name;
    }

    public String getCollege()
    {
        return College;
    }

    public String getDepartment()
    {
        return Department;
    }

    public Set<String> getSkills()
    {
        return Skills;
    }

    public int getAge()
    {
        return Age;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public void setCollege(String college)
    {
        College = college;
    }

    public void setDepartment(String department)
    {
        Department = department;
    }

    public void setSkills(Set<String> skillSet)
    {
        Skills = skillSet;
    }

    public void setAge(int age)
    {
        Age = age;
    }
}