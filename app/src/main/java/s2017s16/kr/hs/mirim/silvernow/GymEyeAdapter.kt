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
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_gymitem.view.*

import java.util.ArrayList

class GymAdapter(private val dataList: ArrayList<GymDataModel>)
    : RecyclerView.Adapter<GymAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.recycler_gymitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(ViewHolder: ViewHolder, i: Int) {
        var itemTitle = dataList[i].item_title
        var itemImage = dataList[i].item_image

        ViewHolder.itemView.textview_gym_item.setText(itemTitle)
        ViewHolder.itemView.imageview_gym_item.setImageResource(itemImage);
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }

        fun bind(item: GymDataModel) {

        }
    }

}