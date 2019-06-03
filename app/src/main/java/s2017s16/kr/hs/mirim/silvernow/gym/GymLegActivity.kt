package s2017s16.kr.hs.mirim.silvernow.gym

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_gym_leg.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import s2017s16.kr.hs.mirim.silvernow.R
import s2017s16.kr.hs.mirim.silvernow.manual.eye.EyeActivity
import s2017s16.kr.hs.mirim.silvernow.manual.eye.EyeMasActivity
import s2017s16.kr.hs.mirim.silvernow.manual.eye.EyeMovActivity
import s2017s16.kr.hs.mirim.silvernow.manual.leg.LegActivity
import s2017s16.kr.hs.mirim.silvernow.manual.leg.LegPullActivity
import s2017s16.kr.hs.mirim.silvernow.manual.leg.LegSquartActivity


class GymLegActivity : AppCompatActivity() {

    private lateinit var gymAdapter: GymLegAdapter

    //리사이클러뷰에 받아올 데이터
    var dataList_leg = arrayListOf<GymDataModel>(
            GymDataModel("다리 스트레칭", R.drawable.leggif,  LegActivity::class.java),
            GymDataModel("발끝 당기기",R.drawable.legpull, LegPullActivity::class.java),
            GymDataModel("스쿼트", R.drawable.legsquart, LegSquartActivity::class.java)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_leg)

        //터치시 해당 운동에 맞는 페이지로 이동
        gymAdapter = GymLegAdapter(this, dataList_leg) { GymDataModel ->
            val nextIntent = Intent(this, GymDataModel.item_link)
            startActivity(nextIntent)
        }

        gym_leg_recycler_view.apply {
            adapter = gymAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

    }

    //메뉴
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }

            R.id.action_settings -> {

                Toast.makeText(applicationContext, "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return false
    }//onOptionsItemSelected

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //return super.onCreateOptionsMenu(menu);
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


}
