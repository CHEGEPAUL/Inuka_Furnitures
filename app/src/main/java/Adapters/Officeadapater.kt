package Adapters

import Classes.Home
import Classes.Office
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.inuka_furnitures.R

class Officeadapater (private val context: Context,
private val dataSource: ArrayList<Office>) : BaseAdapter() {


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
            view = inflater.inflate(R.layout.office_list_item,parent,false)

            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById<ImageView>(R.id.office_list_thumbnail)
            holder.titleTextView = view.findViewById<TextView>(R.id.office_list_title)
            holder.descriptionTextView = view.findViewById<TextView>(R.id.office_list_description)
            holder.priceTextView = view.findViewById<TextView>(R.id.office_list_price)
            holder.contactTextView = view.findViewById<TextView>(R.id.office_list_contacts)

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


        val office =getItem(position) as Office

        titleTextView.text =office.name
        descriptionTextView.text = office.description
        priceTextView.text = office.price
        contactTextView.text = office.contacts

       // Picasso.with(context).load(office.imageUrl).placeholder(R.mipmap.ic_launcher)into(thumbnailImageView)

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