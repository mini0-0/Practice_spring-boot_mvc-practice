package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class QuerStringsTest {
    @Test
    void createTest() {
        QueryStrings querStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

        assertThat(querStrings).isNotNull();
    }
}
