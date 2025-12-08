package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
      
        ArrayList<String> myList = new ArrayList<String>();
        
        myList.add("Renault");
        myList.add("Hyundai");
        myList.add("Honda");
        myList.add(3, "Kia");
        myList.add(1, "Maruti");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Ford is in list: " + myList.contains("Ford"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Maruti");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}