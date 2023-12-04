package com.nivs.applicationairpoc

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nivs.applicationairpoc.ui.theme.AppBackgroundGray
import com.nivs.applicationairpoc.ui.theme.AppBackgroundLightGray
import com.nivs.applicationairpoc.ui.theme.AppLightGray


@OptIn(ExperimentalPagerApi::class)
//@Preview(name = "partnersScreen",showBackground = true)
@Composable
fun ExplorePartnerScreen(navController: NavHostController) {
    val placeholder = "train, boat, bus, airplane, ship"
    val globalText = stringResource(id = R.string.explorer1, placeholder)
    val start = globalText.indexOf(placeholder)
    val spanStyles = listOf(
        AnnotatedString.Range(
            SpanStyle(fontWeight = FontWeight.Bold),
            start = start,
            end = start + placeholder.length
        )
    )

    Column(modifier = Modifier.background(color = AppBackgroundGray)) {

        PartnersLogo()

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .weight(1f, false)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(20.dp, 12.dp, 20.dp, 12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.explorer2),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                Text(
                    text = AnnotatedString(text = globalText, spanStyles = spanStyles),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp, 0.dp, 0.dp)
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp, 0.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(
                        //containerColor =
                        Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {},
                ) {
                    Text("Book Now")
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
                    .background(color = Color.White)
            ) {
                ExpandableCard(globalText, spanStyles)
            }

        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 20.dp, 20.dp),
            colors = ButtonDefaults.buttonColors(
                //containerColor =
                Color.White,
                contentColor = Color.Red
            ),
            border = BorderStroke(width = 2.dp, color = Color.Red),
            shape = RoundedCornerShape(6.dp),
            onClick = {
            },
        ) {
            Text("Explore More About This Partner")
        }
    }
}

@Composable
fun PartnersLogo() {
    Box(
        //contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
            .background(color = Color.White)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f)
                .background(color = Color.White),
            shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp)
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


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),

            ) {
            Column {

                Text(
                    text = stringResource(id = R.string.explorer0),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Row(
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 10.dp, 4.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xEEFFFFFF),
                            shape = RoundedCornerShape(6.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.icons_button),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp, 8.dp, 0.dp, 8.dp)
                            .weight(.4f)
                            .height(40.dp)
                            .width(140.dp),
                        contentScale = ContentScale.FillBounds,
                        alignment = Alignment.BottomStart
                    )

                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        modifier = Modifier
                            .weight(.5f)
                            .align(Alignment.CenterVertically)
                            .padding(0.dp, 0.dp, 10.dp, 0.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(globalText: String, spanStyles: List<AnnotatedString.Range<SpanStyle>>) {

    var expanded by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, label = ""
    )
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White),
        //.clickable {
        onClick = { expanded = !expanded }
        //}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
           Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(8.dp)
                        .weight(6f),
                    text = "How to Earn",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.2f)
                        .rotate(rotationState),
                    onClick = {
                    }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }

            Divider(
                color = AppLightGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            //if (expanded) {
                Text(
                    text = AnnotatedString(text = globalText, spanStyles = spanStyles),
                    modifier = Modifier.padding(8.dp)
                )
         //   }
        }
    }
}