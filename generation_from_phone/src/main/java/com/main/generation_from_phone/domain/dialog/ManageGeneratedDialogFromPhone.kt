package com.main.generation_from_phone.domain.dialog

import android.app.Dialog
import android.content.Context

interface ManageGeneratedDialogFromPhone {

    fun createDialog(context: Context): Dialog
}