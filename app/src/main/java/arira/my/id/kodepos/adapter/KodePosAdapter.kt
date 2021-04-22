package arira.my.id.kodepos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arira.my.id.kodepos.R
import arira.my.id.kodepos.adapter.holder.KodePosHolder
import arira.my.id.kodepos.model.KodePos
import arira.my.id.kodepos.ui.main.ActionView

class KodePosAdapter(var data:ArrayList<KodePos>, var views:ActionView) : RecyclerView.Adapter<KodePosHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KodePosHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kodepos, parent, false)
        return KodePosHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: KodePosHolder, position: Int) {
        holder.setData(data[position], views)
    }
}