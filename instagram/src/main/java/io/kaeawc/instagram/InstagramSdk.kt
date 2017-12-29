package io.kaeawc.instagram

import io.kaeawc.instagram.models.Media
import io.kaeawc.instagram.models.MediaResult
import io.reactivex.Observable

interface InstagramSdk {

    fun configure()
    fun setLogLevel(level: Int)
    fun getMediaById(id: String): Observable<MediaResult>
    fun getMyMedia(): Observable<List<Media>>
    fun getMyPhotos(): Observable<List<Media>>
    fun getMyVideos(): Observable<List<Media>>
}
