package com.dataart.javaschool.springintro.resources;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Ornithopter {

    Set<Worker> team;

    // return true if the worm is visible close
    boolean checkForWorms() {
        return false;
    }

    void takeOff(Harvester harvester) {
        // takes harvester and takes off
    }
}
