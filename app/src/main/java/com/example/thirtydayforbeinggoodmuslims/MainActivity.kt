@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.thirtydayforbeinggoodmuslims

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydayforbeinggoodmuslims.data.ActivityRepository
import com.example.thirtydayforbeinggoodmuslims.ui.theme.ThirtydayforbeinggoodmuslimsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtydayforbeinggoodmuslimsTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TobBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.bodyLarge) },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun ThirtyApp() {
    val activities = ActivityRepository.activities
    ThirtydayforbeinggoodmuslimsTheme {
        Scaffold(
            topBar = {
                TobBar()
            }
        ) {
            ActivityList(activities = activities , contentPadding = it)
        }
    }
}