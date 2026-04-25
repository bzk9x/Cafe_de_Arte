package com.bzk9x.cafdearte.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bzk9x.cafdearte.R
import com.bzk9x.cafdearte.home.HomeActivity
import com.bzk9x.cafdearte.ui.theme.CaféDeArteTheme
import com.bzk9x.cafdearte.ui.theme.Sora

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaféDeArteTheme {
                Onboarding()
            }
        }
    }
}

@Composable
fun Onboarding() {
    Surface(
        color = Color.Black,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.onboarding_coffee),
                        contentDescription = "Coffee",
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Column (
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(
                            text = "Fall in Love with Coffee in Blissful Delight!",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .fillMaxWidth(),
                            fontSize = 32.sp,
                            lineHeight = 48.sp,
                            fontFamily = Sora,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Welcome to our cozy coffee corner, where every cup is a delightful for you.",
                            color = Color(0xFFA2A2A2),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            fontFamily = Sora,
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                        )
                        val context = LocalContext.current
                        Button(
                            onClick = {
                                val homeActivity = Intent(context, HomeActivity::class.java)
                                context.startActivity(homeActivity)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, bottom = 60.dp)
                        ) {
                            Text(
                                text = "Get Started",
                                fontFamily = Sora,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaféDeArteTheme {
        Onboarding()
    }
}