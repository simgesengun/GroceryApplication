package com.simgesengun.groceryapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.R
import com.simgesengun.groceryapplication.databinding.FragmentSearchPageBinding

class SearchPageFragment : Fragment() {
    private lateinit var design : FragmentSearchPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_search_page, container, false)
        // Toolbar
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarSearch)

        return design.root
    }    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(design.toolbarSearch, "${item.title} clicked", Snackbar.LENGTH_SHORT).show()
        return true
    }
}