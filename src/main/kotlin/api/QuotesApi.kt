package api

import model.QuoteList
import retrofit2.Call
import retrofit2.http.GET

interface QuotesApi {

    @GET("/quotes")
    fun gethomepage(): Call<QuoteList?>?

}