package com.falconteam.laboratorio_5.data.database.Entity.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.falconteam.laboratorio_5.data.database.Entity.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM posts")
    fun getAllPosts(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Query("UPDATE posts SET title = :title, description = :description WHERE id = :postId")
    suspend fun updatePost(postId: String, title: String, description: String)

    @Query("DELETE FROM posts WHERE id = :postId")
    suspend fun deletePostById(postId: String)
}