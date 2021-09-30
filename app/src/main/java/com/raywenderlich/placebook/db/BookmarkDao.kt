package com.raywenderlich.placebook.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raywenderlich.placebook.model.Bookmark
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE

// 1
    @Dao
    interface BookmarkDao {
        // 2
        @Query("SELECT * FROM Bookmark")
        fun loadAll(): LiveData<List<Bookmark>>
        // 3
        @Query("SELECT * FROM Bookmark WHERE id = :bookmarkId")
        fun loadBookmark(bookmarkId: Long): Bookmark
        @Query("SELECT * FROM Bookmark WHERE id = :bookmarkId")
        fun loadLiveBookmark(bookmarkId: Long): LiveData<Bookmark>
        // 4
        @Insert(onConflict = IGNORE)
        fun insertBookmark(bookmark: Bookmark): Long
        // 5
        @Update(onConflict = REPLACE)
        fun updateBookmark(bookmark: Bookmark)
        // 6
        @Delete
        fun deleteBookmark(bookmark: Bookmark)
    }