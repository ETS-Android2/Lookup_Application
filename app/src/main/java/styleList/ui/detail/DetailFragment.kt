package styleList.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.R
import styleList.data.StylelistDao
import styleList.data.StylelistDatabase
import styleList.ui.shared.SharedViewModel
import com.hedgehog.ratingbar.RatingBar.OnRatingChangeListener
import java.databinding.FragmentDetailBinding
import androidx.databinding.ViewDataBinding

/**
* A simple [Fragment] subclass.
*/
class DetailFragment : Fragment()  {

    private lateinit var viewModel: SharedViewModel
    private lateinit var navController: NavController



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(
                requireActivity(), R.id.nav_host
        )

        viewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        val binding = FragmentDetailBinding.inflate(
                inflater, container, false
        )

        //viewModel?.let{binding.viewModel = it}
        binding.setLifecycleOwner(this)
        //binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val grading=view?.findViewById<com.hedgehog.ratingbar.RatingBar>(R.id.ratingBar)
        /* grading?.setOnRatingBarChangeListener{
                 ratingBar, rating, fromUser ->
             grading.onRatingBarChangeListener
             Toast.makeText(context, "$rating", Toast.LENGTH_SHORT).show()
             //monster.like=rating.toDouble()
             viewModel.selectedMonster.value?.scariness=rating.toInt()
         }*/
        grading?.setStar(viewModel.selectedStylelist.value?.scariness?.toFloat()!!)

        //grading?.setStarFillDrawable(resources.getDrawable(R.drawable.heart_full))
        //grading?.setStarEmptyDrawable(resources.getDrawable(R.drawable.heart_empty))

        grading?.setOnRatingChangeListener(
                OnRatingChangeListener{ RatingCount ->

                    Toast.makeText(
                            context,
                            "the fill star is$RatingCount",
                            Toast.LENGTH_SHORT
                    ).show()
                    //viewModel.setGrade(selectedMonster = viewModel.selectedMonster.value!!,ratingBar = grading)
                    viewModel?.selectedStylelist?.value?.scariness=RatingCount.toInt()

                }
        )

        //grading?.setStarFillDrawable(resources.getDrawable(R.drawable.heart_full))
        //grading?.setStarEmptyDrawable(resources.getDrawable(R.drawable.heart_empty))
        //grading?.rating= viewModel.selectedMonster.value?.scariness?.toFloat()!!
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }


}
