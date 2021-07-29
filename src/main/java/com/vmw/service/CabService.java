package com.vmw.service;

import com.vmw.entity.*;
import org.springframework.stereotype.Service;

public interface CabService {
    Cab addCab(final Cab cab);
    Driver addDriver(final Driver driver);
    Customer addCustomer(final Customer customer);
    CabBookResponse bookCab(final CabBookRequest cabBookRequest);

}
