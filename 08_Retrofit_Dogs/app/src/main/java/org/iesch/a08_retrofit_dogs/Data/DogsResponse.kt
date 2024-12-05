package org.iesch.a08_retrofit_dogs.Data

import android.provider.MediaStore.Images
import com.google.gson.annotations.SerializedName

data class DogsResponse (
    @SerializedName ("status") var status: String,
    @SerializedName ("message") var imagesList: List<String>
)