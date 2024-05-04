package com.kmm.animatedrainbow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmm.animatedrainbow.utils.ArrowDirection
import com.kmm.animatedrainbow.utils.createBubbleShape
import com.kmm.animatedrainbow.utils.drawAnimatedBorder

@Composable
fun RainbowScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var selectedTabIndex by remember { mutableStateOf(0) }
        val tabTitles = listOf("Chat", "Profile")

        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .drawAnimatedBorder(
                            strokeWidth = 3.dp,
                            durationMillis = 1000,
                            shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
                        )
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }



        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .drawAnimatedBorder(
                        strokeWidth = 6.dp,
                        durationMillis = 3000,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(start = 5.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            Box(
                modifier = Modifier
                    .drawAnimatedBorder(
                        strokeWidth = 4.dp,
                        durationMillis = 2000,
                        shape = createBubbleShape(
                            arrowWidth = 20f,
                            arrowHeight = 20f,
                            arrowOffset = 20f,
                            arrowDirection = ArrowDirection.Left
                        )
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Are you there ?",
                    modifier = Modifier.padding(all = 5.dp),
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .drawAnimatedBorder(
                        strokeWidth = 4.dp,
                        durationMillis = 2000,
                        shape = createBubbleShape(
                            arrowWidth = 20f,
                            arrowHeight = 20f,
                            arrowOffset = 20f,
                            arrowDirection = ArrowDirection.Right
                        )
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Yes. What happened ?",
                    modifier = Modifier.padding(all = 5.dp),
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .drawAnimatedBorder(
                        strokeWidth = 6.dp,
                        durationMillis = 3000,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(end = 5.dp),
                    painter = painterResource(id = R.drawable.man_profile),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }


        Spacer(modifier = Modifier.weight(1f))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .drawAnimatedBorder(
                        brush = {
                            Brush.sweepGradient(
                                colors = listOf(
                                    Color.Gray,
                                    Color.White,
                                    Color.Gray,
                                    Color.White,
                                    Color.Gray
                                )
                            )
                        },
                        strokeWidth = 4.dp,
                        durationMillis = 2000,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Send message ...",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 11.sp
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .drawAnimatedBorder(
                        strokeWidth = 3.dp,
                        durationMillis = 3000,
                        shape = CircleShape,
                        brush = {
                            Brush.sweepGradient(
                                colors = listOf(
                                    Color.Green,
                                    Color.White,
                                    Color.Green,
                                    Color.White,
                                    Color.Green
                                )
                            )
                        },
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier
                        .size(16.dp),
                    painter = painterResource(id = R.drawable.send_icon),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

