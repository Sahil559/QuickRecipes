package com.example.quickrecipes.Data


sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object RecipeDetailScreen : Screen("recipe_detail_screen")

}