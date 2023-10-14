package com.example.thirtydayforbeinggoodmuslims

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thirtydayforbeinggoodmuslims.model.Activity

@Composable
fun ActivityList(
    activities: List<Activity>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = contentPadding) {
        items(activities) {
            ActivityItem(activity = it, modifier = modifier.padding(16.dp))
        }
    }
}

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(elevation = CardDefaults.cardElevation(2.dp), modifier = modifier) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = stringResource(id = activity.dayRes),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(id = activity.titleRes),
                style = MaterialTheme.typography.titleMedium
            )
            ActivityImage(
                imgRes = activity.imgRes,
                onClick = {
                    expanded = !expanded
                })
            if (expanded) Text(text = stringResource(id = activity.descRes))
        }
    }
}

@Composable
fun ActivityImage(
    @DrawableRes imgRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
    ) {
        Button(
            onClick = onClick,
            contentPadding = PaddingValues(0 .dp),
            shape = RoundedCornerShape(8 .dp)
        ) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = null
            )
        }
    }
}