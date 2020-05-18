package edu.charles_wyatt.UVLightChecker.UVDisplay

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.UVLightChecker.LightViewModel
import edu.charles_wyatt.UVLightChecker.R
import edu.charles_wyatt.UVLightChecker.data.objects.UVLight
import kotlinx.android.synthetic.main.fragment_u_v_light_display.view.*

class UVLightDisplayFragment(private val app: Application) : Fragment()
{

    lateinit var model: LightViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: UVLightAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(LightViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_u_v_light_display, container, false)
        recyclerView = view.uv_recycler
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val uvList = UVLight.getRecipesFromFile(app)
        viewAdapter = UVLightAdapter(requireContext(), uvList)

        recyclerView.adapter = viewAdapter

        return view
    }

}
