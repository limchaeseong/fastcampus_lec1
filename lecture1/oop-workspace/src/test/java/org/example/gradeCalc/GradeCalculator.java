package org.example.gradeCalc;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 요구사항
     * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * • 일급 컬렉션 사용
     */
    public double gradeCalculate() {

        // (학점수×교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        // 수강신청 총학점 수
        int totalCompletedCredits = courses.stream().mapToInt(Course::getCredit).sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredits; // 평균학점
    }
}
