package com.microservices.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private long departmentid;
    private String departmentname;
    private String departmentaddress;
    private String departmentcode;
}
