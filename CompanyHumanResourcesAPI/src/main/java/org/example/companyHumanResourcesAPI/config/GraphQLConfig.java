package org.example.companyHumanResourcesAPI.config;

import org.example.companyHumanResourcesAPI.dao.CompanyDAO;
import org.example.companyHumanResourcesAPI.dao.HumanResourceDAO;
import org.example.companyHumanResourcesAPI.domain.Company;
import org.example.companyHumanResourcesAPI.domain.HumanResource;
import org.example.companyHumanResourcesAPI.mutation.HumanResourceMutation;
import org.example.companyHumanResourcesAPI.query.HumanResourceQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfig {

    @Bean
    public CompanyDAO companyDAO() {
        List<Integer> ids = new Random().ints(50, 0, 1000)
                .boxed().collect(Collectors.toList());
        int countHumanResource = 0;

        List<Company> companyList = new ArrayList<>();
        for (int companyId = 0; companyId < 5; companyId++) {
            List<HumanResource> humanResourceList = new ArrayList<>();
            for (int humanResourceId = 0; humanResourceId < 10; humanResourceId++) {
                HumanResource humanResource = new HumanResource(String.valueOf(ids.get(countHumanResource)),
                        "Human " + humanResourceId, 25, null, null,
                        String.valueOf(companyId));
                humanResourceList.add(humanResource);
                countHumanResource++;
            }
            Company company = new Company(String.valueOf(companyId), "Company " + companyId,
                    "Portugal", humanResourceList);
            companyList.add(company);
        }
        return new CompanyDAO(companyList);
    }

    @Bean
    public HumanResourceDAO humanResourceDAO() {
        List<Integer> ids = new Random().ints(50, 0, 1000)
                .boxed().collect(Collectors.toList());
        int countHumanResource = 0;

        List<HumanResource> humanResourceList = new ArrayList<>();
        for (int companyId = 0; companyId < 5; companyId++) {
            for (int humanResourceId = 0; humanResourceId < 10; humanResourceId++) {
                HumanResource humanResource = new HumanResource(String.valueOf(ids.get(countHumanResource)),
                        "Human " + humanResourceId, 25, null, null,
                        String.valueOf(companyId));
                humanResourceList.add(humanResource);
                countHumanResource++;
            }
        }
        return new HumanResourceDAO(humanResourceList);
    }

    @Bean
    public HumanResourceQuery humanResourceQuery(HumanResourceDAO humanResourceDAO) {
        return new HumanResourceQuery(humanResourceDAO);
    }

    @Bean
    public HumanResourceMutation humanResourceMutation(HumanResourceDAO humanResourceDAO, CompanyDAO companyDAO) {
        return new HumanResourceMutation(humanResourceDAO, companyDAO);
    }
}
