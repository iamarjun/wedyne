package `in`.wedyne.app.login


import `in`.wedyne.app.R
import `in`.wedyne.app.login.model.OnBoardingScreen
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private val adapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter()
    }

    private val onBoardingScreens = listOf(
        OnBoardingScreen(R.drawable.breakfast_portrait, "Redefining the way we dine"),
        OnBoardingScreen(R.drawable.cornflakes_portrait, "Redefining the way we dine out"),
        OnBoardingScreen(R.drawable.fruit_salad_portrait, "Redefining the way we dine in")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        view_pager?.apply {
            offscreenPageLimit = 3
        }
        adapter.setOnBoardingScreens(onBoardingScreens)

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.view_pager.adapter = adapter
        view.view_pager.orientation = ORIENTATION_HORIZONTAL

    }


}
