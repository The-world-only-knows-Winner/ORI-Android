package com.onlywin.designsystem.fondation.typography

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.onlywin.designsystem.DuckTheme
import com.onlywin.designsystem.R

@Stable
val maxLine = 1000

@Stable
val suitFamily = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_extra_bold, FontWeight.ExtraBold),
    Font(R.font.suit_extra_light, FontWeight.ExtraLight),
    Font(R.font.suit_light, FontWeight.Light),
    Font(R.font.suit_medium, FontWeight.Medium),
    Font(R.font.suit_regular, FontWeight.Normal),
    Font(R.font.suit_semi_bold, FontWeight.SemiBold),
    Font(R.font.suit_thin, FontWeight.Thin),
)

object DuckTypography {

    private val platFormTextStyle = PlatformTextStyle(
        includeFontPadding = false,
    )

    @Stable
    val h1 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 32.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h2 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h3 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body1 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body3 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body4 = TextStyle(
        fontFamily = suitFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        platformStyle = platFormTextStyle,
    )
}

@Composable
fun Heading1(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.h1,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading2(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.h2,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading3(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.h3,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.body1,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.body2,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.body3,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body4(
    modifier: Modifier = Modifier,
    color: Color = DuckTheme.colors.onBackground,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = suitFamily,
        style = DuckTypography.body4,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}
