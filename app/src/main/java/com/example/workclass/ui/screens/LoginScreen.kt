package com.example.workclass.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.workclass.data.model.viewmodel.UserModel
import com.example.workclass.data.model.viewmodel.UserViewModel

@Composable
fun LoginScreen (navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LoginForm(navController)
    }
}

@Composable
fun LoginForm (
    navController: NavHostController,
    viewModel: UserViewModel= viewModel()
){
    val context = LocalContext.current
    Card (
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color.Black
        ),
        modifier = Modifier
            .padding(40.dp, 0.dp)
    ){
        Column (
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var user by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("")

            }

            AsyncImage(
                modifier = Modifier.size(200.dp),
                model= "https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_%28crest%29.svg/1200px-FC_Barcelona_%28crest%29.svg.png",
                contentDescription = "Barcelona_Logo",
                contentScale = ContentScale.Fit
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = user,
                maxLines = 1,
                onValueChange = {user = it},
                label = { Text("User")},
                colors= OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White

                )

            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                maxLines = 1,
                onValueChange = {password = it},
                label = { Text("Password")},
                colors= OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            )
            )

            FilledTonalButton(
               colors= ButtonDefaults.buttonColors(
                  containerColor = MaterialTheme.colorScheme.primary,
                   contentColor = Color.White
               ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {TryLogin(user, password, context, viewModel, navController)}
            ) {
                Text("LOG IN")
            }
            OutlinedButton(
                colors= ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {
                    navController.navigate("manage_account_screen")
                }
            ) {
                Text("CREATE ACCOUNT")
            }
        }
    }
}

fun TryLogin(user: String,
             password: String,
             context: Context,
             viewModel: UserViewModel,
             navController: NavHostController

){
    if(user== "" || password ==""){
    Toast.makeText(
        context,
        "User or password cannot be empty",
        Toast.LENGTH_SHORT
    ).show()

    }else{
        val user_model = UserModel(0,"",user,password)
        viewModel.loginAPI(user_model){ jsonResponse ->
            val loginStatus= jsonResponse?.get("login")?.asString
            Log.d("debug","LOGIN STATUS: $loginStatus")
            if (loginStatus == "success") {
               navController.navigate("accounts_screen")
            }else {
                Toast.makeText(
                    context,
                    "Failed login, check your credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}
