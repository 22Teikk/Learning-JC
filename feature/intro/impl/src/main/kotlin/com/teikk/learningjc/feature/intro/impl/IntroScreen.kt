package com.teikk.learningjc.feature.intro.impl

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.teikk.learningjc.core.designsystem.R
import com.teikk.learningjc.core.designsystem.component.PrimaryButton
import com.teikk.learningjc.core.designsystem.theme.Dimens

@Preview
@Composable
fun IntroScreen(
    onStartClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.intro_pic),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Fit,
        )
        Spacer(
            modifier = Modifier.height(Dimens.heightButtonSmall),
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(
            modifier = Modifier.height(Dimens.heightButtonSmall),
        )
        Text(
            text = stringResource(id = R.string.subTitle),
            modifier = Modifier
                .padding(top = Dimens.padding16)
                .padding(horizontal = Dimens.padding16),
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp,
        )
        Spacer(
            modifier = Modifier.height(Dimens.heightButtonSmall),
        )
        PrimaryButton(
            text = stringResource(R.string.start),
            onClick = onStartClick,
            modifier = Modifier.padding(horizontal = Dimens.padding16),
        )
        Text(
            text = stringResource(id = R.string.signin),
            modifier = Modifier
                .padding(horizontal = Dimens.padding16, vertical = Dimens.padding16),
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            fontSize = Dimens.fontSizeBody,
            lineHeight = 24.sp,
        )
    }
}
