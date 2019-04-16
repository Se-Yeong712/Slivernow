package s2017s16.kr.hs.mirim.silvernow

import android.content.Context
import android.media.Image
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class GymEyeAdapter(val context: Context, private val dataList: ArrayList<GymDataModel>, val itemClick: (GymDataModel) -> Unit)
    : RecyclerView.Adapter<GymEyeAdapter.ViewHolder>() {

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