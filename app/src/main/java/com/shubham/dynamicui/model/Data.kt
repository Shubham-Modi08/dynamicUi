package com.shubham.dynamicui.model

data class Data(
    val accessibilityType: List<AccessibilityType>,
    val displayName: String,
    val fieldSize: String,
    val fieldType: String,
    val isMandetory: String,
    val order: String,
    val placeholder: String,
    val processDataName: String,
    val properties: Properties,
    val validationRules: List<ValidationRule>
)