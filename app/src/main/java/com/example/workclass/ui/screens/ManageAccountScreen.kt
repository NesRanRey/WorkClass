package com.example.workclass.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.workclass.data.model.viewmodel.AccountModel
import com.example.workclass.data.model.viewmodel.AccountViewModel
import com.example.workclass.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavHostController,
    viewModel: AccountViewModel = viewModel()
) {
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(10.dp)
            .fillMaxSize()
    ) {
        TopBarComponent("Manage Account", navController, "manage_account_screen")

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            label = { "Account Name" },
            onValueChange = {
                account.value = account.value.copy(name = it)
            }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = { "Account Username" },
            onValueChange = {
                account.value = account.value.copy(username = it)
            }

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = { "Account Password" },
            onValueChange = {
                account.value = account.value.copy(password = it)
            }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = { "Account Description" },
            onValueChange = {
                account.value = account.value.copy(description = it)
            }

        )
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            onClick= {
               //funcion
            }
        ) {
            Text( "Save Account")
        }
    }
}
