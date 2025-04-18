//package com.example.demo2.service;
//
//import com.example.demo2.repository.UserEntryRepo;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.*;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//
//import static  org.mockito.Mockito.*;
//
//
//public class UserDetailsServiceImplTests {
//
////    @InjectMocks
////    private UserDetailsServiceImpl userDetailsService;
////
////    @Mock
////    private UserEntryRepo userRepository;
////
////    @BeforeEach
////    void setUp(){
////        MockitoAnnotations.initMocks(this);
////    }
////
////    @Test
////    void loadUserByUsernameTest(){
////        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn((com.example.demo2.entity.User) User.builder().username("ram").password("inrinrick").roles("User").build());
////        UserDetails user = userDetailsService.loadUserByUsername("ram");
////        Assertions.assertNotNull(user);
////    }
//}