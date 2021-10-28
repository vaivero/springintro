package com.dataart.javaschool.springintro.resources;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Worker {

    LocalDateTime startWorkTime;
    LocalDateTime endWorkTime;

    public void work(){

    }

    public void stopWorking(){

    }
}
