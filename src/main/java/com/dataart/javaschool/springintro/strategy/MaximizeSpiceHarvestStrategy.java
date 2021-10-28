package com.dataart.javaschool.springintro.strategy;

import com.dataart.javaschool.springintro.resources.ResourcesWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class MaximizeSpiceHarvestStrategy implements HarvestStrategy{

    final ResourcesWrapper resources;

    @Override
    public void doHarvest() {
        int workingHours = 12;
        // use as max harvesters as possible
        // maximize working hours
        // make all the warehouses full asap
        // people hate you
    }
}
