package `in`.wedyne.app.login


import `in`.wedyne.app.BaseFragment
import `in`.wedyne.app.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : BaseFragment() {

    override fun createFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.sign_up.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_otpFragment)
        }
    }


}
