package pl.mmotak.composedemo.main

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.mmotak.composedemo.base.MyTopBar
import pl.mmotak.composedemo.generic.GenericActivityCode
import pl.mmotak.composedemo.generic.GeneticActivityFactory
import pl.mmotak.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        MyTopBar(
                            title = "Start",
                            showBackIconAsClose = true,
                            showBackIconAsArrow = false,
                            onBackPressed = { this@MainActivity.finish() }
                        )
                        CodesList(this@MainActivity)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowButton(
    context: Context,
    code: GenericActivityCode
) {
    Column(
        modifier = Modifier.padding(4.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { GeneticActivityFactory.startActivity(context, code) }
        ) {
            Text(text = code.title)
        }
    }
}


@Composable
fun CodesList(context: Context) {
    LazyColumn {
        items(GenericActivityCode.values().size) { index ->
            val code: GenericActivityCode = GenericActivityCode.values()[index]
            ShowButton(context, code)
        }
    }
}


@Preview(
    name = "DARK",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    name = "LIGHT",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            CodesList(LocalContext.current)
        }
    }
}