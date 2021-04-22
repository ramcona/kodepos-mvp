package arira.my.id.kodepos.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import arira.my.id.kodepos.R
import arira.my.id.kodepos.adapter.KodePosAdapter
import arira.my.id.kodepos.helper.Go
import arira.my.id.kodepos.model.KodePos
import arira.my.id.kodepos.ui.listFavorit.ListFavoritActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),MainViews, ActionView {
    lateinit var presenter: MainPresenter
    var sCari:String = ""
    var listKodePos:ArrayList<KodePos> = ArrayList()
    lateinit var adapter:KodePosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        presenter = MainPresenter(this, this)
        adapter = KodePosAdapter(listKodePos, this)

        main_rv_data.layoutManager =  LinearLayoutManager(this)
        main_rv_data.adapter = adapter

        main_sv_pencarian.isIconified = true
        main_sv_pencarian.onActionViewExpanded()
        main_sv_pencarian.queryHint = getString(R.string.masukan_kode_pos)

        main_tv_log_kode_pos.text = getString(R.string.hasil_pencarian_kode_pos_s, "")

        main_img_toriwayat.setOnClickListener {
            Go(this).move(target = ListFavoritActivity::class.java)
        }

        main_sv_pencarian.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                sCari = query
                presenter.get(sCari)

                main_tv_log_kode_pos.text = getString(R.string.hasil_pencarian_kode_pos_s, sCari)
                return false
            }

        })

        Handler(Looper.getMainLooper()).postDelayed({ main_sv_pencarian.clearFocus() }, 300)



    }

    override fun onLoading() {
        
    }

    override fun onSuccess(data: List<KodePos>) {

        if (data.size > 0){
            listKodePos.clear()
            listKodePos.addAll(data)

            adapter.notifyDataSetChanged()
            main_rv_data.visibility = View.VISIBLE
            main_lin_pesan_kosong.visibility = View.GONE
        }else{
            main_rv_data.visibility = View.GONE
            main_lin_pesan_kosong.visibility = View.VISIBLE

            main_tv_pesan_kosong.text = getString(R.string.tidak_ada_hasil_pencarian_kode_pos_s, sCari)
        }

    }

    override fun onFailed(msg: String) {
        main_tv_pesan_kosong.text = msg

        main_lin_pesan_kosong.visibility = View.VISIBLE
        main_tv_pesan_kosong.text = msg
        main_rv_data.visibility = View.GONE
    }

    override fun onOpenMaps(kodePos: KodePos) {
        val url = "https://www.google.com/maps?q=${kodePos.urban}+${kodePos.sub_district}+${kodePos.postal_code}+Indonesia"

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}