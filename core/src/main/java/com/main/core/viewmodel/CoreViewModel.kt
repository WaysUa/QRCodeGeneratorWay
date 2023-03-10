package com.main.core.viewmodel

import android.net.Uri
import com.main.core.base.BaseViewModel
import com.main.core.communication.CoreCommunication
import com.main.core.communication.MapCoreCommunication
import com.main.core.communication.ValueCoreCommunication

class CoreViewModel(
    private val coreCommunication: CoreCommunication
) : BaseViewModel(), MapCoreCommunication, ValueCoreCommunication {


}