package io.kaeawc.instagram

import io.kaeawc.instagram.models.MediaResult
import io.kaeawc.instagram.models.MediaSearchResults
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Path

interface InstagramApi {

    // Get information about a media object.
    @GET("/media/:mediaId")
    fun getMediaById(@Path("mediaId") id: String): Observable<MediaResult>

    @GET("/users/:userId/media/recent")
    fun getRecentUserMedia(
            @Path("userId") userId: String,
            @Path("access_token") accessToken: String,
            @Path("maxId") maxId: String,
            @Path("minId") minId: String,
            @Path("count") count: Int
    ): Observable<MediaSearchResults>


//    PARAMETERS
//    ACCESS_TOKEN	A valid access token.
//    MAX_ID	Return media earlier than this max_id.
//    MIN_ID	Return media later than this min_id.
//    COUNT	Count of media to return.
}
