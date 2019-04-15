package s2017s16.kr.hs.mirim.silvernow

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_gym_leg.*


class GymLegActivity : AppCompatActivity() {

    private lateinit var gymAdapter: GymAdapter

    //리사이클러에 받아올
    var dataList_leg = arrayListOf<GymDataModel>(
            GymDataModel("발끝 당기기",R.drawable.leg),
            GymDataModel("다리 폈다 굽히기",R.drawable.leg),
            GymDataModel("다리 마사지", R.drawable.leg),
            GymDataModel("빠르게 걷기",R.drawable.leg),
            GymDataModel("계단 오르내리기",R.drawable.leg),
            GymDataModel("다리 휘두르기", R.drawable.leg)

    )
    //첫번째 리사이클러뷰와 연결

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_leg)

        gymAdapter = GymAdapter(dataList_leg)

        gym_leg_recycler_view.apply {
            adapter = gymAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }


    }
}
