package com.dataart.javaschool.springintro.resources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class Harvester {
    final Spice canTake;
    Spice available;
    Set<Worker> team;
    Warehouse destination;

    public void harvest() {
        // do update available
    }
}
