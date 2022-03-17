package com.arpitparekh.kotlinafternoonbatch.api_calling_retrofit_sir_private

import com.google.gson.annotations.SerializedName

data class Note(

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null


){

	override fun toString(): String {
		return body.toString()
	}
}
