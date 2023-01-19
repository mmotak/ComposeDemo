package pl.mmotak.composedemo.generic
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class GenericActivityCode(
    val title: String,
) : Parcelable {
    Text("Centered text"),
    ShimmerEffect("Shimmer Effect"),
}