package arira.my.id.kodepos.network

import arira.my.id.kodepos.BuildConfig
import arira.my.id.kodepos.helper.Config.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ClientService {

    fun create(file:Boolean): ApiServiceServer {
        var cTO:Long = 30
        var wTO:Long = 30
        var rTO:Long = 30

        if (file){
            cTO = 60
            wTO = 60
            rTO = 60
        }
        val interceptor = HttpLoggingInterceptor(Logger())
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient: OkHttpClient
        if (!BuildConfig.DEBUG) {
            okHttpClient = OkHttpClient.Builder()
                .connectTimeout(cTO, TimeUnit.SECONDS)
                .writeTimeout(wTO, TimeUnit.SECONDS)
                .readTimeout(rTO, TimeUnit.SECONDS)
                .build()
        } else {
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor) //iterceptor hanya untuk debug link tidak untuk release
            .connectTimeout(cTO, TimeUnit.SECONDS)
            .writeTimeout(wTO, TimeUnit.SECONDS)
            .readTimeout(rTO, TimeUnit.SECONDS)
            .build()
        }

        var url = BASE_URL



        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl(url)
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiServiceServer::class.java)
    }

}