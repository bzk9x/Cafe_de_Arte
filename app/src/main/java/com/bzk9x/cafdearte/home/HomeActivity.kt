package com.bzk9x.cafdearte.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsInputComposite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bzk9x.cafdearte.ui.theme.CaféDeArteTheme
import com.bzk9x.cafdearte.ui.theme.Sora

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaféDeArteTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF313131),
                                Color(0xFF111111)
                            ),
                            start = Offset.Zero,
                            end = Offset.Infinite
                        )
                    )
            ) {
                Column {
                    Text(
                        text = "Location",
                        color = Color(0xFFA2A2A2),
                        fontFamily = Sora,
                        modifier = Modifier
                            .padding(start = 20.dp, top = 60.dp),
                        fontSize = 12.sp
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = "Lagos, Nigeria",
                            color = Color(0xFFFFFFFF),
                            fontFamily = Sora,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 20.dp),
                            fontSize = 14.sp
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand",
                            tint = Color(0xFFA2A2A2),
                            modifier = Modifier
                                .padding(start = 5.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ) {
                        var query by remember { mutableStateOf("") }
                        TextField(
                            value = query,
                            onValueChange = { query = it },
                            placeholder = {  Text("Search Coffee") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search Coffee"
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = {  query = "" }) {
                                    Icon(Icons.Default.Close, contentDescription = "Clear")
                                }
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Search
                            ),
                            keyboardActions = KeyboardActions(
                                onSearch = {}
                            ),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFF2A2A2A),
                                unfocusedContainerColor = Color(0xFF2A2A2A)
                            ),
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
                                .weight(1f)
                        )
//                        Button(
//                            modifier = Modifier
//                                .padding(end = 20.dp)
//                                .size(56.dp)
//                                .aspectRatio(1f),
//                            onClick = {},
//                            shape = RoundedCornerShape(12.dp)
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.SettingsInputComposite,
//                                contentDescription = "Search Options"
//                            )
//                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CaféDeArteTheme {
        HomeScreen()
    }
}