package com.dataart.javaschool.springintro.resources;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class ResourcesWrapper {
    List<Harvester> harvesters;
    List<Ornithopter> ornithopters;
    Set<Warehouse> warehouses;
    List<Worker> workers;
}
