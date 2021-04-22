package arira.my.id.kodepos.helper

import android.content.Context
import android.content.Intent
import arira.my.id.kodepos.network.ClientService
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog
import io.reactivex.disposables.Disposable

open class BaseHelper(ctx: Context) {

    val ApiServiceServer by lazy { ClientService().create(false) }
    var disposable: Disposable? = null


}

