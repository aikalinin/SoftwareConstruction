package org.edu.hse.decorator;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ValidatedStudentService implements StudentService {
    private final StudentService studentService;

    @Override
    public List<String> getStudentsNames() {
        final List<String> students = studentService.getStudentsNames();

        if (students.isEmpty()) {
            throw new IllegalStateException("We should have students");
        }

        return students;
    }

    @Override
    public Optional<String> getStudentNameById(Integer id) {
        final Optional<String> studentName = studentService.getStudentNameById(id);

        if (studentName.isEmpty() || studentName.get().isBlank()) {
            throw new IllegalStateException("We should have student");
        }

        return studentName;
    }
}
