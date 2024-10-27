package kg.less.youtubeapi_hm07.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import kg.less.youtubeapi_hm07.utils.Resource
import java.util.zip.Inflater

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding?: throw IllegalStateException ("ViewBinding is not initialized")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
        initClickListeners()
    }

    protected open fun setupObservers() {}

    protected open fun setupViews() {}

    protected open fun initClickListeners() {}

    protected fun <T> LiveData<Resource<T>>.stateHandler(
        succes: (data: T) -> Unit,
        state: (Resource<T>) -> Unit
    ) {
        this@stateHandler.observe(viewLifecycleOwner) { result ->
            state(result)
            when (result) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {

                }

                is Resource.Succes -> {
                    succes(result.data)
                }
            }
        }
    }

}