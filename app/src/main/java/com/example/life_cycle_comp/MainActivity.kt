package com.example.life_cycle_comp


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.life_cycle_comp.ui.theme.LifecyclecompTheme


class MainActivity : ComponentActivity() {

    private val logMessages = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMessage("onCreate")
        showToast("This is MainActivity")
        setContent {
            LifecyclecompTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Greeting("Pavan (2347243)", logMessages)

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        logMessage("onStart")
    }

    override fun onResume() {
        super.onResume()
        logMessage("onResume")
    }

    override fun onPause() {
        super.onPause()
        logMessage("onPause")
    }

    override fun onStop() {
        super.onStop()
        logMessage("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logMessage("onDestroy")
    }

    private fun logMessage(message: String) {
        Log.d(TAG, message)
        logMessages.add(message)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}



@Composable
fun Greeting(message: String, logMessages: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally

    )
    {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
            modifier = Modifier.padding(bottom = 26.dp, top = 50.dp))
        LogScreen(logMessages = logMessages)
    }

}

@Composable
fun LogScreen(logMessages: List<String>) {
    LazyColumn {
        items(logMessages) { message ->
            Text(
                modifier = Modifier,
                text = message,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp)
            )
        }
    }
}