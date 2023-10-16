package com.example.simplemvvmrecyclerviewdemo

import com.example.simplemvvmrecyclerviewdemo.util.global.GlobalConfig.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitHelper {
    private var retrofit: Retrofit? = null

    /**接取API http設定 */
    fun getRetrofitClient(): Retrofit? {
        val levelType: HttpLoggingInterceptor.Level = if (BuildConfig.BUILD_TYPE.contentEquals("debug")){
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        val logging = HttpLoggingInterceptor()
        logging.level = levelType

        if (retrofit == null) {
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            retrofit = Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }

        return retrofit
    }
}