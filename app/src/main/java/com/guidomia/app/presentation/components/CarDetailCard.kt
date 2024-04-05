package com.guidomia.app.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidomia.app.model.CarModel
import com.guidomia.app.model.Cars
import com.guidomia.app.presentation.MainScreen
import com.guidomia.app.ui.theme.GuidomiaTheme
import com.guidomia.app.util.clickableWithoutRipple
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CarDetailCard(car: CarModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp),
            ) {
                val cars = Cars.entries.toTypedArray()
                var expanded by rememberSaveable { mutableStateOf(false) }
                AnimatedVisibility(
                    remember { MutableTransitionState(false) }.apply {
                        targetState = true
                    },
                    enter = fadeIn(tween(durationMillis = 300)),
                    exit = fadeOut(tween(durationMillis = 300)),
                ) {
                    Orbital(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickableWithoutRipple(
                                interactionSource = MutableInteractionSource(),
                                onClick = { expanded = !expanded },
                            ),
                    ) {
                        val showWorkDetails = rememberMovableContentOf {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .padding(horizontal = if (expanded) 20.dp else 10.dp)
                                    .animateBounds(
                                        sizeAnimationSpec = tween(durationMillis = 300),
                                        positionAnimationSpec = tween(durationMillis = 300),
                                    ),
                            ) {
                                Text(
                                    text = car.make,
                                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                    color = MaterialTheme.colorScheme.tertiary,
                                )

                                val format = NumberFormat.getNumberInstance(Locale.US)
                                format.maximumFractionDigits = 1

                                Text(
                                    text = "Price: ${format.format(car.marketPrice / 1000)}k",
                                    fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                                    fontSize = MaterialTheme.typography.displayMedium.fontSize,
                                    fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
                                    color = MaterialTheme.colorScheme.tertiary,
                                )

                                RatingStar(starsCount = car.rating)
                            }
                        }

                        val showCarModel = rememberMovableContentOf {
                            Image(
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .size(height = 67.dp, width = 119.dp),
                                painter = painterResource(id = cars.find { it.model == car.model }!!.imagePath),
                                contentDescription = "Car Model Image",

                                )
                        }

                        val showCarModelDetails = rememberMovableContentOf {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .padding(horizontal = if (expanded) 20.dp else 10.dp)
                                    .animateBounds(
                                        sizeAnimationSpec = tween(durationMillis = 300),
                                        positionAnimationSpec = tween(durationMillis = 300),
                                    )
                            ) {

                                if (car.prosList.isNotEmpty()) {
                                    Text(
                                        text = "Pros :",
                                        fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                                        fontSize = MaterialTheme.typography.displayMedium.fontSize,
                                        fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
                                        color = MaterialTheme.colorScheme.tertiary,
                                    )
                                }

                                car.prosList.forEach { pros ->

                                    if (pros.toString().isNotBlank()) {

                                        Row(
                                            modifier = Modifier.padding(top = 15.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(8.dp)
                                                    .clip(CircleShape)
                                                    .background(color = MaterialTheme.colorScheme.primary)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))

                                            Text(
                                                text = pros.toString(),
                                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                                color = Color.Black,
                                            )
                                        }
                                    }
                                }

                                if (car.consList.isNotEmpty()) {
                                    Text(
                                        modifier = Modifier.padding(top = 15.dp),
                                        text = "Cons :",
                                        fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                                        fontSize = MaterialTheme.typography.displayMedium.fontSize,
                                        fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
                                        color = MaterialTheme.colorScheme.tertiary,
                                    )
                                }

                                car.consList.forEach { cons ->
                                    if (cons.isNotBlank()) {

                                        Row(
                                            modifier = Modifier.padding(top = 15.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(8.dp)
                                                    .clip(CircleShape)
                                                    .background(color = MaterialTheme.colorScheme.primary)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))

                                            Text(
                                                text = cons,
                                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                                color = Color.Black,
                                            )
                                        }
                                    }

                                }
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Top
                            ) {
                                showCarModel()
                                showWorkDetails()
                            }

                            if (expanded) {
                                showCarModelDetails()
                            }
                        }

                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                .background(color = MaterialTheme.colorScheme.primary)
                .size(4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    GuidomiaTheme {
        MainScreen()
    }
}