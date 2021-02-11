package Classes

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.nio.Buffer

class Sofa(
        val name: String,
        val imageUrl: String,
        val description: String,
        val contacts: String,
        val price:String) {
    companion object{
        fun getSofaFromFile(filename:String,context: Context):ArrayList<Sofa>{
            val sofaList = ArrayList<Sofa>()
            try {
                val jsonString = loadJsonFromAsset("sofa.json",context)
                val json = JSONObject(jsonString)
                val sofa = json.getJSONArray("sofa")

                (0 until sofa.length()).mapTo(sofaList) {
                    Sofa(sofa.getJSONObject(it).getString("name"),
                    sofa.getJSONObject(it).getString("image"),
                    sofa.getJSONObject(it).getString("description"),
                    sofa.getJSONObject(it).getString("contacts"),
                    sofa.getJSONObject(it).getString("price"))
                }
            }catch (e:  JSONException){
                e.printStackTrace()
            }
            return sofaList

        }
        private fun loadJsonFromAsset(filename: String,context: Context): String?{
            var json: String? = null

                try {
                    val inputStream = context.assets.open(filename)
                    val size = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    inputStream.close()
                    json = String(buffer,Charsets.UTF_8)

                }catch (ex: java.io.IOException) {
                    ex.printStackTrace()
                    return null
                }

                return json

        }
    }
}

