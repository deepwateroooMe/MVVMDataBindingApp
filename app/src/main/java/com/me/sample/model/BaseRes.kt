package com.me.sample.model

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
