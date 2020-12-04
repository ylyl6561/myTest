package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teachers = new Teacher[5];

    public boolean addTeacher(Teacher teacher) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t == null) {
                index = i;
                break;
            }

        }

        if (index == -1) {
            return false;
        } else {
            teachers[index] = teacher;
            return true;
        }
    }


    public Teacher[] findAllTeachers() {
        return teachers;

    }

    public void deleteTeacherById(String id) {
        int index = getIndex(id);
        teachers[index] = null;

    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null && teacher.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String id, Teacher teacher) {
        int index = getIndex(id);
        teachers[index] = teacher;
    }
}
