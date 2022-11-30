package com.me.sample.model

// The Pagination Object:
// The Pagination Object contains information relating to the number of total results available as well as the number of results fetched and their relative positions.

class Pagination {
    val total_count: Int = 0
    val count: Int = 0
    val offset: Int = 0
    
    override fun toString() : String {
        return "pagination: (total_count=$total_count, count=$count, offset=$offset)"
    }
}
