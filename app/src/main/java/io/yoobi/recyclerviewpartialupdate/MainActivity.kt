package io.yoobi.recyclerviewpartialupdate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

val list = listOf(
    TextBoolean("Text1", false),
    TextBoolean("Text2", true),
    TextBoolean("Text3", false),
    TextBoolean("Text4", true),
    TextBoolean("Text5", false),
    TextBoolean("Text6", false),
    TextBoolean("Text7", false),
    TextBoolean("Text8", false),
    TextBoolean("Text9", false),
    TextBoolean("Text10", false),
    TextBoolean("Text11", false),
    TextBoolean("Text12", false),
    TextBoolean("Text13", false),
    TextBoolean("Text14", false),
    TextBoolean("Text15", false),
    TextBoolean("Text16", false),
    TextBoolean("Text17", false),
    TextBoolean("Text18", false),
    TextBoolean("Text19", false),
    TextBoolean("Text20", false),
    TextBoolean("Text21", false),
    TextBoolean("Text22", false),
    TextBoolean("Text23", false),
    TextBoolean("Text24", false),
    TextBoolean("Text25", false),
    TextBoolean("Text26", false),
    TextBoolean("Text27", false),
    TextBoolean("Text28", false),
    TextBoolean("Text29", false),
    TextBoolean("Text30", false)
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val myAdapter = MyAdapter()
        myAdapter.submitList(list)
        recyclerView.adapter = myAdapter
    }
}
