package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        linearLayout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val removeTextView = linearLayout.childCount == 1
        outState.putBoolean(KEY1, removeTextView)

        val buttonDisable = button.isEnabled
        outState.putBoolean(KEY2, buttonDisable)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val remoteTextView = savedInstanceState.getBoolean(KEY1)
        if (remoteTextView)
            linearLayout.removeView(textView)

        val buttonDisable = savedInstanceState.getBoolean(KEY2)
        if (!buttonDisable)
            button.isEnabled = false
    }

    companion object {
        private const val KEY1 = "key1"
        private const val KEY2 = "key2"
    }
}