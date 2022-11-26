package org.edu.hse;

import org.edu.hse.oop.FileIterator;
import org.edu.hse.oop.Worker;
import org.edu.hse.oop.WorkerExploitation;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
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

    private static void readFile() throws FileNotFoundException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource("file.txt");
        assert resource != null;
        FileIterator iterator = new FileIterator(resource.getPath());
    }
}