package com.nivs.applicationairpoc

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.nivs.applicationairpoc.app_navigation.Routes

@Composable
fun DashBoard(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                text = AnnotatedString("Partners Offers"),
                modifier = Modifier
                    .padding(10.dp),
                style = TextStyle(fontSize = 20.sp, color = Color.Blue),
                onClick = {
                    navController.navigate(route = Routes.PartnersScreen.route)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                text = AnnotatedString("My Activities"),
                modifier = Modifier
                    .padding(10.dp),
                style = TextStyle(fontSize = 20.sp, color = Color.Blue),
                onClick = {
                    navController.navigate(route = Routes.MyActivityScreen.route)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                text = AnnotatedString("Explore Partner"),
                modifier = Modifier
                    .padding(10.dp),
                style = TextStyle(fontSize = 20.sp, color = Color.Blue),
                onClick = {
                    navController.navigate(route = Routes.ExplorePartnerScreen.route)
                }
            )
        }
    }
}
