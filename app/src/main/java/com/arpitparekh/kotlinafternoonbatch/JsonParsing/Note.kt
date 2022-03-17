package com.arpitparekh.kotlinafternoonbatch.JsonParsing

data class Note(var title:String,var body : String){

    override fun toString(): String {
        return "title : $title \nbody : $body"
    }

}