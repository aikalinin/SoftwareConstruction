package org.edu.hse.seminar9.decorator;

import java.util.HashMap;
import java.util.Map;

public class DecoratorMain {

    public static void main(String[] args) {
        final StudentService defaultStudentService = new DefaultStudentService(studentsProvider());
        final StudentService validatedStudentService = new ValidatedStudentService(defaultStudentService);

        System.out.println("[DefaultStudentService::getStudentsNames()] -> " + defaultStudentService.getStudentsNames());
        System.out.println("[DefaultStudentService::getStudentNameById(1)] -> " + defaultStudentService.getStudentNameById(1));
        System.out.println("[DefaultStudentService::getStudentNameById(5)] -> " + defaultStudentService.getStudentNameById(5));
        System.out.println("[DefaultStudentService::getStudentNameById(6)] -> " + defaultStudentService.getStudentNameById(6));

        System.out.println("[ValidatedStudentService::getStudentsNames()] -> " + validatedStudentService.getStudentsNames());
        System.out.println("[ValidatedStudentService::getStudentNameById(1)] -> " + validatedStudentService.getStudentNameById(1));
        System.out.println("[ValidatedStudentService::getStudentNameById(5)] -> " + validatedStudentService.getStudentNameById(5));
        System.out.println("[ValidatedStudentService::getStudentNameById(6)] -> " + validatedStudentService.getStudentNameById(6));
    }

    private static Map<Integer, String> studentsProvider() {
        final Map<Integer, String> studentsMap = new HashMap<>();

        studentsMap.put(1, "Lisa");
        studentsMap.put(2, "Vasya");
        studentsMap.put(3, "Venik");
        studentsMap.put(4, "Alex");
        studentsMap.put(5, "  ");

        return studentsMap;
    }
}
