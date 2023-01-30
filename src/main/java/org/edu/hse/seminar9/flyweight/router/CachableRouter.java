package org.edu.hse.seminar9.flyweight.router;

import org.edu.hse.seminar9.flyweight.model.Imaginable;
import org.edu.hse.seminar9.flyweight.model.News;
import org.edu.hse.seminar9.flyweight.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class CachableRouter implements Router<Imaginable> {

    private static final Map<String, Imaginable> cache = new HashMap<>();

    @Override
    public Imaginable getData(String url) {
        final Imaginable imaginable = cache.get(url);

        if (imaginable != null) {
            System.out.println("Got data from cache by url " + url);
            return imaginable;
        }

        // Запросы на сервер
        final Imaginable newImaginable;
        if (url.contains("profile")) {
            newImaginable = Profile.builder()
                    .iconUrl("Profile Icon")
                    .imageUrl("Profile Icon")
                    .build();
        } else {
            newImaginable = News.builder()
                    .newsImageUrl("News Image")
                    .build();
        }

        System.out.println("Added data in cache by url " + url);
        cache.put(url, newImaginable);

        return newImaginable;
    }
}
