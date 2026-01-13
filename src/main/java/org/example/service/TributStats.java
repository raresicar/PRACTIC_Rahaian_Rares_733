package org.example.service;

import org.example.model.Tribut;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TributStats {
    public List<Tribut> filterByDistrict(List<Tribut> tributes, int district) {
        return tributes.stream()
                .filter(tribute -> tribute.getDistrict() == district
                        && tribute.getStatus().equalsIgnoreCase("ALIVE"))
                .collect(Collectors.toList());
    }

    public List<Tribut> sortBySkillThanName(List<Tribut> tributes) {
        return tributes.stream()
                .sorted(Comparator.comparingInt(Tribut::getSkillLevel).reversed()
                        .thenComparing(Tribut::getName))
                .collect(Collectors.toList());
    }

}

