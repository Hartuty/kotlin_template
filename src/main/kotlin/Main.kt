import api.QuotesApi
import api.RetrofitHelper
import model.QuoteList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

fun main() {
    //get instance of retrofit from helper
    val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

    val call: Call<QuoteList?>? =quotesApi.gethomepage()

    var results: QuoteList

    //make api call
    call!!.enqueue(object : Callback<QuoteList?> {
        override fun onResponse(call: Call<QuoteList?>, response: Response<QuoteList?>) {

            results= response.body()!!

            var x=0
            while (x<results.results.size){
                println(results.results.get(x).author)
                x++
            }
            exitProcess(0)
        }

        override fun onFailure(call: Call<QuoteList?>, t: Throwable) {
           println("error")
            exitProcess(0)
        }
    })

}

