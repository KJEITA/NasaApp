package bonch.dev.nasaapp.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.nasaapp.MainContract
import bonch.dev.nasaapp.fragments.MainFragment
import bonch.dev.nasaapp.R
import bonch.dev.nasaapp.adapters.DayAdapter
import bonch.dev.nasaapp.api.model.PhotoDTO
import bonch.dev.nasaapp.fragments.InDayFragment
import bonch.dev.nasaapp.fragments.InfoFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var app: Presenter

class MainActivity : MainContract.View, AppCompatActivity() {

    val fragmentManager = supportFragmentManager

    val mainFragment = MainFragment()
    val inDayFragment = InDayFragment()
    val infoFragment = InfoFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = application as Presenter

        app.setVieww(this)

        showMain()
    }

    override fun showMain() {
        fragmentManager.beginTransaction().add(
            R.id.fragment,
            mainFragment
        )
            .commit()

        CoroutineScope(Dispatchers.Main).launch {
            mainFragment.setDate(app.getDate())
        }
    }

    override fun showInDay(photoDTO: PhotoDTO) {
        inDayFragment.setData(photoDTO)

        fragmentManager.beginTransaction().add(R.id.fragment, inDayFragment)
            .addToBackStack("inDayFragment")
            .hide(mainFragment)
            .commit()
    }

    override fun showInfo(photoDTO: PhotoDTO) {
        infoFragment.setData(photoDTO)

        fragmentManager.beginTransaction().add(R.id.fragment, infoFragment)
            .addToBackStack("infoFragment")
            .hide(inDayFragment)
            .commit()
    }
}
