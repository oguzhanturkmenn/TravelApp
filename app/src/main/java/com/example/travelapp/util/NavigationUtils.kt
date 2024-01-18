package com.example.travelapp.util

import android.view.View
import androidx.navigation.Navigation

fun Navigation.goTo(view: View, id: Int) {
    findNavController(view).navigate(id)

}