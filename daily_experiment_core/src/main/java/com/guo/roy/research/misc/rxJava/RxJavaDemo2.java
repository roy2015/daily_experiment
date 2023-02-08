package com.guo.roy.research.misc.rxJava;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2019/8/23.
 *
 * 对map/ flatMap的认识
 * 区别主要是对传入的Func的处理，flatMap把Func产生的lis<E>, 返回的是List<E>,
 * 达到打平的目的， 而map的func只  是返回E,map返回List<E>
 */
public class RxJavaDemo2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(RxJavaDemo2.class);


    public static List<School> prepareData() {
        School school1 = new School();
        school1.setName("school_1");
        List<School.Student> school1_students = new ArrayList<>();
        school1.setStudentList(school1_students);

        School school2 = new School();
        school2.setName("school_2");
        List<School.Student> school2_students = new ArrayList<>();
        school2.setStudentList(school2_students);

        School.Student school_1_student_1 = new School.Student("school_1_student_1");
        School.Student school_1_student_2 = new School.Student("school_1_student_2");
        School.Student school_2_student_1 = new School.Student("school_2_student_1");
        School.Student school_2_student_2 = new School.Student("school_2_student_2");
        School.Student school_2_student_3 = new School.Student("school_2_student_3");
        school1_students.add(school_1_student_1);
        school1_students.add(school_1_student_2);
        school2_students.add(school_2_student_1);
        school2_students.add(school_2_student_2);
        school2_students.add(school_2_student_3);

        ArrayList<School> schools = new ArrayList<>();
        schools.add(school1);
        schools.add(school2);
        return schools;
    }

    public static void test1() {
        List<School> schools = prepareData();


        Observable.fromArray(schools.toArray(new School[0]))
                .flatMap( school -> {
                       return Observable.fromArray(school.getStudentList().toArray(new School.Student[0]));
                })
                .subscribe( data -> {
                    LOGGER.info(data.toString());
                });
    }

    public static void main(String[] args) {
        test1();
    }

}
