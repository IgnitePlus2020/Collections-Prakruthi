package com.tgt.igniteplus;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static Set<String> Skills = new HashSet<>();
    static List<IgniteMembers> members = new CopyOnWriteArrayList<>();
    static List<String> Department = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int option, yes;
        Department.add("Data Science");
        Department.add("Infrastructure");
        Set<String> gauthamSkills = new HashSet<>();
        gauthamSkills.add("Java");
        gauthamSkills.add("SQL");
        gauthamSkills.add("DS");
        Set<String> divyaSkills = new HashSet<>();
        divyaSkills.add("Java");
        divyaSkills.add("NOSQL");
        divyaSkills.add("ML");
        Set<String> amitSkills = new HashSet<>();
        amitSkills.add("Linux");
        amitSkills.add("PSQL");
        amitSkills.add("Scripting");
        Set<String> naveenSkills = new HashSet<>();
        naveenSkills.add("Chef");
        naveenSkills.add("React");
        naveenSkills.add("AI");
        members.add(new IgniteMembers("Gautham", "VTU", Department.get(0), gauthamSkills, 28));
        members.add(new IgniteMembers("Divya", "TGT", Department.get(0), divyaSkills, 26));
        members.add(new IgniteMembers("Amit", "TMT", Department.get(1), amitSkills, 25));
        members.add(new IgniteMembers("Naveen", "DOJO", Department.get(1), naveenSkills, 22));
        do {
            System.out.println("Menu:\n" + "1. Display list of Departments\n" + "2. Create a new Department\n" + "3. Delete a Department\n" + "4. Display all Members based on departments\n" + "5. Create a Member and add to a department\n" + "6. Add new skill set to all members of a department\n" + "7. Swap department of a member\n" + "8. Display members based on given skill\n");
            System.out.print("Enter your option\n");
            option = in.nextInt();
            switch (option)
            {
                case 1:
                    displayDepartment();
                    break;

                case 2:
                    String department = createDepartment();
                    System.out.println("Enter member in this department\n");
                    createMember(department);
                    break;

                case 3:
                    removeDepartment();
                    break;

                case 4:
                    displayAsPerDepartment();
                    break;

                case 5:
                    createMember(null);
                    break;

                case 6:
                    addNewSkill();
                    break;

                case 7:
                    swapDepartment();
                    break;

                case 8:
                    displayAsPerSkill();
                    break;

                default:
                    System.out.print("Invalid option\n");
            }

            System.out.print("Press 1 if you want to continue.\n" + "Else, press 0\n");
            yes = in.nextInt();
        } while (option == 1);

        //System.exit(0);
    }

    private static void displayDepartment() {
        int i = 1;
        System.out.println("\nDepartments:");
        for (String deptObj : Department) {
            System.out.println(i + ". " + deptObj);
            i++;
        }
    }

    private static String createDepartment() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the department to be created\n");
        String newDept = in.next();
        Department.add(newDept);
        return newDept;
    }

    private static void addNewSkill() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the new skill\n");
        String newSkill = in.next();
        System.out.print("Enter the department\n");
        int j = 1;
        for (String deptObj : Department) {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        String dept = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department) {
            if (k == deptChoice) {
                dept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMembers i_m : members) {
            if (i_m.getDepartment().contains(dept)) {
                Set<String> skill = i_m.getSkills();
                skill.add(newSkill);
                i_m.setSkills(skill);
            }
        }
        System.out.println("New skills added");
        for (IgniteMembers im : members)
            if (im.getDepartment().contains(dept))
                System.out.println("Name:\t" + im.getName() + "\t\t\tSkills:\t" + im.getSkills());
    }

    private static void swapDepartment() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the member whose department you want to change:\n");
        String memName = in.next();
        System.out.println("Enter the choice of department\n");
        int j = 1;
        for (String deptObj : Department) {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        String dept = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department) {
            if (k == deptChoice) {
                dept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMembers im : members) {
            if (im.getName().contains(memName))
                im.setDepartment(dept);
        }
    }
    private static void displayAsPerSkill()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Listing members according to skill");
        System.out.print("Enter the skill\n");
        String skill = in.nextLine();
        System.out.println("\nMembers having " + skill + " skills:");
        for (IgniteMembers i_m : members) {
            if (i_m.getSkills().contains(skill))
                System.out.println(i_m);
        }
    }
    private static void createMember(String deptParam)
    {
        Scanner in = new Scanner(System.in);
        Set<String> Skills = new HashSet<>();
        String newName, newCollege;
        String dept = deptParam;
        int newAge, count, deptChoice;
        System.out.print("\nEnter the Name of the member\n");
        newName = in.next();
        do {
            for (IgniteMembers im : members)
            {
                if (im.getName().contains(newName))
                {
                    System.out.print("Enter a name which doesn't exist\n");
                    newName = in.next();
                }
            }
        } while (members.contains(newName));

        System.out.print("Enter Age\n");
        newAge = in.nextInt();
        System.out.print("Enter College\n");
        newCollege = in.next();
        System.out.print("Enter number of skills\n");
        count = in.nextInt();
        System.out.print("Enter the Skills \n");
        for (int j = 0; j < count; j++) {
            String newSkill = in.next();
            Skills.add(newSkill);
        }
        if (dept == null)
        {
            System.out.println("Add the member to any one of the following departments\n");
            int j = 1;
            for (String deptObj : Department)
            {
                System.out.println(j + ". " + deptObj);
                j++;
            }
            System.out.print("Enter Department option\n");
            deptChoice = in.nextInt();
            int k = 1;
            for (String deptObj : Department)
            {
                if (k == deptChoice)
                {
                    dept = deptObj;
                    break;
                }
                k++;
            }
        }
        members.add(new IgniteMembers(newName, newCollege, dept, Skills, newAge));
        System.out.println("Member added\n");
    }
    private static void displayAsPerDepartment()
    {
        System.out.println("\nDEPARTMENT\t\t\t|\t\tMEMBER NAME\n");
        System.out.println();
        for (IgniteMembers i_m : members)
        {
            System.out.println(i_m.getDepartment() + "\t\t|\t\t" + i_m.getName());
        }
    }
    private static void removeDepartment()
    {
        Scanner in = new Scanner(System.in);
        int deptChoice;
        String deleteDept = null;
        System.out.println("Enter the department to delete\n");
        int j = 1;
        for (String deptObj : Department)
        {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department)
        {
            if (k == deptChoice)
            {
                deleteDept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMembers i_m : members)
        {
            if (i_m.getDepartment().contains(deleteDept))
            {
                members.remove(i_m);
            }
        }
        Department.remove(deleteDept);
        System.out.println("Department Removed\n");
    }
}

