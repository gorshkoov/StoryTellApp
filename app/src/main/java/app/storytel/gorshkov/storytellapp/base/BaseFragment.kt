package app.storytel.gorshkov.storytellapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater, root: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, root, false)
    }
}