package org.example.companyHumanResourcesAPI.dao;

import org.example.companyHumanResourcesAPI.domain.Company;

import java.util.List;
import java.util.Optional;

public class CompanyDAO {

    private List<Company> companyList;

    public CompanyDAO(List<Company> companyList) {
        this.companyList = companyList;
    }

    public Optional<Company> getCompanyById(String companyId) {
        return companyList.stream().filter(company -> companyId.equals(company.getId())).findFirst();
    }
}
