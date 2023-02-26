package org.edu.hse.decorator;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<String> getStudentsNames();

    Optional<String> getStudentNameById(final Integer id);
}
