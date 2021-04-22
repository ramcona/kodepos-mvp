package arira.my.id.kodepos.ui.main

import arira.my.id.kodepos.model.KodePos

interface MainViews {

    fun onLoading()
    fun onSuccess(data:List<KodePos>)
    fun onFailed(msg:String)
}