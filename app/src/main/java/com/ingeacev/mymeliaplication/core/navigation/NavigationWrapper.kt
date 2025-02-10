package com.ingeacev.mymeliaplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.HomeScreen

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {

        composable<Login> {
            LoginScreen() { navController.navigate(Home) }
        }

        composable<Home> {
            HomeScreen()
        }

        composable<Details> { backStackEntry ->
            val details = backStackEntry.toRoute<Details>()
            DetailScreen(details.name)
        }
    }
}