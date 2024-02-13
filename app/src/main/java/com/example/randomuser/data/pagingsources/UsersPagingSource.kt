package com.example.randomuser.data.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.randomuser.data.models.user.Users
import com.example.randomuser.domain.apis.UsersService
import javax.inject.Inject

class UsersPagingSource @Inject constructor(
    private val usersService: UsersService,
) : PagingSource<Int, Users>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Users> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 0
            val response = usersService.getUsers(
                page = nextPageNumber,
                results = params.loadSize,
                seed = "abc"
            )

            if (nextPageNumber < 2000)
                LoadResult.Page(
                    data = response.body()!!.results,
                    prevKey = null, // Only paging forward.
                    nextKey = nextPageNumber + 1
                ) else
                LoadResult.Page(
                    data = response.body()!!.results,
                    prevKey = null, // Only paging forward.
                    nextKey = null
                )

        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error for
            // expected errors (such as a network failure).
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Users>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}