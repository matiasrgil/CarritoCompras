package com.matias.CarritoCompras.Controllers;

import com.matias.CarritoCompras.Entities.Dtos.UserDto;
import com.matias.CarritoCompras.Entities.User;
import com.matias.CarritoCompras.Servicies.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable @Valid Long id, @RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUserById(id, user));
    }

}
