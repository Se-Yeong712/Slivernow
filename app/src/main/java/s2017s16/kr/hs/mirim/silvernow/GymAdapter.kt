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

class GymAdapter(private val dataList: ArrayList<GymDataModel>, private val listener : ItemDragListener)
    : RecyclerView.Adapter<GymAdapter.ViewHolder>(), ItemActionListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.recycler_gymitem, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(ViewHolder: ViewHolder, i: Int) {
        var itemTitle = dataList[i].item_title
        var itemImage = dataList[i].item_image

        ViewHolder.itemView.textview_gymitem.setText(itemTitle)
        ViewHolder.itemView.imageview_gymitem.setImageResource(itemImage);
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onItemMoved(from: Int, to: Int) {
        if (from == to) {
            return
        }

        val fromItem = dataList.removeAt(from)
        dataList.add(to, fromItem)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    class ViewHolder(itemView: View, listener: ItemDragListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.ic_formove.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    listener.onStartDrag(this)
                }
                false
            }
        }

        fun bind(item: GymDataModel) {

        }
    }

}