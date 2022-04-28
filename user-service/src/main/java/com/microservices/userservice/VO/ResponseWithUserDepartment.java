package com.microservices.userservice.VO;

import com.microservices.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWithUserDepartment {
    private Department department;
    private User user;
}
