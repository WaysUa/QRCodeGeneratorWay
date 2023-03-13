package com.main.generation_from_text.data.dialog

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.main.generation_from_text.domain.dialog.ManageGeneratedDialogFromText

class ManageGeneratedDialogFromTextImpl : ManageGeneratedDialogFromText {

    override fun createDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(com.main.core.R.layout.dialog_qr_code_from_text)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window?.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT

        dialog.window?.attributes = layoutParams
        return dialog
    }
}