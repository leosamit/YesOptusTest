package com.samit.yesoptustest.binding

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.samit.yesoptustest.util.SpinnerExtension
import com.samit.yesoptustest.util.SpinnerExtension.setSpinnerEntries
import com.samit.yesoptustest.util.SpinnerExtension.setSpinnerItemSelectedListener
import com.samit.yesoptustest.util.SpinnerExtension.setSpinnerValue


@BindingAdapter("entries")
fun Spinner.setEntries(entries: List<String>?) {
    setSpinnerEntries(entries)
}

@BindingAdapter("onItemSelected")
fun Spinner.setItemSelectedListener(itemSelectedListener: SpinnerExtension.ItemSelectedListener?) {
    setSpinnerItemSelectedListener(itemSelectedListener)
}

@BindingAdapter("newValue")
fun Spinner.setNewValue(newValue: Any?) {
    setSpinnerValue(newValue)
}
