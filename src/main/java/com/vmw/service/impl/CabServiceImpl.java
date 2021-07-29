package com.vmw.service.impl;

import com.vmw.entity.*;
import com.vmw.repository.CabRepository;
import com.vmw.repository.CustomerRepository;
import com.vmw.repository.DriverRepository;
import com.vmw.service.CabService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CabServiceImpl implements CabService {

    private CabRepository cabRepository;

    private DriverRepository driverRepository;

    private CustomerRepository customerRepository;

    @Override
    public Cab addCab(Cab cab) {
        cab.setAvailable(true);
        cab.getDriver().getCab().setAvailable(true);
        return cabRepository.save(cab);
    }

    @Override
    public Driver addDriver(Driver driver) {
        driver.setAvailable(true);
        driver.getCab().setAvailable(true);
        return driverRepository.save(driver);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CabBookResponse bookCab(CabBookRequest cabBookRequest) {
        List<Cab> byAvailableAndCabType = cabRepository.findByAvailableAndCabType(true, cabBookRequest.getCabType());
        //byAvailableAndCabType.stream().min((o1, o2) -> o1.getXCoordinate()-cabBookRequest.get)
        Cab cab=byAvailableAndCabType.stream().findAny().get();
        CabBookResponse cabBookResponse=new CabBookResponse();
        cabBookResponse.setCabType(cab.getCabType());
        cabBookResponse.setCarNo(cab.getCarNo());
        cabBookResponse.setDriverName(cab.getDriver().getName());
        cabBookResponse.setOtp(System.currentTimeMillis());
        return cabBookResponse;
    }
}
