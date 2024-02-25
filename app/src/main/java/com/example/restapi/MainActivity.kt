package com.example.restapi

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var url:String
    private lateinit var requestQueue: RequestQueue
    private lateinit var jsonObjectRequest: JsonObjectRequest
    private lateinit var jsonArray: JSONArray
    private lateinit var dataLit: ArrayList<data>
    private lateinit var recyclerView: RecyclerView
    private lateinit var vidAdapter:VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.review)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
        dataLit = ArrayList<data>()
        vidAdapter = VideoAdapter( this,dataLit)
        recyclerView.adapter = vidAdapter
        getJsonData()
    }

    private fun getJsonData() {
      url  = "https://raw.githubusercontent.com/bikashthapa01/myvideos-android-app/master/data.json"
       requestQueue = Volley.newRequestQueue(this)
        jsonObjectRequest = JsonObjectRequest(Request.Method.GET,
            url,
            null,
            Response.Listener<JSONObject>{
           val categories =  it.getJSONArray("categories")
            val categoriesData = categories.getJSONObject(0)
                val videos = categoriesData.getJSONArray("videos")
              val i =0;

              while (videos[i]!=null){
              val video =  videos.getJSONObject(i)
        dataLit.add(data(video.getString("title"),video.getString("sources")))
              }

             vidAdapter.notifyDataSetChanged()
            }
        )
        {



        }



    }


}



