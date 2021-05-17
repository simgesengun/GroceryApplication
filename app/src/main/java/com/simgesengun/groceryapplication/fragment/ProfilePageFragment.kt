package com.simgesengun.groceryapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.R
import com.simgesengun.groceryapplication.databinding.FragmentProfilePageBinding
import com.simgesengun.groceryapplication.entity.Achivement
import com.simgesengun.groceryapplication.entity.AchivementAdapter
import java.util.ArrayList

class ProfilePageFragment : Fragment() {

    private lateinit var achievementList : ArrayList<Achivement>
    private lateinit var adapter : AchivementAdapter
    private lateinit var design : FragmentProfilePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_page, container, false)

        // Toolbar
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarProfile)

        createAchievementList()

        adapter = AchivementAdapter(requireContext(),achievementList)
        design.achievementAdapter = adapter
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(design.toolbarProfile, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }

    private fun createAchievementList(){
        achievementList = ArrayList()

        val a1 = Achivement(1,"Coupon (Bronze)","Used 20 coupons","ic_ach_coupon")
        val a2 = Achivement(2,"Gift (Silver)","Gave gift 20 times","ic_ach_gift")
        val a3 = Achivement(3,"Best (Silver)","Ordered at least once a week","ic_ach_best")
        val a4 = Achivement(4,"Login (Gold)","Logged in 100 times","ic_ach_login")
        val a5 = Achivement(5,"Order (Gold)","Ordered 50 times","ic_ach_order")

        achievementList.add(a1)
        achievementList.add(a2)
        achievementList.add(a3)
        achievementList.add(a4)
        achievementList.add(a5)

    }
}