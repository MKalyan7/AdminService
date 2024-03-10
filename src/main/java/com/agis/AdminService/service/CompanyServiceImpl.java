package com.agis.AdminService.service;

import com.agis.AdminService.entity.Address;
import com.agis.AdminService.entity.Company;
import com.agis.AdminService.model.AddressRequest;
import com.agis.AdminService.model.AddressResponse;
import com.agis.AdminService.model.CompanyRequest;
import com.agis.AdminService.model.CompanyResponse;
import com.agis.AdminService.repository.AddressRepository;
import com.agis.AdminService.repository.CompanyRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public long createCompany(CompanyRequest companyRequest) {
        log.info("Creating Company:  {} ",companyRequest);
        List<AddressRequest> addressRequestList = companyRequest.getAddresses();
        List<Address> addressList = new ArrayList<>();
        Company company =  Company.builder()
                .companyName(companyRequest.getCompanyName())
                .companyStatus(companyRequest.getCompanyStatus())
                .address(addressList)
                .build();

        for (AddressRequest addressRequest:addressRequestList) {
           Address address = Address.builder()
                    .addressLine1(addressRequest.getAddressLine1())
                    .addressLine2(addressRequest.getAddressLine2())
                    .addressLine3(addressRequest.getAddressLine3())
                    .city(addressRequest.getCity())
                    .township(addressRequest.getTownship())
                    .county(addressRequest.getCounty())
                    .state(addressRequest.getState())
                    .zipcode(addressRequest.getZipcode())
                    .company(company)
                    .addressStatus(true)
                    .addressValidated(false).build();
           addressList.add(address);
        }
        companyRepository.save(company);
        log.info("Company Created");
        return company.getCompanyId();
    }

    @Override
    public List<CompanyResponse> getCompaniesDetails() {
        log.info("Fetching All Companies Details:  {} ");
        List<Company> companies = companyRepository.findAll();
        List<CompanyResponse> companyResponseList = new ArrayList<>();
        for (Company company:companies) {
            List<Address> addressList = company.getAddress();
            List<AddressResponse> addressResponses = addressList.stream().map(x -> modelMapper.map(x,AddressResponse.class)).collect(Collectors.toList());
            CompanyResponse companyResponse = modelMapper.map(company,CompanyResponse.class);
            companyResponse.setAddresses(addressResponses);
            companyResponseList.add(companyResponse);
        }
        return companyResponseList;
    }

    @Override
    public CompanyResponse getCompanyDetails(long companyId) {
        log.info("Feting Company Details by companyId {}",companyId);
        Optional<Company> company = companyRepository.findById(companyId);
        List<Address> addressList = company.get().getAddress();
        List<AddressResponse> addressResponses = addressList.stream().map(x -> modelMapper.map(x,AddressResponse.class)).collect(Collectors.toList());
        CompanyResponse companyResponse = modelMapper.map(company,CompanyResponse.class);
        companyResponse.setAddresses(addressResponses);
        return companyResponse;
    }
}
