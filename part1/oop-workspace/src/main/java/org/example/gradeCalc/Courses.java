package org.example.gradeCalc;

import java.util.List;

/*일급 컬렉션 - 특정 클래스를 컬렉션 형태로 관리하기 위한 클래스*/
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        /* 리팩토링 전*/
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;

        /* 리팩토링 후*/
        return courses.stream().mapToDouble(Course::multiplyCreditAndCourseGrade).sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream().mapToInt(Course::getCredit).sum();
    }
}
