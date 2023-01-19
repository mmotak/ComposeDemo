package pl.mmotak.composedemo.generic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import pl.mmotak.composedemo.base.MyTopBar
import pl.mmotak.composedemo.ui.theme.ComposeDemoTheme


class GenericActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val code: GenericActivityCode = intent?.getParcelableExtra(KEY) ?: GenericActivityCode.ShimmerEffect

        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        MyTopBar(
                            title = code.title,
                            onBackPressed = { finish() }
                        )
                        BuildScreen(code)
                    }
                }
            }
        }
    }

    companion object {
        const val KEY = "GENERIC_KEY"
    }
}