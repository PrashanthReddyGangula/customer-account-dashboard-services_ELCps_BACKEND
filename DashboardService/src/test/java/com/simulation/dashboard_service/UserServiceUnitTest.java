package com.simulation.dashboard_service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

import com.simulation.dashboard_service.entity.User;
import com.simulation.dashboard_service.service.JWTService;
import com.simulation.dashboard_service.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    private AuthenticationManager authManager;

    @Mock
    private JWTService jwtService;

    @InjectMocks
    private UserService userService;

    @Test
    public void testVerifyUser_Success() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        Authentication authentication = Mockito.mock(Authentication.class);

        Mockito.when(authManager.authenticate(Mockito.any(Authentication.class))).thenReturn(authentication);
        Mockito.when(jwtService.generateToken("username")).thenReturn("token123");

        String token = userService.verify(user);
        Assertions.assertEquals("token123", token);
    }

    @Test
    public void testVerifyUser_Fail() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("Wrongpassword");
        Mockito.when(authManager.authenticate(Mockito.any(Authentication.class)))
               .thenThrow(new BadCredentialsException("Bad credentials"));

        String result = userService.verify(user);
        Assertions.assertEquals("fail", result);
    }
}

