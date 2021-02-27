/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.Item
import com.example.androiddevchallenge.ui.DetailPage
import com.example.androiddevchallenge.ui.ListItem
import com.example.androiddevchallenge.ui.theme.MyTheme

private val data = listOf(
    Item(
        id = 0,
        name = "Ichiro",
        age = 2,
        image = R.drawable.ichiro
    ),
    Item(
        id = 1,
        name = "Hanako",
        age = 4,
        image = R.drawable.hanako
    ),
    Item(
        id = 2,
        name = "Sanshiro",
        age = 1,
        image = R.drawable.sanshiro
    ),

    Item(
        id = 3,
        name = "Shuriken",
        age = 12,
        image = R.drawable.shuriken
    ),

)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
            Surface(color = MaterialTheme.colors.background) {
                ListItem(items = data, navController)
            }
        }
        composable("/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
            val id = it.arguments?.getInt("id") ?: 0
            println("id: $id")
            Surface(color = MaterialTheme.colors.background) {
                DetailPage(data, id)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
