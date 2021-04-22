package arira.my.id.kodepos.ui.main

import android.app.Activity
import arira.my.id.kodepos.helper.BaseHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val context: Activity, var views:MainViews) : BaseHelper(context) {

    fun get(kode:String){
        

        views.onLoading()
         disposable = ApiServiceServer.kodepos(kode)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(
                         { result ->
                             when(result.code){
                                 1 -> {
                                     views.onSuccess(result.data)
                                 }
                                 else ->{
                                     views.onFailed(result.message)
                                 }
                             }
                         },
                         { error ->
                             views.onFailed(error.message.toString())
                         }

                     )

    }



}