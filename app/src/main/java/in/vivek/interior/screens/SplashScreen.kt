package `in`.vivek.interior.screens

import `in`.vivek.interior.R
import `in`.vivek.interior.ui.theme.colorgreeen
import `in`.vivek.interior.ui.theme.colorWhite
import `in`.vivek.interior.ui.theme.colorpurple
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current
    val slow = 700
    val fast = 300


    var isAnimStart by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit, block = {
        delay(500L)
        isAnimStart = true
        delay(1200L)
        navController.navigate("home")
    })

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(colorpurple),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(

            painter = painterResource(R.drawable.hom),

            //imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = "null",
            tint = colorWhite,
            modifier = Modifier.size(40.dp)
        )
        AnimatedVisibility(
            visible = isAnimStart,
            enter = fadeIn(
                animationSpec = tween(durationMillis = fast)
            ) + expandHorizontally(
                expandFrom = Alignment.End,
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            ) + shrinkHorizontally(
                shrinkTowards = Alignment.End,
                animationSpec = tween(
                    durationMillis = slow,
                    easing = FastOutLinearInEasing,
                )
            )
        ) {
            Row(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = "Inte",
                    color = colorWhite,
                    modifier = Modifier.padding(start = 0.dp),
                    style = `in`.vivek.interior.ui.theme.Typography.h1
                )
                Text(
                    text = "rior",
                    color = colorWhite,
                    style = `in`.vivek.interior.ui.theme.Typography.h1
                )
            }
        }
    }
}

