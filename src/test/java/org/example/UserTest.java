package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    @DisplayName("password 초기화함")
    @Test
    void passWordTest() {
        User user = new User();
        user.initPassword(new CorrectFixedPasswordGenerator());
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("password가 요구사항에 부합되지 않아 초기화 되지 않음")
    @Test
    void passWordTest2() {
        User user = new User();
        user.initPassword(new WrongFixedPasswordGenerator());
        assertThat(user.getPassword()).isNull();
    }
}