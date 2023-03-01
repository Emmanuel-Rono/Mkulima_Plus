package com.example.mkulima_plus.View

import android.os.Parcel
import android.os.Parcelable

class cropsModel(val images:Int, val textname: String?):Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(images)
        parcel.writeString(textname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<cropsModel> {
        override fun createFromParcel(parcel: Parcel): cropsModel {
            return cropsModel(parcel)
        }

        override fun newArray(size: Int): Array<cropsModel?> {
            return arrayOfNulls(size)
        }
    }

}


