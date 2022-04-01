package com.example.web_demo0.Service

import com.example.web_demo0.Model.Entity.User
import com.example.web_demo0.Model.Enum.Gender
import com.example.web_demo0.Model.Enum.Role
import com.example.web_demo0.Model.dto.UserDto
import com.example.web_demo0.Repository.UserRepository
import com.example.web_demo0.Service.Impl.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {
    private UserRepository userRepository = Mock();
    private UserService userService = new UserServiceImpl(userRepository);

    def "test create(User user)"(){
        User user = User.builder().role(Role.ADMIN).gender(Gender.MALE).username("a").firstName("a")
                .lastName("a").email("a").password("a").build()

        when:

        userService.create(user)
        then:

        1*userRepository.save(user)

    }

    def "test getAll()"(){
        List<UserDto> userDtoList = new ArrayList<>();

        UserDto userDto = UserDto.builder().email("a").username("a").build()

        List<User> userList = new ArrayList<>();

        User user = User.builder().email("a").username("a").build()

        userDtoList.add(userDto)
        userList.add(user)

        when:
        def result = userService.getAll()
        then:

        1*userRepository.findAll() >> userList
        result == userDtoList
    }

    def "test delete()"(){
        def username = "mock"

        when:
        userService.deleteUserById(username)

        then:
        1*userRepository.deleteById(username)
    }
}
