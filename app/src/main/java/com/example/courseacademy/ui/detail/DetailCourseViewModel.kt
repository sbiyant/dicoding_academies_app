package com.example.courseacademy.ui.detail

import androidx.lifecycle.ViewModel
import com.example.courseacademy.data.CourseEntity
import com.example.courseacademy.data.ModuleEntity
import com.example.courseacademy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourses() : CourseEntity {
        lateinit var course: CourseEntity
        val courseEntities = DataDummy.generateDummyCourse()
        for (courseEntity in courseEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }

        return course
    }

    fun getModules() : ArrayList<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}