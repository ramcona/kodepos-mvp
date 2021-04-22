package arira.my.id.kodepos.app

import android.app.Application
import androidx.room.Room

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            getApplicationContext(),
            AppDatabase::class.java, "kodepos"
        ).allowMainThreadQueries().build()
    }

    companion object {
        var db: AppDatabase? = null
    }

}