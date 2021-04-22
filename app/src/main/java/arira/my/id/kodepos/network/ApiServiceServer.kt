package arira.my.id.kodepos.network

import arira.my.id.kodepos.network.response.*
import io.reactivex.Observable
import retrofit2.http.*

interface ApiServiceServer {
    @GET("data/kode")
    fun kodepos(
            @Query("kode") kode:String
    ): Observable<DefaultResponse>
}