package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GradeCalculatorTest {
    // 학점계산기, 코스
    // 평균학점 계산 요청 ---> '학점계산기' ---> (학점수×교과목 평점)의 합계 ---> '코스'
    //                               ---> 수강신청 총학점 수


    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP",3,"A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);

    }
}
