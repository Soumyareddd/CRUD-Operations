package com.example.microserviceloginform.controller;

import com.example.microserviceloginform.entity.LoginEntity;
import com.example.microserviceloginform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")                //database table address
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("")
    public List<LoginEntity> list(){
        return loginService.listAllLoginEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginEntity> get(@PathVariable Integer id){
        try {
            LoginEntity loginEntity = loginService.getLoginEntity(id);
            return new ResponseEntity<LoginEntity>(loginEntity, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<LoginEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody LoginEntity loginEntity ) {
        loginService.saveLoginEntity(loginEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LoginEntity loginEntity, @PathVariable Integer id) {
        try {
            LoginEntity existLoginEntity = loginService.getLoginEntity(id);
            loginEntity.setId(id);
            loginService.saveLoginEntity(loginEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        loginService.deleteLoginEntity(id);
    }




}
