package org.example.companyHumanResourcesAPI.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.example.companyHumanResourcesAPI.dao.HumanResourceDAO;
import org.example.companyHumanResourcesAPI.domain.HumanResource;

import java.util.List;
import java.util.Optional;

public class HumanResourceQuery implements GraphQLQueryResolver {

    private HumanResourceDAO humanResourceDAO;

    public HumanResourceQuery(HumanResourceDAO humanResourceDAO) {
        this.humanResourceDAO = humanResourceDAO;
    }

    public Optional<HumanResource> getHumanResourceByName(String name) {
        return humanResourceDAO.getHumanResourceByName(name);
    }

    public List<HumanResource> getAllHumanResources() {
        return humanResourceDAO.getAllHumanResource();
    }
}
