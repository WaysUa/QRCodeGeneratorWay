package com.main.generation_from_text.domain.dialog

import android.app.Dialog
import android.content.Context
import android.view.WindowManager

interface ManageGeneratedDialogFromText {

    fun createDialog(context: Context): Dialog
}