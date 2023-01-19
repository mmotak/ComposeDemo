package pl.mmotak.composedemo.generic


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import pl.mmotak.composedemo.components.shimmerEffect
import kotlin.random.Random

@Composable
fun BuildScreen(
    code: GenericActivityCode
) {
    when (code) {
        GenericActivityCode.Text -> GenericActivityCode_Text(code)
        GenericActivityCode.ShimmerEffect -> GenericActivityCode_ShimmerEffect()
    }
}

@Composable
private fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        Row(modifier = modifier) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

private fun getRandomIcon(): ImageVector {
    val list = listOf(
        Icons.Default.Add,
        Icons.Default.AccountBox,
        Icons.Default.Home,
        Icons.Default.Warning,
        Icons.Default.Star,
        Icons.Default.List,
        Icons.Default.Edit,
    )

    val index = Random.nextInt(0, list.size - 1)
    return list.get(index)
}

@Composable
private fun GenericActivityCode_ShimmerEffect() {
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(Random.nextLong(3, 7) * 1000)
        isLoading = false
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(20) {
            ShimmerListItem(
                isLoading = isLoading,
                contentAfterLoading = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = getRandomIcon(),
                            contentDescription = null,
                            modifier = Modifier.size(128.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "This is a long text to show that our shimmer display " +
                                    "is looking perfectly fine"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}


@Composable
private fun GenericActivityCode_Text(code: GenericActivityCode) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(code.title)
    }
}