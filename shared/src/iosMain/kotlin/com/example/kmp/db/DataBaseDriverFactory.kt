package com.example.kmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import example.kmp.db.SimpleSharedDataBase

actual class DataBaseDriverFactory {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = SimpleSharedDataBase.Schema,
            name = "SimpleSharedDataBase.db"
        )
}