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
import kotlinx.android.synthetic.main.*;
import android.R.menu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast


class GymEyeActivity : AppCompatActivity() {

    private lateinit var gymAdapter: GymEyeAdapter

    //리사이클러뷰에 받아올 데이터
    var dataList_eye = arrayListOf<GymDataModel>(
            GymDataModel("눈 운동",R.drawable.eye),
            GymDataModel("안와 마사지",R.drawable.eye),
            GymDataModel("손바닥으로 감싸기", R.drawable.eye)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_eye)

        //터치시 해당 운동에 맞는 페이지로 이동
        gymAdapter = GymEyeAdapter(this, dataList_eye) {
            GymDataModel -> val nextIntent = Intent(this, EyeActivity::class.java)
            startActivity(nextIntent)
        }

        gym_eye_recycler_view.apply {
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
