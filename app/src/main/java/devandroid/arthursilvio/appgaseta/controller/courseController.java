package devandroid.arthursilvio.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.arthursilvio.appgaseta.model.Course;

public class courseController {

    private List listCourses;

    public List getListCourses() {
        listCourses = new ArrayList<Course>();

        listCourses.add(new Course("A.D.S"));
        listCourses.add(new Course("HTML"));
        listCourses.add(new Course("T.I"));
        listCourses.add(new Course("DESENVOLVIMENTO WEB"));
        listCourses.add(new Course("DESENVOLIVMENTO BACK-END"));
        listCourses.add(new Course("DESIGN"));
        listCourses.add(new Course("DESENVOLVIMENTO ANDROID"));
        listCourses.add(new Course("AGRO"));
        listCourses.add(new Course("CIÊNCIA DA COMPUTAÇÃO"));

        return listCourses;
    }

    public ArrayList<String> dataSpinner() {

        ArrayList<String> dataCourse = new ArrayList<>();

        for (int i = 0; i < getListCourses().size(); i++) {
            Course object = (Course) getListCourses().get(i);
            dataCourse.add(object.getCourse());
        }

        return dataCourse;

    }
}
