package arira.my.id.kodepos.ui.main

import arira.my.id.kodepos.model.KodePos

interface ActionView {
    fun onFav(kodePos: KodePos, position:Int){

    }

    fun onOpenMaps(kodePos: KodePos){

    }
}