package com.tassiecomp.mvvmtistory.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tassiecomp.mvvmtistory.MainActivity
import com.tassiecomp.mvvmtistory.R
import com.tassiecomp.mvvmtistory.ui.NewsViewmodel

class ArticleFragment: Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewmodel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}