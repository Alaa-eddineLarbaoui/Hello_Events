package com.example.Event.Controller;


import com.example.Event.Dto.LoginResponse;
import com.example.Event.Dto.SigninRequestDto;
import com.example.Event.config.JwtHelper;
import com.example.Event.enums.role;
import com.example.Event.modal.User;
import com.example.Event.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthentificationController {
    @Autowired
    AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthentificationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody User requestDto) {
        requestDto.setRole(role.USER);
        userService.signUp(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody SigninRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        System.out.println("ussseerrr :"+request.username() + " paaaasssss :" + request.password() );


        User user = userService.findUserByUsername(request.username());
        String token = JwtHelper.generateToken(request.username(),user.getRole());
        System.out.println("token---->"+token);
        LoginResponse response = new LoginResponse(token, user);
        return ResponseEntity.ok(response);
    }

}


