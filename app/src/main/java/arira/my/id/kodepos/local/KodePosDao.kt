package arira.my.id.kodepos.local

import androidx.room.*
import arira.my.id.kodepos.model.KodePos

@Dao
interface KodePosDao {

    @Query("SELECT * FROM kodepos ORDER BY id DESC")
    fun getAll(): List<KodePos>

    @Query("SELECT * FROM kodepos WHERE id = :ids ")
    fun getById(ids:Int): KodePos
    @Insert
    fun insertProduk(vararg produk: KodePos)

    @Update
    fun updateProduk(vararg produk: KodePos)

    @Delete
    fun deleteProduk(vararg produk: KodePos)
}