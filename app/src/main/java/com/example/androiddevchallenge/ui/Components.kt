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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Item

@Composable
fun ListItem(items: List<Item>, navHostController: NavHostController) {
    LazyColumn {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clickable { navHostController.navigate("/${item.id}") }
            ) {
                println("components: ${item.id}")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = item.name,
                        Modifier.size(48.dp, 48.dp)
                    )
                    Box(modifier = Modifier.width(8.dp))
                    Column {
                        Text("name: ${item.name}")
                        Text("age: ${item.age}")
                    }
                }
            }
        }
    }
}

@Composable
fun DetailPage(items: List<Item>, index: Int) {
    val item = items[index]
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.image), contentDescription = item.name,
            modifier = Modifier
                .fillMaxWidth()
        )
        Box(modifier = Modifier.height(8.dp))
        Text("name: ${item.name}")
        Text("age: ${item.age}")
    }
}
