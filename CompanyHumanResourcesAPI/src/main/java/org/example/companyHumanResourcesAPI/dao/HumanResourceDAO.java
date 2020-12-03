package org.example.companyHumanResourcesAPI.dao;

import org.example.companyHumanResourcesAPI.domain.HumanResource;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HumanResourceDAO {

    private List<HumanResource> humanResourceList;

    public HumanResourceDAO(List<HumanResource> humanResourceList) {
        this.humanResourceList = humanResourceList;
    }

    public Optional<HumanResource> getHumanResourceByName(String name) {
        return humanResourceList.stream().filter(humanResource -> name.equals(humanResource.getName())).findFirst();
    }

    public List<HumanResource> getAllHumanResource() {
        return humanResourceList;
    }

    public void addHumanResource(HumanResource humanResource) {
        humanResourceList.add(humanResource);
    }

    public int getNextHumanResourceId() {
        int nextId = 0;
        Optional<HumanResource> optionalLastHumanResource = humanResourceList.stream()
                .sorted(Comparator.comparing(HumanResource::getId))
                .reduce((first, last) -> last);
        if (optionalLastHumanResource.isPresent()) {
            nextId = Integer.parseInt(optionalLastHumanResource.get().getId()) + 1;
        }

        return nextId;
    }
}
