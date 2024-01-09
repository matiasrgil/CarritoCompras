package com.matias.CarritoCompras.Servicies;

import com.matias.CarritoCompras.Entities.Dtos.UserDto;
import com.matias.CarritoCompras.Entities.User;
import com.matias.CarritoCompras.Exceptions.Users.*;
import com.matias.CarritoCompras.Mappers.UserMapper;
import com.matias.CarritoCompras.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> getUsers() {
        return repository.findAll().stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario con id: " + id + " no ha sido encontrado"));
        return UserMapper.userToDto(user);
    }

    public UserDto createUser(UserDto user) {
        User entity = UserMapper.dtoToUser(user);

        validateField(user.getName(), UserService::nameValidator, () -> new NameInvalid("Formato de nombre inválido"));
        validateField(user.getPassword(), UserService::passwordValidator, () -> new NameInvalid("Formato de contraseña inválido"));
        validateField(user.getEmail(), UserService::emailValidator, () -> new EmailInvalid("Formato de correo inválido"));
        validateField(user.getPostal_Code(), UserService::postal_CodeValidator, () -> new postal_CodeInvalid("Formato de código postal inválido"));
        validateField(user.getTelephone(), UserService::telephoneValidator, () -> new TelephoneInvalid("Formato de telefono inválido"));
        validateField(user.getAge(), UserService::ageValidator, () -> new AgeInvalid("Formato de edad inválido"));

        checkDuplicate(user.getEmail(), email -> repository.findByEmail(email) != null, "Email duplicado");

        User entitySaved = repository.save(entity);
        user = UserMapper.userToDto(entitySaved);
        return user;
    }


    public UserDto updateUserById(Long id, UserDto user) {
        if (repository.existsById(id)) {
            User userToModify = repository.findById(id).get();

            if (!(Objects.isNull(user.getName()))) {
                validateField(user.getName(), UserService::nameValidator, () -> new NameInvalid("Formato de nombre inválido"));
                userToModify.setName(user.getName());
            }

            if (!(Objects.isNull(user.getPassword()))) {
                validateField(user.getPassword(), UserService::passwordValidator, () -> new PassInvalid("Formato de contraseña inválido"));
                userToModify.setPassword(user.getPassword());
            }

            if (!(Objects.isNull(user.getEmail()))) {
                validateField(user.getEmail(), UserService::emailValidator, () -> new EmailInvalid("Formato de correo inválido"));
                userToModify.setEmail(user.getEmail());
            }

            if (!(Objects.isNull(user.getPostal_Code()))) {
                validateField(user.getPostal_Code(), UserService::postal_CodeValidator, () -> new postal_CodeInvalid("Formato de código postal inválido"));
                userToModify.setPostal_Code(user.getPostal_Code());
            }

            if (!(Objects.isNull(user.getTelephone()))) {
                validateField(user.getTelephone(), UserService::telephoneValidator, () -> new TelephoneInvalid("Formato de telefono inválido"));
                userToModify.setTelephone(user.getTelephone());
            }

            if (!(Objects.isNull(user.getAge()))) {
                validateField(user.getAge(), UserService::ageValidator, () -> new AgeInvalid("Formato de edad inválido"));
                userToModify.setAge(user.getAge());
            }

            User userModify = repository.save(userToModify);

            return UserMapper.userToDto(userModify);
        } else {
            throw new UserNotFoundException("El usuario con id: " + id + " no ha sido encontrado");

        }
    }

    public static <T> void validateField(T fieldValue, Predicate<T> validator, Supplier<RuntimeException> exceptionSupplier) {
        Optional.of(fieldValue)
                .filter(validator)
                .orElseThrow(exceptionSupplier);
    }

    public static Boolean passwordValidator(String pass) {
        Matcher matcher = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=*!])(?!.*\\s).{8,16}$").matcher(pass);
        return matcher.matches();
    }

    public static Boolean nameValidator(String name) {
        Matcher matcher = Pattern.compile("^[a-zA-Z]{1,50}$").matcher(name);
        return matcher.matches();
    }

    public static Boolean postal_CodeValidator(String code) {
        Matcher matcher = Pattern.compile("^[0-9]{1,5}$").matcher(code);
        return matcher.matches();
    }

    public static Boolean emailValidator(String mail) {
        Matcher matcher = Pattern.compile("\\b[a-z.%-]+@[-.a-z]+\\.[a-z]{2,4}\\b").matcher(mail);
        return matcher.matches();
    }

    public static Boolean telephoneValidator(String phone) {
        Matcher matcher = Pattern.compile("^[0-9]{10}$").matcher(phone);
        return matcher.matches();
    }

    public static Boolean ageValidator(String age) {
        Matcher matcher = Pattern.compile("^[0-9]{1,2}$").matcher(age);
        return matcher.matches();
    }

    public static <T> void checkDuplicate(T value, Predicate<T> existsCheck, String errorMessage) {
        if (existsCheck.test(value)) {
            throw new UserMailDuplicated(errorMessage);
        }
    }
}