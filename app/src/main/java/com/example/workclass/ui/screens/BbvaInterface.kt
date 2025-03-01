package com.example.tuapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.workclass.R

@Composable
fun BbvaInterface(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF0072BC), Color(0xFF0072BC))
                    )
                )
                .padding(paddingValues)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hola Néstor",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.duda),
                        contentDescription = "Duda",
                        modifier = Modifier.size(26.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Image(
                        painter = painterResource(R.drawable.lineas),
                        contentDescription = "Líneas",
                        modifier = Modifier.size(26.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.transferir),
                        contentDescription = "Transferir & Dimo",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Transferir & Dimo",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.oportunidades),
                        contentDescription = "Oportunidades",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Oportunidades",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.retiro),
                        contentDescription = "Retiro sin tarjeta",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Retiro sin tarjeta",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.mas),
                        contentDescription = "Más",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Más",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // CUENTAS EN PESOS
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(24.dp)
            ) {
                Text(
                    text = "CUENTAS EN PESOS",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "0001ah8096",
                        color = Color(0xFF0072BC),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "$5,681.83",
                        color = Color.White,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = ".8096",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Text(
                        text = "Saldo disponible",
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .background(Color(0xFF1C1C1C))
            )

            Spacer(modifier = Modifier.height(0.dp))

            // TARJETAS
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(16.dp)
            ) {
                Text(
                    text = "TARJETAS",
                    color = Color.Gray,
                    fontSize = 17.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "0001ah8096",
                        color = Color(0xFF0072BC),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(R.drawable.celularcito),
                        contentDescription = "Celularcito",
                        modifier = Modifier
                            .size(25.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.tarjeta),
                        contentDescription = "Tarjeta",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(75.dp)
                            .height(57.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "•4387",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFF1C1C1C))
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.inicio),
                    contentDescription = "Inicio",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Inicio", color = Color.Gray) },
            selected = false,
            onClick = { navController.navigate("inicio") }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.salud_financiera),
                    contentDescription = "Salud Financiera",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Salud Fin.", color = Color.Gray) },
            selected = false,
            onClick = { navController.navigate("saludFinanciera") }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.oportunidad),
                    contentDescription = "Oportunidad",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Oportunid.", color = Color.Gray) },
            selected = false,
            onClick = { navController.navigate("oportunidad") }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.notificaciones),
                    contentDescription = "Notificaciones",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Notificac.", color = Color.Gray) },
            selected = false,
            onClick = { navController.navigate("notificaciones") }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.ayuda),
                    contentDescription = "Ayuda",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = { Text("Ayuda", color = Color.Gray) },
            selected = false,
            onClick = { navController.navigate("ayuda") }
        )
    }
}
