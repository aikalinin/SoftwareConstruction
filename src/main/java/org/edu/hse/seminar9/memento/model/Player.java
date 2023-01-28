package org.edu.hse.seminar9.memento.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    private String name;

    private String currentGame;

    private int rating;
}
