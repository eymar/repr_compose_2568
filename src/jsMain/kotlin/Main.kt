import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        Test()
    }
}

@Composable
fun Test() {
    var counter by remember { mutableStateOf(0) }

    if (counter % 2 == 0) {
        P({ classes(AppStylesheet.counter) }) {
            Text("$counter < Even")
        }
    } else {
        P({ classes(AppStylesheet.counter) }) {
            Text("$counter < Odd")
        }
    }

    Button({ onClick { counter++ } }) {
        Text("Increment")
    }
}

object AppStylesheet : StyleSheet() {
    val counter by style {
        fontWeight("bold")
    }
}

