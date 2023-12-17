package com.goit.eugene.to_do_list.service;

import com.goit.eugene.to_do_list.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final static String TEST_USER_NAME = "Ivan";
    @Mock
    private UserService userService;

    @Test
    void getUserByIdTest(){
        //GIVEN
        User expectedUser = createTestUser();
        //WHEN
        Mockito.when(userService.getUserById(TEST_USER_NAME)).thenReturn(expectedUser);
        //THEN
        User actualUser = userService.getUserById(TEST_USER_NAME);
        System.out.println(actualUser.getPassword());

        Assertions.assertEquals(expectedUser.getName(), actualUser.getName());
    }

    private User createTestUser() {
        User user = new User();
        user.setRole("ROLE_USER");
        user.setPassword("password");
        user.setEnabled(true);
        user.setName("Ivan");
        return user;
    }

}