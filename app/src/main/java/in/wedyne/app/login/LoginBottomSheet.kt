package `in`.wedyne.app.login

import `in`.wedyne.app.R
import `in`.wedyne.app.utils.KeyBoardUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_login_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_login_bottom_sheet.view.*


class LoginBottomSheet : BottomSheetDialogFragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_login_bottom_sheet, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        KeyBoardUtils.showKeyBoard(context!!)

        navController = findNavController()

        view.verify.setOnClickListener {
            navController.navigate(R.id.action_loginBottomSheet_to_signUpFragment)
        }

    }

    override fun onPause() {
        super.onPause()
        KeyBoardUtils.hideKeyBoard(context!!, phone_number)
    }

    companion object {
        const val TAG = "LoginBottomSheet"
    }
}