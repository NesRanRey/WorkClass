package com.example.workclass.ui.screens

import android.widget.CalendarView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclass.R
import com.example.workclass.data.model.MenuModel
import com.example.workclass.data.model.PostCardModel
import com.example.workclass.ui.components.PostCardCompactComponent
import com.example.workclass.ui.components.PostCardComponent
import com.example.workclass.ui.components.PostCardComponent
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale


@Composable
fun ComponentsScreen (navController: NavHostController){
  val menuOptions = arrayOf(
      MenuModel(1, "Buttons", "buttons", Icons.Filled.Home),
      MenuModel(2, "Floating Buttons", "floating-buttons", Icons.Filled.Menu),
      MenuModel(3,"Progress","progress", Icons.Filled.Star),
      MenuModel(4,"Chips", "chips", Icons.Filled.ShoppingCart),
      MenuModel(5, "Sliders", "sliders", Icons.Filled.Build),
      MenuModel(6,"Switches", "switches", Icons.Filled.Person),
      MenuModel(7,"Badges", "badges", Icons.Filled.Face),
      MenuModel(8,"Snack Bars", "snack-bars", Icons.Filled.AddCircle),
      MenuModel(9,"Alert Dialogs", "alert-dialogs", Icons.Filled.Lock),
      MenuModel(10,"Bars", "bars",Icons.Filled.Settings ),
      MenuModel(11, "Input Fields", "input-fields", Icons.Filled.Call),
      MenuModel(12, "DatePicker", "date-picker", Icons.Filled.DateRange),
      MenuModel(13, "Date Picker Dialog", "date-picker-dialog", Icons.Filled.ThumbUp),
      MenuModel(14, "Date Range Picker", "date-range-picker", Icons.Filled.PlayArrow),
      MenuModel(15, "Pull to Refresh", "pull-to-refresh", Icons.Filled.Search),
      MenuModel(16, "Bottom Sheets", "bottom-sheets", Icons.Filled.Info),
      MenuModel(17, "Single Choice Segmented Button", "Single-Choice-Segmented-Button", Icons.Filled.Warning),
      MenuModel(18, "Multi Choice Segmented Button", "Multi-Choice-Segmented-Button", Icons.Filled.Close)
  )

    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed )
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions){item ->
                        NavigationDrawerItem(

                    icon = { Icon(item.icon, contentDescription = "")},
                    label = { Text(item.title) },
                    selected = false,
                    onClick = {
                        option = item.option
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }

        }
                /*NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Check, contentDescription = "")},
                    label = { Text("Floating Buttons")},
                    selected = false,
                    onClick = {
                        option = "floating-buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "")},
                    label = { Text("Progress")},
                    selected = false,
                    onClick = {
                        option = "progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Add, contentDescription = "")},
                    label = { Text("Chips")},
                    selected = false,
                    onClick = {
                        option = "chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "")},
                    label = { Text("Sliders")},
                    selected = false,
                    onClick = {
                        option = "sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Build, contentDescription = "")},
                    label = { Text("Switches")},
                    selected = false,
                    onClick = {
                        option = "switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.ThumbUp, contentDescription = "")},
                    label = { Text("Badges")},
                    selected = false,
                    onClick = {
                        option = "badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Face, contentDescription = "")},
                    label = { Text("SnackBars")},
                    selected = false,
                    onClick = {
                        option = "snack-bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Menu, contentDescription = "")},
                    label = { Text("AlertDialogs")},
                    selected = false,
                    onClick = {
                        option = "alertdialogs"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )*/
            }
        }
    ) {
        Column {
            when (option) {
                "buttons" -> {
                    Buttons()
                }

                "floating-buttons" -> {
                    FloatingButtons()
                }

                "progress" -> {
                    Progress()
                }

                "chips" -> {
                    Chips()
                }

                "sliders" -> {
                    Sliders()
                }

                "switches" -> {
                    Switches()
                }

                "badges" -> {
                    Badges()
                }

                "snack-bars" -> {
                    SnackBars()
                }

                "alert-dialogs" -> {
                    AlertDialogs()
                }

                "bars" -> {
                    Bars()
                }

                "input-fields" -> {
                    InputFields()
                }
                "date-picker" -> {
                    DatePicker()
                }
                "date-picker-dialog" -> {
                    DatePickerDialog()
                }
                "date-range-picker" -> {
                    DateRangePicker()
                }

                "pull-to-refresh" -> {
                    PullToRefresh()
                }
                "bottom-sheets" -> {
                    BottomSheets()
                }
                "Single-Choice-Segmented-Button" -> {
                    SingleChoiceSegmentedButton()
                }
                "Multi-Choice-Segmented-Button" -> {
                    MultiChoiceSegmentedButton()
            }

        }

    }
    }
    }


