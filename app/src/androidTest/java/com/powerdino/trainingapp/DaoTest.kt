package com.powerdino.trainingapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.powerdino.trainingapp.data.AppDatabase
import com.powerdino.trainingapp.data.ExerciseDao
import com.powerdino.trainingapp.data.ExerciseEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class DaoTest{
    private lateinit var exerciseDao: ExerciseDao
    private lateinit var appDatabase: AppDatabase

    private var exercise1 = ExerciseEntity(
        id = 1,
        difficultyLevel = "Hard",
        nameOf = "Exercise 1",
        borderColor = 12,
        pictureExercise = 12,
        descriptionOfExercise = "Lorem Ipsum",
        repets = "10"
    )

    private var exercise2 = ExerciseEntity(
        id = 2,
        difficultyLevel = "Medium",
        nameOf = "Exercise 2",
        borderColor = 1,
        pictureExercise = 11,
        descriptionOfExercise = "Lorem Ipsum 1",
        repets = "10"
    )

    private suspend fun addOneItemToDb(){
        exerciseDao.insert(exercise1)
    }

    private suspend fun addTwoItemsToDb(){
        exerciseDao.insert(exercise1)
        exerciseDao.insert(exercise2)
    }

    @Test
    @Throws(Exception::class)
    fun daoInsertExerciseToDb() = runBlocking {
        addOneItemToDb()
        val allExercises = exerciseDao.getAll().first()
        assertEquals(allExercises[0],exercise1)

    }

    @Test
    @Throws(Exception::class)
    fun daoGetAllItemsReturnAllItems() = runBlocking {
        addTwoItemsToDb()
        val allExercises = exerciseDao.getAll().first()

        assertEquals(allExercises[0], exercise1)
        assertEquals(allExercises[1], exercise2)
    }

    @Test
    @Throws(Exception::class)
    fun daoDeleteEverythingFromDb() = runBlocking {
        addTwoItemsToDb()
        exerciseDao.delete(exercise1)
        exerciseDao.delete(exercise2)

        val allExercises = exerciseDao.getAll().first()
        assertTrue(allExercises.isEmpty())
    }

    @Before
    fun createDb(){
        val context: Context = ApplicationProvider.getApplicationContext()

        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        exerciseDao = appDatabase.execiseDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        appDatabase.close()
    }
}