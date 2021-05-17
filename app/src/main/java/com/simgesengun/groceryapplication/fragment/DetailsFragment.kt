package com.simgesengun.groceryapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.fragment.DetailsFragmentArgs
import com.simgesengun.groceryapplication.R
import com.simgesengun.groceryapplication.databinding.FragmentDetailsBinding
import com.simgesengun.groceryapplication.entity.Item
import com.simgesengun.groceryapplication.entity.ItemAdapter

class DetailsFragment : Fragment() {

    private lateinit var design : FragmentDetailsBinding
    private lateinit var itemList : List<Item>
    private lateinit var adapter : ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        // Toolbar
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarDetails)

        // Bundle
        val bundle : DetailsFragmentArgs by navArgs()
        val category = bundle.category

        design.title = category.title
        itemList = category.items

        // Recycler View
        adapter = ItemAdapter(requireContext(), itemList)
        design.itemAdapter = adapter


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
        Snackbar.make(design.toolbarDetails, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }
}