package com.example.courseacademy.ui.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}