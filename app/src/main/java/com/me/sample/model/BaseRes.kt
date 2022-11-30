package com.me.sample.model

// 这个定义不对,因为它们的API接口设计比较特殊
class BaseRes<T> {
    var status: Int = 0
    var msg: String = ""
    var response_id: String = ""
    var data: T? = null
}
// class BaseRes<T> {
//     var data: T? = null
// }

//     "status": 401,
//     "msg": "No API key found in request.",
//     "response_id": ""
// }
