package com.example.travelapp.util

import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.android.material.snackbar.Snackbar

fun View.showProgressSnackbar(message: String, duration: Int): Snackbar {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
    val contentLayout =
        snackbar.view.findViewById<View>(com.google.android.material.R.id.snackbar_text).parent as ViewGroup
    val progressBar = ProgressBar(this.context)
    contentLayout.addView(progressBar)

    // Set custom duration
    Handler().postDelayed({
        snackbar.dismiss()
    }, duration.toLong())

    snackbar.show()
    return snackbar
}