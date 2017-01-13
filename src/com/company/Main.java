package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    static Student[] tempStudentObjArray;
    public static void main(String[] args) {
        System.out.println("Hello World...!");
        String[] studentsArray = {"John", "Riya", "Mac", "Akiva"};
        Student[] tempStudentObjArray = builtObjectArray(studentsArray);

//-------------------ArrayList---------------------------
        ArrayList<Student> tempStudentArrayList = buildArrayList(tempStudentObjArray);
        displayArrayList(tempStudentArrayList);
        deleteArrayList(tempStudentArrayList);
        displayArrayList(tempStudentArrayList);

//-------------------StringBuffer---------------------------
        StringBuffer tempStudentStringBuffer = buildStingBuffer(tempStudentObjArray);
        displayStringBuffer(tempStudentStringBuffer);
//        StringBuffer testSB = new StringBuffer();
//        testSB.append("Sagar Mangulkar");
//        System.out.println(testSB.toString().split(" ")[0]);

//--------------------HashMap----------------------------------
        HashMap<Integer, Student> tempMap = buildHashMap(tempStudentObjArray);
        displayHashMap(tempMap);

//--------------Implement an algorithm to determine if a string has all unique characters. What if you
//--------------can not use additional data structures?
        checkUniqueString();
    }
    
//Checks unique string and identifies duplicate characters
    private static void checkUniqueString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string.");
        String input = scanner.nextLine();
        System.out.println("You have entered: " + input);
        boolean isUnique = true;
        StringBuffer repeatedCharSB = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                if(input.charAt(i) == input.charAt(j)){
                    isUnique = false;
                    repeatedCharSB.append(input.charAt(i));
                }
            }
        }
        for (int k = 0; k < repeatedCharSB.length(); k++) {
            for (int l = k + 1; l < repeatedCharSB.length(); l++) {
                if (repeatedCharSB.charAt(k) != '*') {
                    if (repeatedCharSB.charAt(k) == repeatedCharSB.charAt(l)) {
                        repeatedCharSB.deleteCharAt(l);
                        repeatedCharSB.insert(l, '*');
                    }
                }
            }
        }
        int sbLength = repeatedCharSB.length();
        int starIndex;
        for (int m = 0; m < sbLength; m++) {
            starIndex =repeatedCharSB.indexOf("*");
            if(starIndex >= 0) {
                repeatedCharSB.deleteCharAt(starIndex);
            }
        }
        if (!isUnique){
            System.out.println("Entered string is not Unique, repeated characters: " + repeatedCharSB.toString());
        }
        else {
            System.out.println("Entered string is Unique");
        }
    }

    private static void displayStringBuffer(StringBuffer tempStudentStringBuffer) {
        System.out.println("-----------StringBuffer------------");
        System.out.println(tempStudentStringBuffer.toString());
    }

    private static StringBuffer buildStingBuffer(Student[] tempStudentObjArray) {
        StringBuffer studentStringBuffer = new StringBuffer();
        int i = 0;
//        System.out.println("Student Object Array Length: "+tempStudentObjArray.length);
        for (Student s: tempStudentObjArray) {
            studentStringBuffer.append(tempStudentObjArray[i++].getName()+" ");
        }
        return studentStringBuffer;
    }

    private static ArrayList<Student> deleteArrayList(ArrayList<Student> tempStudentArrayList) {
        tempStudentArrayList.clear();
        System.out.println("ArrayList deleted.");
        return tempStudentArrayList;
    }

    private static void displayArrayList(ArrayList<Student> tempStudentArrayList) {
        System.out.println("-----------ArrayList------------");
        if(tempStudentArrayList.size() == 0){
            System.out.println("ArrayList is Empty.");
        }
        for (int i = 0; i < tempStudentArrayList.size(); i++) {
            System.out.println(i + " | " + tempStudentArrayList.get(i).getName());
        }
    }

    private static ArrayList<Student> buildArrayList(Student[] tempStudentObjArray) {
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        for (Student s: tempStudentObjArray) {
            studentArrayList.add(s);
        }
        return studentArrayList;
    }

    private static Student[] builtObjectArray(String[] studentNameArray) {
        Student[] studentObjArray = new Student[studentNameArray.length];
        int i = 0;
        int j = 1;
        for (String studentsName : studentNameArray) {
            studentObjArray[i] = new Student();
            studentObjArray[i].setId(j);
            studentObjArray[i].setName(studentsName);
            i++;
            j++;
        }
        return studentObjArray;
    }

    private static void displayHashMap(HashMap<Integer, Student> map) {
        System.out.println("-----------HashMap------------");
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(i + " | " + map.get(i).getName());
        }
    }

    private static HashMap<Integer, Student> buildHashMap(Student[] studentsArray) {
        int i = 0;
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s : studentsArray) {
            map.put(studentsArray[i++].getId(), s);
        }
        System.out.println("HashMap built");
        return map;
    }
}
