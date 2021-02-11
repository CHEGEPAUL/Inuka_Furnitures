package Adapters

import Classes.Sofa
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.inuka_furnitures.R
import javax.sql.CommonDataSource

class SofaAdapter(private val context: Context,
                  private val dataSource: ArrayList<Sofa>) :BaseAdapter() {


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
        val view:View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.sofa_list_item,parent,false)

            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById<ImageView>(R.id.sofa_list_thumbnail)
            holder.titleTextView = view.findViewById<TextView>(R.id.sofa_list_title)
            holder.descriptionTextView = view.findViewById<TextView>(R.id.sofa_list_description)
            holder.priceTextView = view.findViewById<TextView>(R.id.sofa_list_price)
            holder.contactTextView = view.findViewById<TextView>(R.id.sofa_list_contacts)

            view.tag = holder
        }else {
            view = convertView
            holder = convertView.tag as ViewHolder

        }
        val titleTextView = holder.titleTextView
        val descriptionTextView = holder.descriptionTextView
        val priceTextView = holder.priceTextView
        val contactTextView = holder.contactTextView


        val sofa =getItem(position) as Sofa

        titleTextView.text =sofa.name
        descriptionTextView.text = sofa.description
        priceTextView.text = sofa.price
        contactTextView.text = sofa.contacts

       // Picasso.with(context).load(sofa.imageUrl).placeholder(R.mipmap.ic_launcher)into(thumbnailImageView)
      val titleTypeface = ResourcesCompat.getFont(context,R.font.josefinsans_bold)
        titleTextView.typeface = titleTypeface

        val descriptionTypeFace= ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
        descriptionTextView.typeface = descriptionTypeFace

        val priceTypeFace= ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
        descriptionTextView.typeface = priceTypeFace

        val contactTypeFace= ResourcesCompat.getFont(context,R.font.josefinsans_semibolditalic)
        descriptionTextView.typeface = contactTypeFace


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