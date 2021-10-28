package com.dataart.javaschool.springintro.strategy;

import com.dataart.javaschool.springintro.resources.ResourcesWrapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PeopleFirstHarvestStrategy implements HarvestStrategy {

    final ResourcesWrapper resources;

    @Override
    public void doHarvest() {
        // working hours are 6h - 8h
        // no harvesting without ornitopter per harvester
        // warehouses are full when they are full.
        // people adore you
    }
}
