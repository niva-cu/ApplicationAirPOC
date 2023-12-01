package com.nivs.applicationairpoc.app_navigation

sealed class Routes(val route: String) {
    object DashBoard : Routes("dashboard")
    object PartnersScreen : Routes("recyclerview_api")
    object MyActivityScreen : Routes("activities")
    object ExplorePartnerScreen : Routes("explore")
}