//package com.example.demo2.service;
//
//import com.example.demo2.repository.UserEntryRepo;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//@SpringBootTest
//public class UserServiceTests {
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected,a+b);
//    }
//
//
//    @Autowired
//    private UserEntryRepo entryRepo;
//
//    @ParameterizedTest
//    @ValueSource( strings = {"Yash", "Ram", "Rohit"})
//    public void testFindUserName(String name){
//        assertNotNull(entryRepo.findByUserName(name),"failed for "+name);
//    }
//}
