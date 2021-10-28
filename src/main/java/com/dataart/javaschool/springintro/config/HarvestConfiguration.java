package com.dataart.javaschool.springintro.config;

import com.dataart.javaschool.springintro.resources.Harvester;
import com.dataart.javaschool.springintro.resources.Ornithopter;
import com.dataart.javaschool.springintro.resources.ResourcesWrapper;
import com.dataart.javaschool.springintro.resources.Spice;
import com.dataart.javaschool.springintro.resources.Warehouse;
import com.dataart.javaschool.springintro.resources.Worker;
import com.dataart.javaschool.springintro.strategy.HarvestStrategy;
import com.dataart.javaschool.springintro.strategy.MaximizeSpiceHarvestStrategy;
import com.dataart.javaschool.springintro.strategy.MinimizeSpiceHarvestStrategy;
import com.dataart.javaschool.springintro.strategy.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HarvestConfiguration {

    // Вообще, создание листов вот таким способом не очень красиво. Лучше было бы использовать фабрику.
    @Bean
    List<Harvester> getHarvesters(@Value("${resources.harvesters:0}") int harvestersCount) {
        final ArrayList<Harvester> harvesters = new ArrayList<>(harvestersCount);
        for (int i = 0; i < harvestersCount; i++) {
            harvesters.add(new Harvester(new Spice(100)));
        }
        return harvesters;
    }

    @Bean
    List<Ornithopter> getOrnithopters(@Value("${resources.ornithopters}") int ornithoptersCount) {
        final ArrayList<Ornithopter> ornithopters = new ArrayList<>(ornithoptersCount);
        for (int i = 0; i < ornithoptersCount; i++) {
            ornithopters.add(new Ornithopter());
        }
        return ornithopters;
    }

    @Bean
    List<Worker> getWorkers(@Value("${resources.workers}") int workersCount) {
        final List<Worker> workers = new ArrayList<>(workersCount);
        for (int i = 0; i < workersCount; i++) {
            workers.add(new Worker());
        }
        return workers;
    }

    @Bean
    @ConfigurationProperties(prefix = "resources.warehouses")
    Warehouse getWarehouse() {
        return new Warehouse();
    }

    @Bean
    public ResourcesWrapper getResources(List<Worker> workers,
                                         List<Ornithopter> ornithopters,
                                         List<Harvester> harvesters,
                                         List<Warehouse> warehouses) {
        ResourcesWrapper resourcesWrapper = ResourcesWrapper.builder()
                .harvesters(harvesters)
                .ornithopters(ornithopters)
                .workers(workers)
                .build();

        return resourcesWrapper;
    }

    @Bean
    @ConditionalOnProperty(name="strategy", havingValue = "MAXIMIZE")
    public HarvestStrategy maximizeSpiceHarvestStrategy(@Autowired ResourcesWrapper resources) {
        return new MaximizeSpiceHarvestStrategy(resources);
    }

    @Bean
    @ConditionalOnProperty(name="strategy", havingValue = "MINIMIZE")
    public HarvestStrategy minimizeSpiceHarvestStrategy(@Autowired ResourcesWrapper resources) {
        return new MinimizeSpiceHarvestStrategy(resources);
    }

    @Bean
    public Observer observer(HarvestStrategy harvestStrategy){
        return new Observer(harvestStrategy);
    }

}
