package com.example.microserviceloginform.service;

import com.example.microserviceloginform.entity.LoginEntity;
import com.example.microserviceloginform.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<LoginEntity> listAllLoginEntity(){
        return loginRepository.findAll();
    }
    public void saveLoginEntity(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }
    public LoginEntity getLoginEntity(Integer id){
        return loginRepository.findById(id).get();
    }

    public void deleteLoginEntity(Integer id){
        loginRepository.deleteById(id);
    }




}
