package com.brokenprotocol.kotlincomposedemo

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brokenprotocol.kotlincomposedemo.ui.KotlinComposeDemoAppViewModel
import com.brokenprotocol.kotlincomposedemo.ui.screens.DetailListScreen
import com.brokenprotocol.kotlincomposedemo.ui.screens.ExploreScreen
import kotlinx.coroutines.launch

enum class DemoScreen(@StringRes val title: Int) {
    Explore(title = R.string.explore_screen),
    DetailList(title = R.string.detail_List_screen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KotlinComposeDemoAppBar(
    currentScreen: DemoScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    drawerTapped: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = drawerTapped) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = stringResource(R.string.menu_button)
                )
            }
        }
    )
}

@Composable
fun KotlinComposeDemoApp (
    viewModel: KotlinComposeDemoAppViewModel = viewModel(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = DemoScreen.valueOf(
        backStackEntry?.destination?.route ?: DemoScreen.Explore.name
    )

    Surface {

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                val coroutineScope = rememberCoroutineScope()
                ModalDrawerSheet(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight())
                {
                    Text("Drawer")
                }
            }
        ) {

            Scaffold(
                topBar = {
                    val coroutineScope = rememberCoroutineScope()
                    KotlinComposeDemoAppBar(
                        currentScreen = currentScreen,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                        drawerTapped = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }
            ) { innerPadding ->

                NavHost(
                    navController = navController,
                    startDestination = DemoScreen.Explore.name,
                    modifier = Modifier.padding(innerPadding)
                ) {

                    composable(
                        route = DemoScreen.Explore.name,
                    ) {
                        ExploreScreen(
                            modifier = Modifier,
                            onCategorySelected = {
                                navController.navigate(DemoScreen.DetailList.name)
                            }
                        )
                    }

                    composable(
                        route = DemoScreen.DetailList.name,
                    ) {
                        DetailListScreen()
                    }

                }

            }
        }
    }

}