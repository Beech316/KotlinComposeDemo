package com.brokenprotocol.kotlincomposedemo

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brokenprotocol.kotlincomposedemo.ui.KotlinComposeDemoAppViewModel
import com.brokenprotocol.kotlincomposedemo.ui.screens.DetailListScreen
import com.brokenprotocol.kotlincomposedemo.ui.screens.DetailScreen
import com.brokenprotocol.kotlincomposedemo.ui.screens.ExploreScreen
import com.brokenprotocol.kotlincomposedemo.ui.screens.login.LoginEmailScreen
import com.brokenprotocol.kotlincomposedemo.ui.screens.login.LoginSplashScreen
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension
import kotlinx.coroutines.launch

enum class DemoScreen(@StringRes val title: Int) {
    Explore(title = R.string.explore_screen),
    DetailList(title = R.string.detail_List_screen),
    Detail(title = R.string.detail_screen),
    LoginSplash(title = R.string.login_splash_screen),
    LoginEmail(title = R.string.login_email_screen)
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

    val dimens = LocalDimension.current

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
                        .fillMaxHeight()
                ) {

                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(0.6f)
                            .height(dimens.loginCategoryButtonHeight)
                            .padding(vertical = dimens.medium),
                        border = BorderStroke(dimens.extraExtraSmall, Color.Blue),
                        onClick = {
                            navController.navigate(DemoScreen.LoginSplash.name)
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    ) {
                            Text(text = stringResource(id = R.string.login_button), color = Color.Blue, fontSize = dimens.loginCategoryButtonTitle)
                    }
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

                val exploreUiState by viewModel.exploreUiState.collectAsState()
                val detailUIState by viewModel.detailUiState.collectAsState()

                NavHost(
                    navController = navController,
                    startDestination = DemoScreen.Explore.name,
                    modifier = Modifier.padding(innerPadding)
                ) {

                    composable(
                        route = DemoScreen.Explore.name,
                    ) {
                        ExploreScreen(
                            categoryList = exploreUiState.categoryList,
                            detailList = exploreUiState.detailList,
                            modifier = Modifier,
                            onCategorySelected = {
                                navController.navigate(DemoScreen.DetailList.name)
                            },
                            onDetailSelected = {
                                viewModel.updateSelectedDetail(it)
                                navController.navigate(DemoScreen.Detail.name)
                            }
                        )
                    }

                    composable(
                        route = DemoScreen.DetailList.name,
                    ) {
                        DetailListScreen(
                            detailList = exploreUiState.detailList,
                            onDetailSelected = {
                                viewModel.updateSelectedDetail(it)
                                navController.navigate(DemoScreen.Detail.name)
                            }
                        )
                    }

                    composable(
                        route = DemoScreen.Detail.name,
                    ) {
                        exploreUiState.selectedDetail?.let {
                            DetailScreen(
                                detail = it,
                                liked = detailUIState.liked,
                                onLikeSelected = {
                                    viewModel.updateDetailLiked(!detailUIState.liked)
                                }
                            )
                        }
                    }

                    composable(
                        route = DemoScreen.LoginSplash.name,
                    ) {
                        LoginSplashScreen(onEmailSelected = {
                            navController.navigate(DemoScreen.LoginEmail.name)
                        })
                    }

                    composable(
                        route = DemoScreen.LoginEmail.name,
                    ) {
                        LoginEmailScreen()
                    }

                }

            }
        }
    }

}