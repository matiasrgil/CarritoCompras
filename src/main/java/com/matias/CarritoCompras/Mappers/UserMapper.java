package com.matias.CarritoCompras.Mappers;

import com.matias.CarritoCompras.Entities.Dtos.UserDto;
import com.matias.CarritoCompras.Entities.User;

public class UserMapper {

    public static User dtoToUser(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setAdress(dto.getAdress());
        user.setPostal_Code(dto.getPostal_Code());
        user.setTelephone(dto.getTelephone());
        user.setAge(dto.getAge());
        user.setName(dto.getName());

        return user;
    }

    public static UserDto userToDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setPassword(noViewPassword(user));
        dto.setEmail(user.getEmail());
        dto.setAdress(user.getAdress());
        dto.setPostal_Code(user.getPostal_Code());
        dto.setTelephone(user.getTelephone());
        dto.setAge(user.getAge());
        dto.setId(user.getId());

        return dto;
    }

    public static String noViewPassword(User user) {
        int cantCharacter = user.getPassword().length();
        return "*".repeat(cantCharacter);
    }

}
