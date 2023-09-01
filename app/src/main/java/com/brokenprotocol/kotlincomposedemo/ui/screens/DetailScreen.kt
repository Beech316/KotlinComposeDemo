package com.brokenprotocol.kotlincomposedemo.ui.screens

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import com.brokenprotocol.kotlincomposedemo.ui.components.LoadImageOrDefault
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension
import com.jai.multifabbutton.compose.FabItem
import com.jai.multifabbutton.compose.MultiFloatingActionButton
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.DefaultMapProperties
import com.utsman.osmandcompose.ZoomButtonVisibility
import com.utsman.osmandcompose.rememberCameraState
import org.osmdroid.util.GeoPoint

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    detail : Detail,
    liked : Boolean,
    modifier : Modifier = Modifier,
    onLikeSelected : () -> Unit = {}
) {
    val dimens = LocalDimension.current
    val context = LocalContext.current
    val images = detail.getImages()

    val pagerState = rememberPagerState { images.size }

    val sendIntent : Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Look at this awesome ${detail.name} I found on KotlinDemoApp!")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    Scaffold(
        floatingActionButton = {
            MultiFloatingActionButton(fabIcon = painterResource(id = R.drawable.ic_fab_add),
                items = arrayListOf(
                    FabItem(icon =  painterResource(id = R.drawable.ic_fab_phone), label = "Phone") {
                        val phone = Uri.parse("tel:" + detail.phone)
                        val intent = Intent(Intent.ACTION_DIAL, phone)
                        try {
                            context.startActivity(intent)
                        } catch (e : SecurityException) {
                            Toast.makeText(context, "An error occurred with your phone number's format: ${detail.phone}. Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                        }
                    },
                    FabItem(icon =  painterResource(id = R.drawable.ic_fab_email), label = "Email") {
                        try {
                            val intent = Intent(Intent.ACTION_SEND)
                            intent.type = "vnd.android.cursor.item/email"
                            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(detail.email))
                            intent.putExtra(Intent.EXTRA_SUBJECT, "KotlinComposeDemo")
                            context.startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            Toast.makeText(context, "Can't find email client. Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                        } catch (t: Throwable) {
                            Toast.makeText(context, "An error occurred. Error: ${t.localizedMessage}", Toast.LENGTH_LONG).show()
                        }
                    }
                )
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.height(200.dp)
            ) {
                LoadImageOrDefault(
                    imageUrl = images[it],
                    default = R.drawable.detail_image
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ) {
                IconButton(
                    onClick = {
                        context.startActivity(shareIntent)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null
                    )
                }

                Text(
                    text = detail.name,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )

                IconButton(
                    onClick = { onLikeSelected() }
                ) {
                    if (liked) {
                        Icon(
                            imageVector = Icons.Outlined.Favorite,
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    }
                }
            }

            Text(
                text = detail.desc,
                modifier = Modifier.padding(dimens.small)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            // define camera state
            val cameraState = rememberCameraState {
                geoPoint = GeoPoint(detail.location.latitude, detail.location.longitude)
                zoom = 12.0
            }

            var mapProperties by remember {
                mutableStateOf(DefaultMapProperties)
            }

            SideEffect {
                mapProperties = mapProperties
                    .copy(zoomButtonVisibility = ZoomButtonVisibility.SHOW_AND_FADEOUT)
            }


            Surface(
                modifier = Modifier.align(Alignment.CenterHorizontally).width(300.dp).height(200.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                OpenStreetMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraState = cameraState,
                    properties = mapProperties
                )
            }

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = dimens.medium),
                onClick = {
                    val websiteIntent = Intent(Intent.ACTION_VIEW, Uri.parse(detail.website))
                    context.startActivity(websiteIntent)
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "Open Website")
            }

        }

    }

}
