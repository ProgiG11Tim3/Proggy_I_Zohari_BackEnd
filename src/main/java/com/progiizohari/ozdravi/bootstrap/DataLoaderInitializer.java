package com.progiizohari.ozdravi.bootstrap;

import com.progiizohari.ozdravi.bootstrap.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoaderInitializer {

    private final DataLoader dataLoader;

    @Autowired
    public DataLoaderInitializer(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @PostConstruct
    public void init() {
        try {
            // Manually execute the DataLoader
            dataLoader.run();
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
}