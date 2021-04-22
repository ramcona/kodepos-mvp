package arira.my.id.kodepos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arira.my.id.kodepos.R
import arira.my.id.kodepos.adapter.holder.ProvinsiHolder

class ProvinsiAdapter() : RecyclerView.Adapter<ProvinsiHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ProvinsiHolder(view)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ProvinsiHolder, position: Int) {
        holder.setData()
    }
}