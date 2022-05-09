package com.example.codenwin.mapper

import com.example.codenwin.R

class ItemMapper {
    companion object {
        fun getLayoutId(widgetType: String? = null): Int {
            return when (widgetType) {
                "Status" -> R.layout.home_status
                else -> 0
            }
        }
    }
}