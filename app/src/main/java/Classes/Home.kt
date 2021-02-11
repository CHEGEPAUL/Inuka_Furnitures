package Classes

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Home (
    val name: String,
    val imageUrl: String,
    val description: String,
    val contacts: String,
    val price:String) {
        companion object{
            fun getHomeFromFile(filename:String,context: Context):ArrayList<Home>{
                val homeList = ArrayList<Home>()
                try {
                    val jsonString = loadJsonFromAsset("home.json",context)
                    val json = JSONObject(jsonString)
                    val home = json.getJSONArray("home")

                    (0 until home.length()).mapTo(homeList) {
                        Home(home.getJSONObject(it).getString("name"),
                                home.getJSONObject(it).getString("image"),
                                home.getJSONObject(it).getString("description"),
                                home.getJSONObject(it).getString("contacts"),
                                home.getJSONObject(it).getString("price"))
                    }
                }catch (e: JSONException){
                    e.printStackTrace()
                }
                return homeList

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