package com.example.courseacademy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.courseacademy.data.CourseEntity
import com.example.courseacademy.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    fun getBookmarks() : ArrayList<CourseEntity> = DataDummy.generateDummyCourse()
}