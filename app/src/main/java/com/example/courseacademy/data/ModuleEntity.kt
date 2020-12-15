package com.example.courseacademy.data

import java.text.FieldPosition

data class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: Int,
    var read: Boolean = false

) {
    var contentEntity: ContentEntity? = null
}