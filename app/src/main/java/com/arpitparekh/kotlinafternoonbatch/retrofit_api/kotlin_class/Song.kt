package com.arpitparekh.kotlinafternoonbatch.retrofit_api.kotlin_class

import com.google.gson.annotations.SerializedName

data class Song(

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("response")
	val response: Response? = null
)

data class Meta(

	@field:SerializedName("status")
	val status: Int? = null
)

data class PrimaryArtist(

	@field:SerializedName("is_meme_verified")
	val isMemeVerified: Boolean? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("iq")
	val iq: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("api_path")
	val apiPath: String? = null,

	@field:SerializedName("is_verified")
	val isVerified: Boolean? = null,

	@field:SerializedName("header_image_url")
	val headerImageUrl: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Result(

	@field:SerializedName("artist_names")
	val artistNames: String? = null,

	@field:SerializedName("lyrics_owner_id")
	val lyricsOwnerId: Int? = null,

	@field:SerializedName("annotation_count")
	val annotationCount: Int? = null,

	@field:SerializedName("song_art_image_url")
	val songArtImageUrl: String? = null,

	@field:SerializedName("primary_artist")
	val primaryArtist: PrimaryArtist? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("api_path")
	val apiPath: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("song_art_image_thumbnail_url")
	val songArtImageThumbnailUrl: String? = null,

	@field:SerializedName("full_title")
	val fullTitle: String? = null,

	@field:SerializedName("stats")
	val stats: Stats? = null,

	@field:SerializedName("title_with_featured")
	val titleWithFeatured: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("header_image_thumbnail_url")
	val headerImageThumbnailUrl: String? = null,

	@field:SerializedName("pyongs_count")
	val pyongsCount: Int? = null,

	@field:SerializedName("header_image_url")
	val headerImageUrl: String? = null,

	@field:SerializedName("lyrics_state")
	val lyricsState: String? = null
)

data class Stats(

	@field:SerializedName("pageviews")
	val pageviews: Int? = null,

	@field:SerializedName("unreviewed_annotations")
	val unreviewedAnnotations: Int? = null,

	@field:SerializedName("hot")
	val hot: Boolean? = null,

	@field:SerializedName("concurrents")
	val concurrents: Int? = null
)

data class Response(

	@field:SerializedName("hits")
	val hits: List<HitsItem?>? = null
)

data class HitsItem(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("highlights")
	val highlights: List<Any?>? = null,

	@field:SerializedName("index")
	val index: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
