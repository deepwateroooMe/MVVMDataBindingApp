package com.me.sample.model

data class Article (
    val datas: List<Data>,
    val pagination: Pagination,
    val meta: Meta
)

// "data": [],
// "meta": {
//     "status": 401,
//     "msg": "No API key found in request.",
//     "response_id": ""
// }