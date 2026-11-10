package com.teikk.learningjc.feature.home.impl

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.teikk.learningjc.core.designsystem.theme.Dimens
import com.teikk.learningjc.core.model.SliderModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
) {
    val banners by viewModel.banners.collectAsStateWithLifecycle()
    val showBannerLoading = banners.isEmpty()
    ConstraintLayout(
        modifier = Modifier.background(Color.White),
    ) {
        val (scrollList, bottomMenu) = createRefs()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(scrollList) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.start)
                },
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = Dimens.padding48,
                            start = Dimens.padding16,
                            end = Dimens.padding16,
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(

                    ) {
                        Text(stringResource(R.string.wellcome_back), color = Color.Black)
                        Text(
                            "Jackie",
                            color = Color.Black,
                            fontSize = Dimens.fontSizeTitleSmall,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Row(
                    ) {
                        Image(
                            painter = painterResource(com.teikk.learningjc.core.designsystem.R.drawable.fav_icon),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(Dimens.Spacing.default))
                        Image(
                            painter = painterResource(com.teikk.learningjc.core.designsystem.R.drawable.search_icon),
                            contentDescription = null,
                        )
                    }
                }
            }
            item {
                if (showBannerLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(Dimens.Height.banner),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    BannersComponent(banners = banners.toImmutableList())
                }
            }
        }
    }
}

@Composable
fun BannersComponent(
    banners: ImmutableList<SliderModel> = persistentListOf(),
) {
    AutoSlidingCarousel(banners = banners)
}

@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            banners.size
        },
    ),
    banners: ImmutableList<SliderModel>,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        if (banners.isNotEmpty()) {
            HorizontalPager(pagerState) { page ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(banners[page].url)
                        .crossfade(true).build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(horizontal = Dimens.padding16)
                        .padding(top = Dimens.padding16, bottom = Dimens.padding8)
                        .height(150.dp),
                )
            }
        }

        DotIndicator(
            modifier = Modifier.padding(horizontal = Dimens.padding8),
            totalDots = banners.size,
            selectedIndex = if (isDragged) pagerState.currentPage else pagerState.currentPage,
            dotSize = 8.dp,
        )
    }
}

@Composable
fun DotIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = colorResource(com.teikk.learningjc.core.designsystem.R.color.blue),
    unSelectedColor: Color = colorResource(com.teikk.learningjc.core.designsystem.R.color.grey),
    dotSize: Dp,
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight(),
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize,
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = Dimens.padding2))
            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color),
    )
}

@Preview(showBackground = true)
@Composable
private fun BannersComponentPreview() {
    val sampleBanners = persistentListOf(
        SliderModel(url = "https://res.cloudinary.com/dkikc5ywq/image/upload/v1776180413/banner1_qdfio4.png"),
        SliderModel(url = "https://res.cloudinary.com/dkikc5ywq/image/upload/v1776180445/banner2_aylcw4.png"),
    )
    BannersComponent(banners = sampleBanners)
}
