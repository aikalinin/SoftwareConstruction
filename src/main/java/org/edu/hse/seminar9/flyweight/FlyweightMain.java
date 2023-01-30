package org.edu.hse.seminar9.flyweight;

import org.edu.hse.seminar9.flyweight.model.Imaginable;
import org.edu.hse.seminar9.flyweight.router.CachableRouter;
import org.edu.hse.seminar9.flyweight.router.Router;

public class FlyweightMain {

    public static void main(String[] args) {
        final Router<Imaginable> imaginableRouter = new CachableRouter();

        imaginableRouter.getData("profile://data");
        imaginableRouter.getData("news://data");

        imaginableRouter.getData("profile://data");
        imaginableRouter.getData("news://data");
    }
}
