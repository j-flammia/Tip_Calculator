package org.hyperskill.calculator.tip

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_text.doOnTextChanged { _, _, _, _ -> setTextView() }
        slider.addOnChangeListener(Slider.OnChangeListener { _,_,_-> setTextView() })
    }

    private fun setTextView() = if (edit_text.text.isNotBlank()) {
        val total = "%.2f".format((edit_text.text.toString().toFloat() * slider.value) / 100)
        val tip = getString(R.string.tip, total)
        text_view.text = tip
    } else text_view.visibility = View.INVISIBLE
}