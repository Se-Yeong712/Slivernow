package s2017s16.kr.hs.mirim.silvernow

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_gym_eye.*


class GymEyeActivity : AppCompatActivity(), ItemDragListener {

    override fun onStartDrag(holder: GymAdapter.ViewHolder) {
        itemTouchHelper.startDrag(holder)
    }

    private lateinit var gymAdapter: GymAdapter
    private lateinit var itemTouchHelper : ItemTouchHelper

    //리사이클러에 받아올
    var dataList_eye = arrayListOf<GymDataModel>(
            GymDataModel("눈 운동",R.drawable.eye),
            GymDataModel("안와 마사지",R.drawable.eye),
            GymDataModel("손바닥으로 감싸기", R.drawable.eye)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_eye)

        gymAdapter = GymAdapter(dataList_eye, this)

        gym_eye_recycler_view.apply {
            adapter = gymAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(gymAdapter))
        itemTouchHelper.attachToRecyclerView(gym_eye_recycler_view)


    }
}
