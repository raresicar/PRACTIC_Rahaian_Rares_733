package org.example.service;

import org.example.model.Tribut;

import java.util.List;
import java.util.stream.Collectors;

public class TributStats {
    public List<Tribut> filterByDistrict(List<Tribut> tributes, int district) {
        return tributes.stream()
                .filter(tribute -> tribute.getDistrict() == district
                        && tribute.getStatus().equalsIgnoreCase("ALIVE"))
                .collect(Collectors.toList());
    }


}
