package com.nivs.applicationairpoc.app_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nivs.applicationairpoc.DashBoard
import com.nivs.applicationairpoc.ExplorePartnerScreen
import com.nivs.applicationairpoc.MyActivityScreen
import com.nivs.applicationairpoc.PartnersScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "dashboard"){
        composable(route  = Routes.DashBoard.route){
            DashBoard(navController = navController)
        }

        composable(route  = Routes.PartnersScreen.route){
            PartnersScreen(navController = navController)
        }

        composable(route  = Routes.MyActivityScreen.route){
            MyActivityScreen(navController = navController)
        }

        composable(route  = Routes.ExplorePartnerScreen.route){
            ExplorePartnerScreen(navController = navController)
        }
    }
}

