package com.me.sample.model

class BaseRes<T> {
    var errorCode: Int = 0
    var errorMsg: String = ""
    var data: T? = null
}
// data class BaseRes<T> (
//     var data: T? = null
// )
