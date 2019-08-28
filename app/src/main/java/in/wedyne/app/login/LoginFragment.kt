package `in`.wedyne.app.login


import `in`.wedyne.app.BaseFragment
import `in`.wedyne.app.R
import `in`.wedyne.app.login.model.OnBoardingScreen
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : BaseFragment() {

    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter()
    }

    override fun createFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment

        viewPagerAdapter.setOnBoardingScreens(onBoardingScreens)

        return inflater.inflate(R.layout.fragment_login, parent, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.login.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_loginBottomSheet)
            showLoginBottomSheet()
        }

        view.view_pager?.apply {
            adapter = viewPagerAdapter
            orientation = ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
        }

        view.indicator.setViewPager(view.view_pager)
        viewPagerAdapter.registerAdapterDataObserver(view.indicator.adapterDataObserver)

    }

    private fun showLoginBottomSheet() {
        val loginBottomSheet = LoginBottomSheet()
        loginBottomSheet.show(childFragmentManager, LoginBottomSheet.TAG)
    }


    companion object {
        private val onBoardingScreens = listOf(
            OnBoardingScreen(R.drawable.breakfast_portrait, "Redefining the way we dine"),
            OnBoardingScreen(R.drawable.cornflakes_portrait, "Redefining the way we dine out"),
            OnBoardingScreen(R.drawable.fruit_salad_portrait, "Redefining the way we dine in")
        )
    }
}
