package com.main.generation_from_phone.data.dialog

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.main.generation_from_phone.R
import com.main.generation_from_phone.domain.dialog.ManageGeneratedDialogFromPhone

class ManageGeneratedDialogFromPhoneImpl : ManageGeneratedDialogFromPhone {

    override fun createDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_qr_code_from_phone)

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window?.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT

        dialog.window?.attributes = layoutParams
        return dialog
    }
}