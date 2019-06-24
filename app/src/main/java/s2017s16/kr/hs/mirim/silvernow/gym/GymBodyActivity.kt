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
import kotlinx.android.synthetic.main.activity_gym_body.*
import s2017s16.kr.hs.mirim.silvernow.R
import s2017s16.kr.hs.mirim.silvernow.manual.body.BodyActivity
import s2017s16.kr.hs.mirim.silvernow.manual.body.BodyPlankActivity
import s2017s16.kr.hs.mirim.silvernow.manual.body.BodySuperActivity



class GymBodyActivity : AppCompatActivity() {

    private lateinit var gymAdapter: GymBodyAdapter

    //리사이클러뷰에 받아올 데이터
    var dataList_body = arrayListOf<GymDataModel>(
            GymDataModel("허리 돌리기", R.drawable.body,  BodyActivity::class.java),
            GymDataModel("슈퍼맨 운동",R.drawable.bodysuper, BodySuperActivity::class.java),
            GymDataModel("플랭크", R.drawable.bodysuper, BodyPlankActivity::class.java)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_body)

        //터치시 해당 운동에 맞는 페이지로 이동
        gymAdapter = GymBodyAdapter(this, dataList_body) { GymDataModel ->
            val nextIntent = Intent(this, GymDataModel.item_link)
            startActivity(nextIntent)
        }

        gym_body_recycler_view.apply {
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