//@Preview(showBackground = true)
@Composable
fun Buttons (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ){
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton (onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton (onClick = {}) {
            Text("Outline")
        }
        ElevatedButton (onClick = {}) {
            Text("Elevated")
        }
       TextButton(onClick = {}) {
           Text("Text")
       }
    }
}

//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        LargeFloatingActionButton (onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        ExtendedFloatingActionButton (onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
            Text(text = "Button")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun Progress(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        AssistChip(
            onClick= {},
            label = {Text("Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                    )
            }
        )
        var selected by remember { mutableStateOf(false)}
        FilterChip(
            selected = selected,
            onClick = {selected = !selected},
            label = { Text("Filter Chip")},
            leadingIcon = if (selected) {
            {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
            }else {
                     null

            }
        )
        InputChipExamples("Dismiss", {})
    }
}

@Composable
fun InputChipExamples (
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if(!enabled) return

    InputChip(
        label = {Text (text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
                )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun Sliders (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Switches (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {checked = it}
        )
        var checked2 by remember { mutableStateOf(true)}
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true)}
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Badges (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var itemCount by remember { mutableStateOf(0)}
        BadgedBox(
            badge = {
                if(itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shoping cart icon"
            )

        }

        Button(
          onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}

@Composable
fun SnackBars() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }
        Button(::launchSnackBar){
            Text("Send Message")
            }
        }
    }

@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        Button(onClick = { showAlertDialog = true }) {
            Text("Delete File")
        }

        if (showAlertDialog) {
            AlertDialog(
                onDismissRequest = {
                    showAlertDialog = false
                },
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            contentDescription = "Warning Icon",
                            tint = Color.Red,
                            modifier = Modifier
                                .size(32.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Confirm Deletion",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                },
                text = {
                    Text(
                        "Do you really want to delete this file?",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }

        Text(selectedOption)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column (modifier = Modifier
        .fillMaxSize()
    ){

        LargeTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = { Text("Screen Title")},
            actions= {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search button")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings button")
                }
            }
        )
        /*
        val arrayposts= arrayOf(
            PostCardModel(1, "Title 1", "Text 1", R.drawable.p),
            PostCardModel(2, "Title 2", "Text 2", R.drawable.p),
            PostCardModel(3, "Title 3", "Text 3", R.drawable.p),
            PostCardModel(4, "Title 4", "Text 4", R.drawable.p),
            PostCardModel(5, "Title 5", "Text 5", R.drawable.p),
            PostCardModel(6, "Title 6", "Text 6", R.drawable.p),
            PostCardModel(7, "Title 7", "Text 7", R.drawable.p),
            PostCardModel(8, "Title 8", "Text 8", R.drawable.p),
            PostCardModel(9, "Title 9", "Text 9", R.drawable.p),
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize= 160.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            items(arrayposts){ item ->
                PostCardComponent(item.id, item.title, item.text, item.image)

            }
        }
        */
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Adaptive()
        }
        BottomAppBar (
            containerColor = Color.DarkGray,
            contentColor= Color.White
        ){
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Info, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Face, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Star, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Warning, contentDescription = "" )
            }
        }

        }
    }



@Composable
fun Adaptive (){
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    // Compact width < 600 dp Phone Portrait
    // Medium Width >= 600 dp < 840 dp Tablet Portrait
    // Expanded Width >= 840 dp Tablet Landscape

    // Compact Height < 480 dp Phone Landscape
    // Medium Height >= 480 dp  < 900 dp Tablet Landscape Phone Portrait
    // Expanded Height >= 900 dp  Tablet Portrait

    val arrayposts= arrayOf(
        PostCardModel(1, "Title 1", "Text 1", R.drawable.p),
        PostCardModel(2, "Title 2", "Text 2", R.drawable.p),
        PostCardModel(3, "Title 3", "Text 3", R.drawable.p),
        PostCardModel(4, "Title 4", "Text 4", R.drawable.p),
        PostCardModel(5, "Title 5", "Text 5", R.drawable.p),
        PostCardModel(6, "Title 6", "Text 6", R.drawable.p),
        PostCardModel(7, "Title 7", "Text 7", R.drawable.p),
        PostCardModel(8, "Title 8", "Text 8", R.drawable.p),
        PostCardModel(9, "Title 9", "Text 9", R.drawable.p),
    )

    if (width == WindowWidthSizeClass.COMPACT){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ){
            items(arrayposts){ item ->
                PostCardComponent(item.id, item.title, item.text, item.image)

            }
        }


    }else if (height == WindowHeightSizeClass.COMPACT)
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ){
            items(arrayposts){ item ->
                PostCardCompactComponent(item.id, item.title, item.text, item.image)

            }
        }
    }
}

