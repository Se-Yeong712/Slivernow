package s2017s16.kr.hs.mirim.silvernow.gym

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import s2017s16.kr.hs.mirim.silvernow.R
import java.util.ArrayList

class GymArmAdapter(val context: Context, private val dataList: ArrayList<GymDataModel>, val itemClick: (GymDataModel) -> Unit)
    : RecyclerView.Adapter<GymArmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_gymitem, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(ViewHolder: ViewHolder, position: Int) {
        ViewHolder?.bind(dataList[position], context)
    }

    inner class ViewHolder(itemView: View?, itemClick: (GymDataModel) -> Unit) : RecyclerView.ViewHolder(itemView) {

        init {

        }

        // xml에 있는
        var dataTitle = itemView?.findViewById<TextView>(R.id.textview_gym_item)
        var dataImage = itemView?.findViewById<ImageView>(R.id.imageview_gym_item)

        fun bind(item: GymDataModel, context: Context) {
            dataTitle?.text = item.item_title
            dataImage?.setImageResource(item.item_image)

            itemView.setOnClickListener { itemClick(item) }
        }

    }



}