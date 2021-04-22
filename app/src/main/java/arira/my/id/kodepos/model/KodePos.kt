package arira.my.id.kodepos.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class KodePos() :Serializable, Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "urban")
    var urban:String = ""

    @ColumnInfo(name = "sub_district")
    var sub_district:String = ""

    @ColumnInfo(name = "city")
    var city:String = ""

    @ColumnInfo(name = "province_code")
    var province_code:String = ""

    @ColumnInfo(name = "postal_code")
    var postal_code:String = ""

    @ColumnInfo(name = "province_name")
    var province_name:String = ""

    @ColumnInfo(name = "province_name_en")
    var province_name_en:String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        urban = parcel.readString().toString()
        sub_district = parcel.readString().toString()
        city = parcel.readString().toString()
        province_code = parcel.readString().toString()
        postal_code = parcel.readString().toString()
        province_name = parcel.readString().toString()
        province_name_en = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(urban)
        parcel.writeString(sub_district)
        parcel.writeString(city)
        parcel.writeString(province_code)
        parcel.writeString(postal_code)
        parcel.writeString(province_name)
        parcel.writeString(province_name_en)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KodePos> {
        override fun createFromParcel(parcel: Parcel): KodePos {
            return KodePos(parcel)
        }

        override fun newArray(size: Int): Array<KodePos?> {
            return arrayOfNulls(size)
        }
    }


}