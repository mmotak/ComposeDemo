package pl.mmotak.composedemo.base

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.mmotak.composedemo.Greeting
import pl.mmotak.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun MyTopBar(
    title: String,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
//        navigationIcon = {
//            IconButton(onClick = { }) {
//                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
//            }
//        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 2.dp
    )
}

@Preview(
    name = "DARK",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "LIGHT",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun PreviewMyTopBar() {
    ComposeDemoTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column  {
                MyTopBar(title = "PREVIEW !")
                Text(text = "body")
            }
        }
    }
}