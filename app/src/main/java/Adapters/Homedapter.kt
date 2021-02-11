package Adapters

import Classes.Home
import Classes.Sofa
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.inuka_furnitures.R

class Homedapter (
    private val context: Context,
    private val dataSource: ArrayList<Home>) : BaseAdapter() {


        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val holder: ViewHolder

            if (convertView == null) {
                view = inflater.inflate(R.layout.home_list_item,parent,false)

                holder = ViewHolder()
                holder.thumbnailImageView = view.findViewById<ImageView>(R.id.home_list_thumbnail)
                holder.titleTextView = view.findViewById<TextView>(R.id.home_list_title)
                holder.descriptionTextView = view.findViewById<TextView>(R.id.home_list_description)
                holder.priceTextView = view.findViewById<TextView>(R.id.home_list_price)
                holder.contactTextView = view.findViewById<TextView>(R.id.home_list_contacts)

                view.tag = holder
            }else {
                view = convertView
                holder = convertView.tag as ViewHolder

            }
            val titleTextView = holder.titleTextView
            val descriptionTextView = holder.descriptionTextView
            val priceTextView = holder.priceTextView
            val contactTextView = holder.contactTextView
            val thumbnailImageView= holder.thumbnailImageView


            val home =getItem(position) as Home

            titleTextView.text =home.name
            descriptionTextView.text = home.description
            priceTextView.text = home.price
            contactTextView.text = home.contacts

             //Picasso.with(context).load(home.imageUrl).placeholder(R.mipmap.ic_launcher)into(thumbnailImageView)

            return view
        }
        private class ViewHolder{
            lateinit var titleTextView: TextView
            lateinit var descriptionTextView: TextView
            lateinit var priceTextView: TextView
            lateinit var contactTextView: TextView
            lateinit var thumbnailImageView: ImageView
        }
}