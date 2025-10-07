package ke.don.scope_exampl

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.stack.StackEvent
import cafe.adriel.voyager.navigator.Navigator
import ke.don.scope_exampl.datasource.CheckoutScope
import ke.don.scope_exampl.ui.CartScreen
import ke.don.scope_exampl.ui.HomeScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

import scopeexampl.composeapp.generated.resources.Res
import scopeexampl.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        KoinContext{
            Navigator(HomeScreen){ navigator ->
                AnimatedContent(
                    targetState = navigator.lastItem,
                    transitionSpec = {
                        if (navigator.lastEvent == StackEvent.Pop) {
                            (scaleIn(initialScale = 1.2f) + fadeIn()) togetherWith
                                    (scaleOut(targetScale = 0.8f) + fadeOut())
                        } else {
                            (scaleIn(initialScale = 0.8f) + fadeIn()) togetherWith
                                    (scaleOut(targetScale = 1.2f) + fadeOut())
                        }
                    },
                ) { screen ->
                    screen.Content()
                }
            }
        }
    }
}
