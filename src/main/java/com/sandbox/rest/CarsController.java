package com.sandbox.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarsController {
    @GetMapping("/toyotas")
    public Map<String, Object> getToyotas() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "0d9aac2a-8799-4131-8ad2-9812ff808301");
        map.put("make", "Toyota");

        List<CarModel> models = new ArrayList<>();

        CarModel carModel1 = new CarModel();
        carModel1.setModel("Corolla");
        carModel1.setSize("Compact");

        CarModel carModel2 = new CarModel();
        carModel2.setModel("Camry");
        carModel2.setSize("Mid-size");

        models.add(carModel1);
        models.add(carModel2);

        map.put("models", models);

        return map;
    }
}
