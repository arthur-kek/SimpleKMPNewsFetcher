package com.example.kmp.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmp.android.ui.AboutScreen
import com.example.kmp.android.ui.ArticlesScreen
import com.example.kmp.android.ui.Screens

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Screens.ARTICLE.route
    ) {
        composable(Screens.ARTICLE.route) {
            ArticlesScreen(
                onAboutButtonClicked = { navController.navigate(Screens.ABOUT_DEVICE.route) }
            )
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}