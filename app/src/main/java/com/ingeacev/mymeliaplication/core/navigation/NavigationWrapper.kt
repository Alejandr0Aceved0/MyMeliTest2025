package com.ingeacev.mymeliaplication.core.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.ingeacev.mymeliaplication.detail_product.presentation.screen.DetailProductScreen
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.HomeScreen

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    val gson = remember { Gson() }

    NavHost(navController = navController, startDestination = Home) {

        composable<Home> {
            HomeScreen { searchResultDto ->
                val json = Uri.encode(gson.toJson(searchResultDto))
                navController.navigate("details/$json")
            }
        }

        composable("details/{searchResultDto}") { backStackEntry ->

            val json = backStackEntry.arguments?.getString("searchResultDto") ?: ""
            val searchResultDto = gson.fromJson(json, SearchResultDto::class.java)

            DetailProductScreen(
                searchResultDto = searchResultDto,
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}
