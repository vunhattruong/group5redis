package vn.edu.uit.group5redis.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.uit.group5redis.dto.UserDto;
import vn.edu.uit.group5redis.dto.UserRequest;
import vn.edu.uit.group5redis.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDto> get (@PathVariable(name = "uuid") UUID uuid) {
        return ResponseEntity.ok(userService.getUserById(uuid));
    }

    @PostMapping
    ResponseEntity<UserDto> createUser (
        @RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

}
