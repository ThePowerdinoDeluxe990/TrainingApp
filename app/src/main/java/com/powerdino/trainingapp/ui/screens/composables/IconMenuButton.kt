package com.powerdino.trainingapp.ui.screens.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun IconMenuButton(
    onClick:() -> Unit,
    @StringRes description:Int,
    icon: ImageVector,
    iconName:String,
    color: Color,
    fontWeight: FontWeight
){
    Column (
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        IconButton(
            onClick = onClick,
            colors = IconButtonColors(
                containerColor = color,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.onSecondary
            )
        ) {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = description)
            )
        }

        Text(
            text = iconName,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = fontWeight
        )
    }
}