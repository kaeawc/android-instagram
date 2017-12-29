package io.kaeawc.instagram

import android.app.Application
import io.kaeawc.instagram.models.Media
import io.kaeawc.instagram.models.MediaResult
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal class Instagram(val app: Application) : InstagramSdk {

    companion object {
        @JvmStatic fun init(app: Application): InstagramSdk {
            return Instagram(app)
        }
    }

    private val okhttp = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

    private val api = Retrofit.Builder()
            .baseUrl("https://www.instagram.com")
            .client(okhttp)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(InstagramApi::class.java)

    override fun configure() {
        TODO()
    }

    override fun setLogLevel(level: Int) {
        TODO()
    }

    override fun getMediaById(id: String): Observable<MediaResult> {
        return api.getMediaById(id)
    }

    override fun getMyMedia(): Observable<List<Media>> {
        return api.getMyMedia()
    }

    override fun getMyPhotos(): Observable<List<Media>> {
        return api.getMyPhotos()
    }

    override fun getMyVideos(): Observable<List<Media>> {
        return api.getMyVideos()
    }
}
