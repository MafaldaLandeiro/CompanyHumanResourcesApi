package org.example.companyHumanResourcesAPI.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.companyHumanResourcesAPI.dao.CompanyDAO;
import org.example.companyHumanResourcesAPI.dao.HumanResourceDAO;
import org.example.companyHumanResourcesAPI.domain.Company;
import org.example.companyHumanResourcesAPI.domain.HumanResource;

import java.util.Optional;

public class HumanResourceMutation implements GraphQLMutationResolver {

    private HumanResourceDAO humanResourceDAO;

    private CompanyDAO companyDAO;

    public HumanResourceMutation(HumanResourceDAO humanResourceDAO, CompanyDAO companyDAO) {
        this.humanResourceDAO = humanResourceDAO;
        this.companyDAO = companyDAO;
    }

    public Optional<HumanResource> addHumanResource(String name, int age, String category,
                                                    Float salary, String companyId) {
        Optional<Company> optionalCompany = companyDAO.getCompanyById(companyId);

        HumanResource humanResource = null;
        if (optionalCompany.isPresent()) {
            int id = humanResourceDAO.getNextHumanResourceId();
            humanResource = new HumanResource(String.valueOf(id), name, age, category, salary, companyId);
            humanResourceDAO.addHumanResource(humanResource);
        }

        return (humanResource != null) ? Optional.of(humanResource) : Optional.empty();
    }
}
