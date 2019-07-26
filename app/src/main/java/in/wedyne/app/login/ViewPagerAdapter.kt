package `in`.wedyne.app.login

import `in`.wedyne.app.R
import `in`.wedyne.app.login.model.OnBoardingScreen
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_onboarding.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    private lateinit var screens: List<OnBoardingScreen>
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        mContext = parent.context

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_onboarding, parent, false)

        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int = screens.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        bind(holder, position)
    }

    fun setOnBoardingScreens(screens: List<OnBoardingScreen>) {
        this.screens = screens
    }

    private fun bind(holder: ViewPagerViewHolder, position: Int) {

        holder.text.text = screens[position].text

        Glide.with(mContext)
            .load(screens[position].screen)
            .into(holder.screen)
    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val screen = itemView.onboarding_image
        val text = itemView.onboarding_text
    }
}