package arira.my.id.kodepos.adapter.holder

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import arira.my.id.kodepos.R
import arira.my.id.kodepos.app.App
import arira.my.id.kodepos.app.App.Companion.db
import arira.my.id.kodepos.model.KodePos
import arira.my.id.kodepos.ui.main.ActionView

class KodePosHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tvAlamat:TextView = itemView.findViewById(R.id.ikode_tv_alamat)
    var tvKode:TextView = itemView.findViewById(R.id.ikode_tv_kodepos)
    var linMap:LinearLayout = itemView.findViewById(R.id.ikode_lin_maps)
    var imgFav:ImageView = itemView.findViewById(R.id.ikode_img_fav)

    @SuppressLint("SetTextI18n")
    fun setData(data: KodePos, views: ActionView){
        tvKode.text = data.postal_code
        tvAlamat.text = "${data.urban} ${data.sub_district}, ${data.city}, ${data.province_name}"

        if (db?.posDao()?.getById(data.id) != null){
            imgFav.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            imgFav.setImageResource(R.drawable.ic_baseline_favorite_24_unactive)
        }

        linMap.setOnClickListener {
            views.onOpenMaps(data)
        }

        imgFav.setOnClickListener {
            if (db?.posDao()?.getById(data.id) != null){
                db?.posDao()?.deleteProduk(data)
                imgFav.setImageResource(R.drawable.ic_baseline_favorite_24_unactive)
            }else{
                db?.posDao()?.insertProduk(data)
                imgFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }

        }
    }

}