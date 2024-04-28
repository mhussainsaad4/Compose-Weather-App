package com.example.compose_weather_app.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose_weather_app.extensions.ActivityBaseTheme
import com.example.compose_weather_app.extensions.CText

@Composable
fun Home() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .layoutId("ParentLayout")
        .padding(all = 12.dp)
) {

    var autoCompleteTextValue by remember { mutableStateOf("") }
    var dropDownItemList = remember { mutableListOf<String>() }

    val (heading, autoCompleteView, dropDownMenu) = createRefs()

    Box(
        modifier = Modifier.constrainAs(heading) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    ) {
        CText(text = "Choose Your Current Location")
    }

    AutoCompleteText(
        value = autoCompleteTextValue,
        modifier = Modifier
            .constrainAs(autoCompleteView) {
                top.linkTo(heading.bottom)
            }
            .fillMaxWidth()
            .padding(top = 20.dp),
        onValueChange = {
            autoCompleteTextValue = it
        },
        onOptionSelected = {
            autoCompleteTextValue = it
        },
        dropDownMenuModifier = Modifier.constrainAs(dropDownMenu) {
            top.linkTo(autoCompleteView.bottom)
            start.linkTo(autoCompleteView.start)
            end.linkTo(autoCompleteView.end)
        },
        suggestions = mutableListOf("Hi", "Hello", "Hey", "Ham", "Hamara"),
    )
}

@Composable
fun AutoCompleteText(
    value: String,
    onValueChange: (String) -> Unit,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    dropDownMenuModifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    suggestions: MutableList<String>,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { text -> if (text !== value) onValueChange(text) },
        modifier = modifier,
        label = label,
    )

    Box(
        modifier = dropDownMenuModifier
    ) {
        DropdownMenu(
            expanded = suggestions.isNotEmpty(),
            onDismissRequest = { },
            modifier = Modifier.fillMaxWidth(),
            properties = PopupProperties(
                focusable = false,
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            )
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(
                    text = { CText(text = label) },
                    onClick = { onOptionSelected(label) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() = ActivityBaseTheme {
    Home()
}