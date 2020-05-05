package top.stores.youtubeplaylistapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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

//            val PERMISSION_ALL = 1
//            val PERMISSIONS : String = Manifest.permission.INTERNET
//                    = arrayOf<String>(
//                Manifest.permission.INTERNET
//                Manifest.permission.WRITE_CONTACTS,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.READ_SMS,
//                Manifest.permission.CAMERA
//            )
//
//            if (!hasPermissions(this, PERMISSIONS)) {
//                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)
//            }
            hasPermissions(this, Manifest.permission.INTERNET)

            if (isNetwork(getApplicationContext())){

                Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(getApplicationContext(), "Internet Is Not Connected", Toast.LENGTH_SHORT).show()
            }
        }



    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }


    fun isNetwork(context: Context): Boolean {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return if (netInfo != null && netInfo.isConnectedOrConnecting) {
            true
        } else false
    }
}





