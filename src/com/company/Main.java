package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
//    static Student[] tempStudentObjArray;
    public static void main(String[] args) {
        System.out.println("Hello World...!");
        String[] studentsArray = {"John", "Riya", "Mac", "Akiva"};
        Student[] tempStudentObjArray = builtObjectArray(studentsArray);
        ArrayList<Student> tempStudentArrayList = buildArrayList(tempStudentObjArray);
        displayArrayList(tempStudentArrayList);
        deleteArrayList(tempStudentArrayList);
        displayArrayList(tempStudentArrayList);

//--------------------HashMap----------------------------------
//        HashMap<Integer, Student> tempMap = buildHashMap(tempStudentObjArray);
//        displayHashMap(tempMap);

    }

    private static ArrayList<Student> deleteArrayList(ArrayList<Student> tempStudentArrayList) {
        tempStudentArrayList.clear();
        System.out.println("ArrayList deleted.");
        return tempStudentArrayList;
    }

    private static void displayArrayList(ArrayList<Student> tempStudentArrayList) {
        System.out.println("-----------ArrayList------------");
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
