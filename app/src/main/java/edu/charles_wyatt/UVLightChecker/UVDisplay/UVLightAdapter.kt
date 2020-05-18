package edu.charles_wyatt.UVLightChecker.UVDisplay

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.UVLightChecker.R
import edu.charles_wyatt.UVLightChecker.data.objects.UVLight

class UVLightAdapter (private val context: Context, private val dataSource: ArrayList<UVLight>) : RecyclerView.Adapter<UVLightViewHolder>()
{
    private var uv: List<UVLight> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UVLightViewHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.uv_light_recycler_list, parent, false)

        return UVLightViewHolder(view)
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: UVLightViewHolder, position: Int)
    {
        val list = dataSource[position]
        holder.valueTextView.text = list.value
        holder.dateTextView.text = list.date
    }

}