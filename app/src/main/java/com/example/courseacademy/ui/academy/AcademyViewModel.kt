package com.example.courseacademy.ui.academy

import androidx.lifecycle.ViewModel
import com.example.courseacademy.data.CourseEntity
import com.example.courseacademy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): ArrayList<CourseEntity> = DataDummy.generateDummyCourse()
}