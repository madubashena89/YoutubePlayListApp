package top.stores.youtubeplaylistapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import top.stores.youtubeplaylistapp.Adapter.RvAdapter
import top.stores.youtubeplaylistapp.models.Model

class MainActivity : AppCompatActivity() {

        @SuppressLint("WrongConstant")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

            val dataList = ArrayList<Model>()
            dataList.add(Model("Phone", 1))
            dataList.add(Model("Watch", 2))
            dataList.add(Model("Note", 3))
            dataList.add(Model("Pin", 4))

            val rvAdapter = RvAdapter(dataList)

            recyclerView.adapter = rvAdapter
        }

}