@Composable
fun InputFields() {
    var fullName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val isFormValid = fullName.isNotEmpty() &&
            username.isNotEmpty() &&
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            password.length >= 8

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = "Username") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches(),
            supportingText = {
                if (email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Text("Enter a valid email address")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {

                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = password.isNotEmpty() && password.length < 8,
            supportingText = {
                if (password.isNotEmpty() && password.length < 8) {
                    Text("The Password must have at least 8 characters ")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                println("User Data - Name: $fullName, Username: $username, Email: $email, Password: $password")
            },
            enabled = isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Send", fontSize = 18.sp)
        }

        TextButton(
            onClick = { println("Forgot Password clicked") },
            modifier = Modifier.padding(top = 14.dp)
        ) {
            Text("Forgot Password", color = Color.Blue, fontSize = 16.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(){
    val datePickerState = rememberDatePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        DatePicker(state = datePickerState)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val selectedDate = datePickerState.selectedDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
        }) {
            Text("Confirm Date ")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog() {
    var showDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var selectedDate by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Select Date")
        }

        if (selectedDate != null) {
            Text("You selected: $selectedDate")
        }

        // DatePickerDialog
        if (showDialog) {
            DatePickerDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(
                        onClick = {

                            datePickerState.selectedDateMillis?.let { millis ->
                                selectedDate = Instant.ofEpochMilli(millis)
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate()
                                    .toString()
                            }
                            showDialog = false
                        }
                    ) {
                        Text("Select")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePicker(){
    val rangePickerState = rememberDateRangePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        DateRangePicker(state = rangePickerState)
        Button(onClick = {
            val startDate = rangePickerState.selectedStartDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
            val endDate = rangePickerState.selectedEndDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
        }){
            Text("Confirm Range")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullToRefresh() {
    var isRefreshing by remember { mutableStateOf(false) }
    var itemList by remember { mutableStateOf(List(10) { it + 1 }) }
    val coroutineScope = rememberCoroutineScope()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            coroutineScope.launch {
                isRefreshing = true
                delay(2000)
                itemList = (1..10).shuffled()
                isRefreshing = false
            }
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        ) {
            items(itemList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = "Item $item",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showBottomSheet = true }) {
            Text("Open Bottom Sheet")
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("This is a Bottom Sheet")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { showBottomSheet = false }) {
                    Text("Close")
                }
            }
        }
    }
}

@Composable
fun SingleChoiceSegmentedButton() {
    val options = listOf("Day", "Month", "Year")
    var selectedOption by remember { mutableStateOf(0)  }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            options.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(horizontal = 4.dp)
                        .background(
                            color = if (index == selectedOption) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant,
                            shape = when (index) {
                                0 -> MaterialTheme.shapes.small.copy(
                                    topEnd = CornerSize(0),
                                    bottomEnd = CornerSize(0)
                                )
                                options.lastIndex -> MaterialTheme.shapes.small.copy(
                                    topStart = CornerSize(0),
                                    bottomStart = CornerSize(0)
                                )
                                else -> MaterialTheme.shapes.small.copy(
                                    topStart = CornerSize(0),
                                    topEnd = CornerSize(0),
                                    bottomStart = CornerSize(0),
                                    bottomEnd = CornerSize(0)
                                )
                            }
                        )
                        .clickable { selectedOption = index }
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        RadioButton(
                            selected = (index == selectedOption),
                            onClick = { selectedOption = index },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = if (index == selectedOption) MaterialTheme.colorScheme.onPrimary
                                else MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedColor = Color.Transparent
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = label,
                            color = if (index == selectedOption) MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiChoiceSegmentedButton() {
    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }
    val options = listOf("Walk", "Ride", "Drive")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selectedOptions[index],
                    onCheckedChange = {
                        selectedOptions[index] = !selectedOptions[index]
                    },
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        inactiveContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        activeContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        inactiveContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    icon = { SegmentedButtonDefaults.Icon(selectedOptions[index]) },
                    label = {
                        when (label) {
                            "Walk" -> Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Directions Walk"
                            )
                            "Ride" -> Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Directions Bus"
                            )
                            "Drive" -> Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Directions Car"
                            )
                        }
                    }
                )
            }
        }
    }
}
