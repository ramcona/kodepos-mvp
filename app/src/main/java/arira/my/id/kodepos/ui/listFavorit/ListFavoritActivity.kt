package arira.my.id.kodepos.ui.listFavorit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import arira.my.id.kodepos.R
import arira.my.id.kodepos.adapter.KodePosAdapter
import arira.my.id.kodepos.app.App.Companion.db
import arira.my.id.kodepos.model.KodePos
import arira.my.id.kodepos.ui.main.ActionView
import kotlinx.android.synthetic.main.activity_list_favorit.*

class ListFavoritActivity : AppCompatActivity(),ActionView {
    var listFav:ArrayList<KodePos> = ArrayList()
    lateinit var adapter:KodePosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favorit)

        supportActionBar?.title = "Daftar Favorit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        db?.posDao()?.getAll()?.let { listFav.addAll(it) }

        adapter = KodePosAdapter(listFav, this)

        fav_rv_data.layoutManager = LinearLayoutManager(this)
        fav_rv_data.adapter = adapter

        checkUpdate()
    }

    fun checkUpdate(){
        if (listFav.size > 0){
            fav_lin_view_kosong.visibility = View.GONE

        }else{
            fav_lin_view_kosong.visibility = View.VISIBLE
        }

        adapter.notifyDataSetChanged()
    }

    override fun onFav(kodePos: KodePos, position: Int) {
        checkUpdate()
    }

    override fun onOpenMaps(kodePos: KodePos) {
        val url = "https://www.google.com/maps?q=${kodePos.urban}+${kodePos.sub_district}+${kodePos.postal_code}+Indonesia"

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}