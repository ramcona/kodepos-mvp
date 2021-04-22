package arira.my.id.kodepos.app

import androidx.room.Database
import androidx.room.RoomDatabase
import arira.my.id.kodepos.local.KodePosDao
import arira.my.id.kodepos.model.KodePos


@Database(entities = [KodePos::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun posDao(): KodePosDao?
}