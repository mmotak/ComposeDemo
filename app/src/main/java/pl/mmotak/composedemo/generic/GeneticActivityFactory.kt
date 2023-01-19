package pl.mmotak.composedemo.generic

import android.content.Context
import android.content.Intent
import android.os.Parcelable

object GeneticActivityFactory {
    fun startActivity(
        context: Context,
        genericActivityCode: GenericActivityCode
    ) {
        val intent = Intent(context, GenericActivity::class.java)
        intent.putExtra(GenericActivity.KEY, genericActivityCode as Parcelable)
        context.startActivity(intent)
    }
}