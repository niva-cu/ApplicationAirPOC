package com.nivs.applicationairpoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.nivs.applicationairpoc.card_list.CardViewModel
import com.nivs.applicationairpoc.ui.theme.AppBackgroundLightGray
import com.nivs.applicationairpoc.ui.theme.AppLightGray


@Composable
fun MyActivityScreen(navController: NavHostController) {
    MyActivityPreview()

}


@Preview
@Composable
fun MyActivityPreview() {
    Column(modifier = Modifier
        .background(color = AppBackgroundLightGray)
        .fillMaxWidth()) {

        /*Image(painter = painterResource(id = R.drawable.and1),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight(.2f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop)*/

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.2f)
                .padding(20.dp, 16.dp,20.dp,16.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
        }


        TabBarLayout()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabBarLayout() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabTitles = listOf("3 Months", "6 Months", "9 Months", "YTD")
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp),
    ) {

        ScrollableTabRow(selectedTabIndex = tabIndex, divider = {},
            modifier = Modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(50))
                .padding(3.dp),
            indicator = {
                Box(
                    Modifier
                        .tabIndicatorOffset(it.get(tabIndex))
                        .height(1.dp)
                    //.border(1.dp, Color.Transparent)
                )
            },
            containerColor = AppBackgroundLightGray,
            edgePadding = 0.dp

        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) },
                    modifier = Modifier
                        .clip(RoundedCornerShape(90))
                        .padding(horizontal = 3.dp)
                        .background(if (tabIndex == index) Color.Red else AppLightGray),
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black,
                )
            }
        }
    }
    when (tabIndex) {
        0 -> ActivitiesScreens()
        1 -> Text("${tabTitles[1]} $tabIndex")
        2 -> Text("${tabTitles[2]} $tabIndex")
        3 -> Text("${tabTitles[3]} $tabIndex")
    }
}


@Preview
@Composable
fun ActivitiesScreens() {
    val viewModel: CardViewModel = viewModel()
    val cards by viewModel.availableCards.observeAsState(null)
    LaunchedEffect(Unit) {
        viewModel.fetchCards()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    )
    {
        cards?.let {
            items(10)
            { ActivityItem(cards!!, it) }
        }
    }
}