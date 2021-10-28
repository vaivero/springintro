package com.dataart.javaschool.springintro.strategy;

import com.dataart.javaschool.springintro.resources.ResourcesWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class MinimizeSpiceHarvestStrategy implements HarvestStrategy {

    final ResourcesWrapper resources;

    @Override
    public void doHarvest() {
        // don't use all the harvesters and ornitopters
        // manimize working hours
        // keep the warehouses as empty as possible
        // people degrade, spice crisis is coming
    }
}
