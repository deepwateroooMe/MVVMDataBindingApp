package com.me.sample.model

class Meta {
    val status: Int = 200
    var msg: String = "OK"
    var response_id: String = "61732"

    override fun toString() : String {
        return "meta: (status=$status, msg=$msg, response_id=$response_id)"
    }
}

//     "status": 401,
//     "msg": "No API key found in request.",
//     "response_id": ""
// }
