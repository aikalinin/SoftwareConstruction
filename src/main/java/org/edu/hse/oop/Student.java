package org.edu.hse.oop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class Student implements Serializable, Cloneable {

    int id;
    String name;
    String[] friends;
    ArrayList<Integer> grades;

    public Student() {
    }

    public Student(int id, String name, String[] friends, ArrayList<Integer> grades) {
        this.id = id;
        this.name = name;
        this.friends = friends;
        this.grades = grades;

    }

    @Override
    public int hashCode() {
//        int h = 0;
//        h = 31 * h + name.hashCode();
//        h = 31 * h + grades.hashCode();
//        h = 31 * h + Arrays.hashCode(friends);
//        return name.hashCode() + grades.hashCode() + Arrays.hashCode(friends);
        return Objects.hash(name, Arrays.hashCode(friends), grades);
    }

    /*@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }*/

        @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (otherObject instanceof Student other) {
//            return name.equals(other.name)
//                    && grades.equals(other.grades)
//                    &&  Arrays.equals(friends, other.friends)
//                    && id == other.id;
            return Objects.equals(id, other.id)
                    && Objects.equals(name, other.name)
                    && Arrays.equals(friends, other.friends)
                    && Objects.equals(grades, other.grades);
        }
        return false;
    }

    @Override
    protected Object clone() {
        Student student = new Student(id,
                name,
                Arrays.copyOf(friends, friends.length),
                (ArrayList<Integer>) grades.clone());

        return student;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
