package arira.my.id.kodepos.helper

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import arira.my.id.kodepos.R
import arira.my.id.kodepos.helper.Config.extra_id
import arira.my.id.kodepos.helper.Config.extra_model
import arira.my.id.kodepos.helper.Config.extra_type
import arira.my.id.kodepos.helper.Config.extra_url

class Go(var ctx:Context){


    /*===== METODA v.3 ===== */

    fun move(target: Class<*>, type:String = "", id:String = "", listData: List<Parcelable> = ArrayList(), data: Parcelable? = null, url:String = ""){
        val listParcelable:ArrayList<Parcelable> = ArrayList()
        listParcelable.addAll(listData)

        val go  = Intent(ctx, target)
        go.putExtra(extra_id, id)
        go.putExtra(extra_type, type)
        go.putExtra(Config.extra_list, listParcelable)
        go.putExtra(extra_url, url)
        if (data !=null){
            go.putExtra(extra_model, data)
        }

        ctx.startActivity(go)
    }

    /*===== ANOTHER HELPER  = ======== */

    fun shareText(text:String, context: Context){
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(Intent.createChooser(i, context.getString(R.string.pilih_aplikasi)))
    }

}