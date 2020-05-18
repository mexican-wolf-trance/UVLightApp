package edu.charles_wyatt.UVLightChecker.UVDisplay

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.uv_light_recycler_list.view.*

class UVLightViewHolder constructor(uvView: View): RecyclerView.ViewHolder(uvView)
{
    val valueTextView: TextView = uvView.uv_text_view
    val dateTextView: TextView = uvView.date_value
}