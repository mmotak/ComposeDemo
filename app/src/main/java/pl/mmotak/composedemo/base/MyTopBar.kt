package pl.mmotak.composedemo.base

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.mmotak.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun MyTopBar(
    title: String,
    onBackPressed: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (onBackPressed == null) null else {
            {
                IconButton(onClick = onBackPressed) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        },
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
            Column {
                MyTopBar(title = "PREVIEW !")
                MyTopBar(
                    title = "top bar with back arrow",
                    onBackPressed = {}
                )
                Text(text = "body")
            }
        }
    }
}