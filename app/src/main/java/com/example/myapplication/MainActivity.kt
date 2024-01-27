package com.example.myapplication


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.button.ButtonConstants
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .background(color = Color(0xFF98939C))
                .fillMaxSize()){

                Canvas(modifier = Modifier
                    .fillMaxWidth()) {
                    drawRoundRect(
                        color = Color(0xFF8048A8),
                        size = Size(width = 384.dp.toPx() , height =300.dp.toPx() ),

                        cornerRadius = CornerRadius(x = 26.dp.toPx(), y = 26.dp.toPx())
                    )


                }
                MyUI()






            }


        }


    }
}
@Composable
fun MyUI() {
    Box {
        Canvas(
            modifier = Modifier
                .size(size = 300.dp)

        ) {
            drawRoundRect(

                color = Color(0xFFCBCBCC),
                size = Size(width = 340.dp.toPx(), height = 360.dp.toPx()),
                cornerRadius = CornerRadius(x = 26.dp.toPx(), y = 36.dp.toPx()),
                topLeft = Offset(x = 22.dp.toPx(), y = 91.dp.toPx())
            )

    }
        Column{
            Text(text = "Sign up",
                modifier = Modifier
                    .offset(x=100.dp,y=84.dp),
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold
                ))
            EmailText()
            NumberText()
            PassText()
            Butt {

            }
            Text(text="Already have an account?",
                modifier = Modifier
                    .offset(x=110.dp,y=233.dp))
            TextButt {

            }


        }

    }
}
@Composable
fun TextButt(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick()  }, modifier = Modifier
            .offset(x=258.dp,y=200.dp)
    ) {
        Text("Sign in")
    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun EmailText() {
    var value by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current.applicationContext
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .offset(x=50.dp,y=93.dp),
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        label = { Text(text = "Email") },
        placeholder = { Text(text = "Enter your Email ID") },

        keyboardActions = KeyboardActions(
            onSearch = {

                keyboardController?.hide()

            }
        )
    )
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NumberText() {
    var value by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current.applicationContext
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .offset(x=50.dp,y=103.dp),
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        label = { Text(text = "Number") },
        placeholder = { Text(text = "Enter your number") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()


            }
        )
    )
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun PassText() {
    var value by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current.applicationContext
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .offset(x=50.dp,y=113.dp),
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter your Password") },

        keyboardActions = KeyboardActions(
            onSearch = {

                keyboardController?.hide()

            }
        )
    )
}
@Composable
fun Butt(onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = Modifier
        .offset(x = 50.dp, y = 133.dp)
        .size(width = 280.dp, height = 40.dp)
        ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF891AD8),
        )) {
        Text(text="Sign up")
    }
}



