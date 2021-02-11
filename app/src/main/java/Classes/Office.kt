package Classes

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Office (
    val name: String,
    val imageUrl: String,
    val description: String,
    val contacts: String,
    val price:String) {
        companion object{
            fun getOfficeFromFile(filename:String,context: Context):ArrayList<Office>{
                val officeList = ArrayList<Office>()
                try {
                    val jsonString = loadJsonFromAsset("office.json",context)
                    val json = JSONObject(jsonString)
                    val office = json.getJSONArray("office")

                    (0 until office.length()).mapTo(officeList) {
                        Office(office.getJSONObject(it).getString("name"),
                                office.getJSONObject(it).getString("image"),
                                office.getJSONObject(it).getString("description"),
                                office.getJSONObject(it).getString("contacts"),
                                office.getJSONObject(it).getString("price"))
                    }
                }catch (e: JSONException){
                    e.printStackTrace()
                }
                return officeList

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