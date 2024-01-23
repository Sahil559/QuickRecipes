package com.example.quickrecipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickrecipes.Data.Screen

@Composable
fun QuickRecipeApp(navController : NavHostController){
    val QuickRecipeAppVM : MainViewModel= viewModel()
    val viewstate by QuickRecipeAppVM.categoriesState

    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route,
        ){

        composable(Screen.HomeScreen.route){
            HomeScreen(viewstate= viewstate, navigatetoDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.RecipeDetailScreen.route)
            })
        }
        composable(Screen.RecipeDetailScreen.route){

                val category=navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?:Category("","","", "")
                detailScreen(category = category)
            }



    }
}
