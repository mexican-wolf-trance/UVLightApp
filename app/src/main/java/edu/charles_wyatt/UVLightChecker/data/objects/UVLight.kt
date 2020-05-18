package edu.charles_wyatt.UVLightChecker.data.objects

import android.app.Application
import edu.charles_wyatt.UVLightChecker.R
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class UVLight(var date: String, var value: String, var lat: String, var lon: String, var dateIso: String)
{
    companion object
    {
        fun getRecipesFromFile(context: Application): ArrayList<UVLight>
        {
            val uvList = ArrayList<UVLight>()

            try
            {
                // Load data
                val jsonString = loadJsonFromAsset("forecast.json", context)
                val json = JSONObject(jsonString)
                val uvlight = json.getJSONArray("uvlight")

                // Get Recipe objects from data
                (0 until uvlight.length()).mapTo(uvList)
                {
                    UVLight(uvlight.getJSONObject(it).getString("date"),
                        uvlight.getJSONObject(it).getString("value"),
                        uvlight.getJSONObject(it).getString("lat"),
                        uvlight.getJSONObject(it).getString("lon"),
                        uvlight.getJSONObject(it).getString("date_iso")
                    )
                }
            }
            catch (e: JSONException)
            { e.printStackTrace() }

            return uvList
        }

        private fun loadJsonFromAsset(filename: String, applicationContext: Application): String?
        {
            var json: String? = null

            try
            {
                val inputStream = applicationContext.resources.openRawResource(R.raw.forecast)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            }
            catch (ex: java.io.IOException)
            {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}