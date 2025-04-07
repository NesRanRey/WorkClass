package com.example.workclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.tuapp.ui.screens.BbvaInterface
import com.example.workclass.ui.screens.AccountsScreen
import com.example.workclass.ui.screens.ComponentsScreen
import com.example.workclass.ui.screens.HomeScreen
import com.example.workclass.ui.screens.LoginScreen
import com.example.workclass.ui.theme.WorkClassTheme
import com.example.workclass.ui.screens.MainMenuScreen
import com.example.workclass.ui.screens.ManageAccountScreen
import com.example.workclass.ui.screens.TestScreen


class MainActivity : ComponentActivity() {
    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkClassTheme {
                ComposableMultiScreenApp()

                }
            }
        }
    }

    @Composable
fun ComposableMultiScreenApp(){
        val navController = rememberNavController()
        SetupNavGraph(navController = navController)
}
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController=navController, startDestination= "main_menu" ){
        composable("main_menu"){MainMenuScreen(navController) } //Se importa la clase
        composable("home_screen"){HomeScreen(navController) } //Se importa la clase
        composable("test_screen"){ TestScreen(navController) } //Se importa la class
        composable("bbva_interface"){ BbvaInterface(navController) }
        composable("components_screen"){ ComponentsScreen(navController) }
        composable("login_screen"){ LoginScreen(navController) }
        composable("accounts_screen"){ AccountsScreen(navController)}
        composable("manage_account_screen"){ ManageAccountScreen(navController)}

    }

}




