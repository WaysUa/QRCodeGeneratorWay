package com.main.core.communication

import android.net.Uri

interface CoreCommunication : ValueCoreCommunication, MapCoreCommunication {

    class Base(

    ): CoreCommunication {


    }
}

interface ValueCoreCommunication {

}

interface MapCoreCommunication {

}