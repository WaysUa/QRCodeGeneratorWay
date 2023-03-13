package com.main.generation_from_link.domain.dialog

import android.app.Dialog
import android.content.Context

interface ManageGeneratedDialogFromLink {

    fun createDialog(context: Context): Dialog
}