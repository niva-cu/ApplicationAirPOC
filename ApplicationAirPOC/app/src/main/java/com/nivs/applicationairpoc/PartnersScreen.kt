package com.nivs.applicationairpoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.nivs.applicationairpoc.card_list.CardResponse
import com.nivs.applicationairpoc.card_list.CardViewModel
import com.nivs.applicationairpoc.ui.theme.AppLightGray


@OptIn(ExperimentalPagerApi::class)
//@Preview(name = "partnersScreen",showBackground = true)
@Composable
fun PartnersScreen(navController: NavHostController) {
    Column(modifier = Modifier.background(color = AppLightGray)) {
        Box(
            modifier = Modifier
                .fillMaxHeight(.3f)
                .fillMaxWidth(1f)
        ) {

            var state = rememberPagerState(0)
            val slideImage = remember { mutableStateOf(R.drawable.and1) }
            HorizontalPager(count = 3, state = state,
                modifier = Modifier.fillMaxWidth()) { page ->
                when(page)  {

                    0 -> {
                        slideImage.value = R.drawable.and1
                    }

                    1 -> {
                        slideImage.value = R.drawable.icons_button
                    }

                    2 -> {
                        slideImage.value = R.drawable.and2
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(slideImage.value),
                        contentDescription = "",
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f)
                    )
                }

            }

            Row(
                Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
            ) {
                repeat(state.pageCount) { iteration ->
                    val color = if (state.currentPage == iteration) Color.White else Color.LightGray
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(6.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
        }

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "PARTNERS OFFERS",
                    style = MaterialTheme.typography.headlineLarge,

                    fontSize = 16.sp,
                    modifier = Modifier.padding(18.dp)
                )

                var tabIndex by remember { mutableIntStateOf(0) }
                val tabTitles = listOf("All Offers", "Co-Branded Cards", "Point Conversions")
                val pagerState = rememberPagerState()

                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(12.dp, 0.dp, 12.dp, 0.dp),
                ) {


                    ScrollableTabRow(selectedTabIndex = tabIndex, divider = {},
                        modifier = Modifier
                            .wrapContentWidth()
                            .background(Color.White)
                            .clip(RoundedCornerShape(50))
                            .padding(3.dp),
                        indicator = {
                            Box(
                                Modifier
                                    .tabIndicatorOffset(it.get(tabIndex))
                                    .height(1.dp)
                            )
                        },
                        containerColor = Color.White,
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
                                    .background(color = AppLightGray),
                                /*.paint(painter = painterResource(id = R.drawable.ic_launcher_background)
                                                )*/
                                selectedContentColor = Color.Red,
                                unselectedContentColor = Color.Black,
                            )
                        }
                    }
                }
                when (tabIndex) {
                    0 -> CardScreens()
                    1 -> Text("Co-Branded Cards")
                    2 -> Text("Point Conversions")
                }

            }
        }
    }
}


@Preview
@Composable
fun CardScreens() {
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
            { CardItem(cards!!) }
        }
    }
}

@Composable
fun CardItem(card: CardResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 6.dp, 14.dp, 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = AppLightGray)
                    .padding(2.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = "HSBC",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Column(Modifier.padding(start = 12.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)) {
                Text(
                    text = "ZoomCar offers",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Expiry Date is coming soon",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 16.sp,
                    color = Color.Gray
                )

            }
        }
    }
}