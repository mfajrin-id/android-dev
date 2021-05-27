package com.bangkit.kakikeenam.utils

import android.app.Dialog
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bangkit.kakikeenam.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.addChildFragment(fragment: Fragment, frameId: Int) {

    val transaction = childFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment).commit()
}

fun View.showErrSnackBar(view: View, message: String, errorMessage: Boolean) {
    val snackBar =
        Snackbar.make(findViewById(view.id), message, Snackbar.LENGTH_LONG)
    val snackBarView = snackBar.view

    if (errorMessage){
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.red_err
            )
        )
    }else {
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.green_success
            )
        )
    }
    snackBar.show()
}

//Progress dialog
private lateinit var progressDialog: Dialog

fun View.showProgressDialog() {
    progressDialog = Dialog(context)
    progressDialog.setContentView(R.layout.progress_dialog)
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    progressDialog.show()
}
fun hideProgressDialog() {
    progressDialog.hide()
}