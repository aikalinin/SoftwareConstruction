package org.edu.hse;

import org.edu.hse.interfaces.Implementer;
import org.edu.hse.interfaces.Testable;
import org.edu.hse.oop.*;

import javax.swing.plaf.LabelUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("Igor", LocalDate.of(2010, 10, 11));
        Worker worker1 = new Worker("Pasha", LocalDate.of(1996, 2, 20));
        Worker worker2 = new Worker("Gosha", LocalDate.of(2028, 2, 28));
        WorkerExploitation workerExploitation = new WorkerExploitation(List.of(worker, worker1, worker2));
        workerExploitation.run();

        WorkerExploitation workerExploitation2 = new WorkerExploitation(worker, worker1, worker2);

    }
}