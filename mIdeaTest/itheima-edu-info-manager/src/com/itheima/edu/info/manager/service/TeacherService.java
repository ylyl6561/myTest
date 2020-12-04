package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();

    public boolean isExist(String addId) {
        Teacher[] teachers = teacherDao.findAllTeachers();
        boolean exists = false;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null && t.getId().equals(addId)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public boolean addTeacher(Teacher teacher) {
        boolean result = teacherDao.addTeacher(teacher);
        return result;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeachers();

        boolean flag = false;

        for (int i = 0; i < allTeacher.length; i++) {
            Teacher teacher = allTeacher[i];
            if(teacher != null){
                flag = true;
                break;

            }
        }
        if(flag){
            return allTeacher;
        }else {
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(String id, Teacher teacher) {
        teacherDao.updateTeacher(id,teacher);
    }
}
