package app.what.gorogeuslugi.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.buttonBlack
import gorogeuslugi.composeapp.generated.resources.Res
import gorogeuslugi.composeapp.generated.resources.filter
import org.jetbrains.compose.resources.painterResource

@Composable
fun CustomTextField(
    placeholder: String,
    fieldColor: Color = Color(0xFFebeef1),
    trailingImage: ImageVector? = null,
    leadingImage: ImageVector? = Icons.Default.Search,
    inputText: (String) -> Unit,
    trailingAction: (() -> Unit)? = null
) {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        value = text, onValueChange = {
            text = it
            inputText(it)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(42.dp)
                    .border(width = 1.dp, Color(0xFFebeef1), RoundedCornerShape(5.dp))
                    .background(
                        fieldColor,
                        shape = RoundedCornerShape(5.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingImage?.let {
                    Gap(8)
                    Icon(
                        leadingImage, "",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFFBCBCBC),
                    )
                }
                Gap(size = 8)
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontSize = 14.sp,
                            color = buttonBlack,

                            )
                    }
                    innerTextField()
                }
                trailingAction?.let {
                    trailingImage?.let {
                        Image(
                            imageVector = trailingImage,
                            contentDescription = "",
                            modifier = Modifier
                                .size(21.dp)
                                .clickable {
                                    it()
                                }
                        )
                    }
                }
                Gap(8)
            }
        }
    )
}