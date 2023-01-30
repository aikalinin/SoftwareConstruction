package org.edu.hse.seminar9.flyweight.model;

import lombok.Builder;

@Builder
public class News implements Imaginable {

    private String newsImageUrl;

    @Override
    public String getImageUrl() {
        return newsImageUrl;
    }

    @Override
    public String getIconUrl() {
        return getImageUrl();
    }
}
