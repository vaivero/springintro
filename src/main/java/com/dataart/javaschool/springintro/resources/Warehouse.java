package com.dataart.javaschool.springintro.resources;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Warehouse {
    Spice total;
    Spice available;
    String location;
}
