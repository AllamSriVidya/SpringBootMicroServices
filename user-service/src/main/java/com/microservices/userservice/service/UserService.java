package com.microservices.userservice.service;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.ResponseWithUserDepartment;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method in UserService ");
        return  userRepository.save(user);
    }

    public ResponseWithUserDepartment getUserWithDepartment(long userId) {
        log.info("Inside getUserWithDepartment in UserService ");
        ResponseWithUserDepartment responseWithUserDepartment=new ResponseWithUserDepartment();
        User user=userRepository.getByUserId(userId);
        log.info("User is {}",user);
        responseWithUserDepartment.setUser(user);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        log.info("Department is {}",department);
        responseWithUserDepartment.setDepartment(department);
        log.info("Retreived object is {}",responseWithUserDepartment);
        return responseWithUserDepartment;
    }
}
