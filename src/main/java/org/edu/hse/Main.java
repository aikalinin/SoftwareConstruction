package org.edu.hse;

import org.edu.hse.exceptions.WastedException;
import org.edu.hse.oop.FileIterator;
import org.edu.hse.oop.Worker;
import org.edu.hse.oop.WorkerExploitation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("Igor", LocalDate.of(2010, 10, 11));
        Worker worker1 = new Worker("Pasha", LocalDate.of(1996, 2, 20));
        Worker worker2 = new Worker("Gosha", LocalDate.of(2028, 2, 28));
        WorkerExploitation workerExploitation = new WorkerExploitation(List.of(worker, worker1, worker2));
        int a = workerExploitation.run();

        // worker.getAge();

        try {
            worker.getAge();
            worker.getAge();
            worker.getAge();
            worker.getAge();
            worker.getAge();
        } catch (WastedException e) {
            System.out.println("Worker died");
        }

        WorkerExploitation workerExploitation2 = new WorkerExploitation(worker, worker1, worker2);

        try {
            Main.readFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFile() throws FileNotFoundException, URISyntaxException {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource("file.txt");

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("file.txt");
        FileIterator iterator = new FileIterator(is);

        File file = new File(resource.toURI());

//        assert resource != null;
        System.out.println(resource.getPath());
        FileIterator iterator1 = new FileIterator(file);
        FileIterator iterator2 = new FileIterator(resource.toURI().getSchemeSpecificPart());
//        FileIterator iterator2 = new FileIterator(resource.getPath());
//        FileIterator iterator2 = new FileIterator("D:\\HSE\\КПО\\Code\\SoftwareConstruction\\target\\classes\\file.txt");
        System.out.println(iterator2.next());
    }
}