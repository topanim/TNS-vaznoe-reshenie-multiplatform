package app.what.gorogeuslugi.features.general.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.features.general.presentation.models.FilterType
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.foundation.ui.bclick
import app.what.gorogeuslugi.theme.buttonBlack
import co.touchlab.kermit.Logger


@Composable
fun FilterComponent(filterType: FilterType, selectType: (FilterType) -> Unit) = Column(
    modifier = Modifier.fillMaxWidth().padding(16.dp)
) {
    FilterItem(
        title = FilterType.DATE.name(),
        selected = filterType == FilterType.DATE,
    ) {
        selectType(FilterType.DATE)
    }
    Gap(15)
    FilterItem(
        title = FilterType.COMMITED.name(),
        selected = filterType == FilterType.COMMITED
    ) {
        selectType(FilterType.COMMITED)
    }
    Gap(15)
    FilterItem(
        title = FilterType.SIT_TYPE.name(),
        selected = filterType == FilterType.SIT_TYPE
    ) {
        selectType(FilterType.SIT_TYPE)
    }
    val log = Logger.withTag("MyViewModel")
    log.d { filterType.name }
}

fun FilterType.name() = when {
    this == FilterType.DATE -> "По дате"
    this == FilterType.COMMITED -> "По комитету"
    else -> "По типу заседания"

}

@Composable
fun FilterItem(title: String, selected: Boolean, select: () -> Unit) =
    Row(modifier = Modifier.wrapContentSize().bclick {
        select()
    }) {
        Image(
            imageVector = if (selected) FilterCurcleFilled else FilterCurcle,
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
        Gap(7)
        Text(
            title,
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = buttonBlack,
            lineHeight = 16.sp
        )
    }

val FilterCurcle: ImageVector
    get() {
        if (_FilterCurcle != null) {
            return _FilterCurcle!!
        }
        _FilterCurcle = ImageVector.Builder(
            name = "FilterCurcle",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF49454F))) {
                moveTo(10f, 0f)
                curveTo(4.48f, 0f, 0f, 4.48f, 0f, 10f)
                curveTo(0f, 15.52f, 4.48f, 20f, 10f, 20f)
                curveTo(15.52f, 20f, 20f, 15.52f, 20f, 10f)
                curveTo(20f, 4.48f, 15.52f, 0f, 10f, 0f)
                close()
                moveTo(10f, 18f)
                curveTo(5.58f, 18f, 2f, 14.42f, 2f, 10f)
                curveTo(2f, 5.58f, 5.58f, 2f, 10f, 2f)
                curveTo(14.42f, 2f, 18f, 5.58f, 18f, 10f)
                curveTo(18f, 14.42f, 14.42f, 18f, 10f, 18f)
                close()
            }
        }.build()

        return _FilterCurcle!!
    }

@Suppress("ObjectPropertyName")
private var _FilterCurcle: ImageVector? = null

val FilterCurcleFilled: ImageVector
    get() {
        if (_FilterCurcleFilled != null) {
            return _FilterCurcleFilled!!
        }
        _FilterCurcleFilled = ImageVector.Builder(
            name = "FilterCurcleFilled",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(10f, 0f)
                curveTo(4.48f, 0f, 0f, 4.48f, 0f, 10f)
                curveTo(0f, 15.52f, 4.48f, 20f, 10f, 20f)
                curveTo(15.52f, 20f, 20f, 15.52f, 20f, 10f)
                curveTo(20f, 4.48f, 15.52f, 0f, 10f, 0f)
                close()
                moveTo(10f, 18f)
                curveTo(5.58f, 18f, 2f, 14.42f, 2f, 10f)
                curveTo(2f, 5.58f, 5.58f, 2f, 10f, 2f)
                curveTo(14.42f, 2f, 18f, 5.58f, 18f, 10f)
                curveTo(18f, 14.42f, 14.42f, 18f, 10f, 18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2F33))) {
                moveTo(10f, 15f)
                curveTo(12.761f, 15f, 15f, 12.761f, 15f, 10f)
                curveTo(15f, 7.239f, 12.761f, 5f, 10f, 5f)
                curveTo(7.239f, 5f, 5f, 7.239f, 5f, 10f)
                curveTo(5f, 12.761f, 7.239f, 15f, 10f, 15f)
                close()
            }
        }.build()

        return _FilterCurcleFilled!!
    }

@Suppress("ObjectPropertyName")
private var _FilterCurcleFilled: ImageVector? = null
