import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }
}

@Parcelize
data class Source(
    val id: String?,
    val name: String?
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }
}