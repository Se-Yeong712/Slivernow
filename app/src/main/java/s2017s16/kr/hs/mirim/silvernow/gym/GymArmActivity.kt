package s2017s16.kr.hs.mirim.silvernow.gym

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_gym_leg.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gym_arm.*
import s2017s16.kr.hs.mirim.silvernow.R
import s2017s16.kr.hs.mirim.silvernow.manual.arm.ArmActivity
import s2017s16.kr.hs.mirim.silvernow.manual.arm.ArmMusActivity
import s2017s16.kr.hs.mirim.silvernow.manual.arm.ArmShouActivity


class GymArmActivity : AppCompatActivity() {

    private lateinit var gymAdapter: GymArmAdapter

    //리사이클러뷰에 받아올 데이터
    var dataList_arm = arrayListOf<GymDataModel>(
            GymDataModel("손깍지 스트레칭", R.drawable.armgif,  ArmActivity::class.java),
            GymDataModel("전완근 스트레칭",R.drawable.armmus, ArmMusActivity::class.java),
            GymDataModel("어깨 돌리기 운동", R.drawable.armshou, ArmShouActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_arm)


        //터치시 해당 운동에 맞는 페이지로 이동
        gymAdapter = GymArmAdapter(this, dataList_arm) { GymDataModel ->
            val nextIntent = Intent(this, GymDataModel.item_link)
            startActivity(nextIntent)
        }

        gym_arm_recycler_view.apply {
            adapter = gymAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

    }


}
