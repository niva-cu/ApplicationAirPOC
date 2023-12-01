package com.nivs.applicationairpoc

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
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
import androidx.compose.ui.text.font.FontWeight
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
            val slideImage = remember { mutableStateOf(R.drawable.images) }
            HorizontalPager(count = 3, state = state,
                modifier = Modifier.fillMaxWidth()) { page ->
                when(page)  {

                    0 -> {
                        slideImage.value = R.drawable.images
                    }

                    1 -> {
                        slideImage.value = R.drawable.and1
                    }

                    2 -> {
                        slideImage.value = R.drawable.icons_button
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(slideImage.value),
                        contentDescription = "",
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomCenter)) {
                Image(
                    painter = painterResource(R.drawable.icons_button),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp, 30.dp, 10.dp, 20.dp)
                        .height(30.dp)
                        .width(140.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop,
                    //alignment = Alignment.Center
                )

                Text(
                    text = "EARN 13 FLYING POINTS",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(28.dp, 8.dp, 28.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Earn 13 Return Points on Every Rs 100 spent",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(28.dp, 10.dp, 28.dp, 8.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 8.dp, 24.dp, 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        //containerColor =
                        Color.Transparent
                    ),
                    border = BorderStroke(width = 2.dp, color = Color.White),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                    },
                ) {
                    Text("View Offer", fontSize = 18.sp, style = MaterialTheme.typography.labelLarge)
                }

                Row(
                    Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                        //.align(Alignment.BottomCenter)
                        .padding(bottom = 8.dp)
                ) {
                    repeat(state.pageCount) { iteration ->
                        val color =
                            if (state.currentPage == iteration) Color.White else Color.LightGray
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
                //Spacer(modifier = Modifier.padding(4.dp))
            }
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
                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    color = AppLightGray,
                    modifier = Modifier
                        .width(80.dp)
                        .height(2.dp)
                        .align(Alignment.CenterHorizontally)
                        //.padding(10.dp,10.dp,0.dp, 15.dp)

                )
               // Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "PARTNER OFFERS",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
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
                            .padding(3.dp,3.dp,3.dp,10.dp),
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
                                modifier = Modifier
                                    .clip(RoundedCornerShape(90))
                                    .padding(horizontal = 3.dp)
                                    .background(if (tabIndex == index) Color.Red else AppLightGray),
                                /*.paint(painter = painterResource(id = R.drawable.ic_launcher_background)
                                                )*/
                                text = { Text(text = title) },
                                selectedContentColor = Color.White,
                                unselectedContentColor = Color.Black
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
            .padding(12.dp, 6.dp, 12.dp, 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
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
                        .size(40.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
                Text(
                    text = "HSBC",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 18.sp
                )
            }
            Column(Modifier.padding(start = 12.dp, end = 8.dp, top = 16.dp, bottom = 12.dp)) {
                Text(
                    text = "ZoomCar offers",
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Expiry Date is coming soon",
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

            }
        }
    }
}
