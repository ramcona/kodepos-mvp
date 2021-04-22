package arira.my.id.kodepos.network.response

import arira.my.id.kodepos.model.KodePos
import java.io.Serializable

class DefaultResponse : Serializable {

    val error:Boolean  = false
    val code:Int = 0
    val message:String = ""
    var data:List<KodePos> = ArrayList()

}