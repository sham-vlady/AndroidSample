package com.example.androidsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import com.example.androidsample.ui.theme.AndroidSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSampleTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background),
                    contentAlignment = Alignment.Center
                ) {
                    val greenColor = Color(0xFF71D88D)
                    val eyeColor = MaterialTheme.colors.background

                    Spacer(
                        modifier = Modifier
                            .size(240.dp)
                            .drawBehind {
                                withTransform({
                                    translate(top = size.center.y)
                                }) {
                                    drawArc(
                                        color = greenColor,
                                        startAngle = 180f,
                                        sweepAngle = 180f,
                                        useCenter = true
                                    )
                                }
                                drawCircle(
                                    color = eyeColor,
                                    radius = 12.dp.toPx(),
                                    center = Offset(63.dp.toPx(), 195.dp.toPx())
                                )
                                drawCircle(
                                    color = eyeColor,
                                    radius = 12.dp.toPx(),
                                    center = Offset(177.dp.toPx(), 195.dp.toPx())
                                )
                                drawLine(
                                    color = greenColor,
                                    start = Offset(45.dp.toPx(), 105.dp.toPx()),
                                    end = Offset(63.dp.toPx(), 147.dp.toPx()),
                                    strokeWidth = 12.dp.toPx(),
                                    cap = StrokeCap.Round
                                )
                                drawLine(
                                    color = greenColor,
                                    start = Offset(195.dp.toPx(), 105.dp.toPx()),
                                    end = Offset(147.dp.toPx(), 177.dp.toPx()),
                                    strokeWidth = 12.dp.toPx(),
                                    cap = StrokeCap.Round
                                )
                            }
                    )
                }
            }
        }
    }
}