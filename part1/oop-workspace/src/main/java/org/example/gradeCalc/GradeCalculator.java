package org.example.gradeCalc;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * • 일급 컬렉션 사용
     */
    public double gradeCalculate() {

        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade(); // (학점수×교과목 평점)의 합계
        int totalCompletedCredit = courses.calculateTotalCompletedCredit(); // 수강신청 총학점 수

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit; // 평균학점
    }
}
