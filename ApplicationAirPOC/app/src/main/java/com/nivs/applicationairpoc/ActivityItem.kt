package com.nivs.applicationairpoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nivs.applicationairpoc.card_list.CardResponse
import com.nivs.applicationairpoc.ui.theme.AppGreen
import com.nivs.applicationairpoc.ui.theme.AppLightGray


@Composable
fun ActivityItem(card: CardResponse, i: Int) {
    if(i%2==0 && i%3!=0) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 6.dp, 14.dp, 6.dp),
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
                    //horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(14.dp, 12.dp, 14.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.activities_string1),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.weight(.7f)
                    )
                    Text(
                        text = stringResource(id = R.string.activities_string2),
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppGreen,
                        modifier = Modifier
                            .weight(.3f)
                            .padding(0.dp, 20.dp, 0.dp, 0.dp),
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(2.dp, 0.dp, 10.dp, 8.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.icon_calendar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(12.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.activities_string5),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                }

            }
        }
    } else if(i%2==1 && i%3==0){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp, 6.dp, 14.dp, 6.dp),
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
                    //horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(14.dp, 12.dp, 14.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.activities_string11),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(.3f)
                    )

                    Divider(
                        color = AppLightGray,
                        modifier = Modifier
                            .width(100.dp)
                            .height(1.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Image(
                        painter = painterResource(R.drawable.icon_plane),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Divider(
                        color = AppLightGray,
                        modifier = Modifier
                            .width(100.dp)
                            .height(1.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Text(
                        text = stringResource(id = R.string.activities_string12),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(.3f),
                        textAlign = TextAlign.End
                    )

                }

                Row(
                    modifier = Modifier
                        .padding(14.dp, 0.dp, 14.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.activities_string3),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.weight(.5f)
                    )

                    Text(
                        text = stringResource(id = R.string.activities_string8),
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier
                            .weight(.5f)
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(2.dp, 0.dp, 10.dp, 8.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.icon_calendar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(12.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.activities_string6),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    } else if(i%2==0 && i%3==0) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp, 6.dp, 14.dp, 6.dp),
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
                    //horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(14.dp, 12.dp, 14.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.activities_string11),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(.3f)
                    )

                    Divider(
                        color = AppLightGray,
                        modifier = Modifier
                            .width(100.dp)
                            .height(1.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Image(
                        painter = painterResource(R.drawable.icon_plane),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Divider(
                        color = AppLightGray,
                        modifier = Modifier
                            .width(100.dp)
                            .height(1.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Text(
                        text = stringResource(id = R.string.activities_string12),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(.3f),
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(14.dp, 0.dp, 14.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.activities_string4),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 15.sp,
                        color = Color.Gray,
                        modifier = Modifier.weight(.6f)
                    )

                    Text(
                        text = stringResource(id = R.string.activities_string9),
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppGreen,
                        modifier = Modifier
                            .weight(.4f)
                            .padding(0.dp, 0.dp, 0.dp, 0.dp),
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(2.dp, 0.dp, 10.dp, 8.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.icon_calendar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(12.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.activities_string7),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = stringResource(id = R.string.activities_string10),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.weight(.5f),
                        textAlign = TextAlign.End
                    )
                }

            }
        }
    }
}

