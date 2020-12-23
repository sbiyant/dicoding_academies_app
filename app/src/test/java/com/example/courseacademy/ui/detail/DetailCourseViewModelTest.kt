package com.example.courseacademy.ui.detail

import com.example.courseacademy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourse()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourses() {
        viewModel.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourses()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.description, courseEntity.description)

    }

    @Test
    fun getModules() {
        val moduleEntity = viewModel.getModules()
        assertNotNull(moduleEntity)
        assertEquals(7, moduleEntity.size)
    }
}