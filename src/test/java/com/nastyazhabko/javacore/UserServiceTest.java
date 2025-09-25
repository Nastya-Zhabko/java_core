package com.nastyazhabko.javacore;

import com.nastyazhabko.javacore.tests.User;
import com.nastyazhabko.javacore.tests.UserRepository;
import com.nastyazhabko.javacore.tests.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void shouldReturnUserNameWhenUserExists() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        when(userRepositoryMock.findUserById(1)).thenReturn(dummyUser);

        UserService userService = new UserService(userRepositoryMock);

        String userName = userService.getUserName(1);

        assertEquals("Alice", userName);

        verify(userRepositoryMock, times(1)).findUserById(1);

    }

    @Test
    public void shouldReturnUnknownWhenUserDoesNotExist() {
        UserRepository userRepositoryMock = mock(UserRepository.class);

        when(userRepositoryMock.findUserById(2)).thenReturn(null);

        UserService userService = new UserService(userRepositoryMock);

        String userName = userService.getUserName(2);

        assertEquals("Unknown", userName);

        verify(userRepositoryMock, times(1)).findUserById(2);
    }

    @Test
    public void shouldReturnTrueWhenUserSavedCorrectly(){
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");

        when(userRepositoryMock.saveUser(dummyUser)).thenReturn(true);

        UserService userService = new UserService(userRepositoryMock);

        boolean saveStatus = userService.saveUser(dummyUser);

        assertEquals(true, saveStatus);

        verify(userRepositoryMock, times(1)).saveUser(dummyUser);
    }

    @Test
    public void shouldReturnFalseWhenSavedUserDoesNotExist(){
        UserRepository userRepositoryMock = mock(UserRepository.class);

        when(userRepositoryMock.saveUser(null)).thenReturn(false);

        UserService userService = new UserService(userRepositoryMock);

        boolean saveStatus = userService.saveUser(null);

        assertEquals(false, saveStatus);

        verify(userRepositoryMock, times(1)).saveUser(null);

    }
}
