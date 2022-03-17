package com.mandarjoshi.androidnextgen

import android.app.Application
import com.mandarjoshi.androidnextgen.di.ApplicationComponent
import com.mandarjoshi.androidnextgen.di.DaggerApplicationComponent

class AndroidNextGenApplication: Application() {
    var appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}
