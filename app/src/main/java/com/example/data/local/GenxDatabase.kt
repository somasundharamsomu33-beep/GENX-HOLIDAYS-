package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BookingEntity::class, WishlistEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GenxDatabase : RoomDatabase() {
    abstract fun bookingDao(): BookingDao
    abstract fun wishlistDao(): WishlistDao

    companion object {
        @Volatile
        private var INSTANCE: GenxDatabase? = null

        fun getInstance(context: Context): GenxDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GenxDatabase::class.java,
                    "genx_holidays.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
