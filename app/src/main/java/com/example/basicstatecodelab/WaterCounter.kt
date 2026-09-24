package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable // Paso 11: Para persistir datos
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Paso 9: Composable con estado (Stateful)
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // Paso 11: Se cambia remember por rememberSaveable
        var count by rememberSaveable { mutableStateOf(0) }

        // Llamada al componente sin estado
        StatelessCounter(count, { count++ }, modifier)
    }
}

// Paso 9: Composable sin estado (Stateless)
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("Has bebido $count vasos de agua.")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Agregar vaso")
        }
    }
}