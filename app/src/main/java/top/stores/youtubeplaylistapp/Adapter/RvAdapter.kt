package top.stores.youtubeplaylistapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import top.stores.youtubeplaylistapp.R
import top.stores.youtubeplaylistapp.models.Model

class RvAdapter(val userList: ArrayList<Model>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.adapter_item_layout, p0, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(p0: ViewHolder,position: Int) {

        p0.webView.loadUrl(urlList[position])
        p0.count?.text = userList[position].count.toString()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val webView = itemView.findViewById<WebView>(R.id.webview)
        val count = itemView.findViewById<TextView>(R.id.tvCount)

    }

    private val urlList = arrayOf(
        "https://www.youtube.com/watch?v=uEJuoEs1UxY&list=RDuEJuoEs1UxY&start_radio=1",
        "https://www.youtube.com/watch?v=JGwWNGJdvx8",
        "https://www.youtube.com/watch?v=2Vv-BfVoq4g",
        "https://www.youtube.com/watch?v=RgKAFK5djSk"
    )
}