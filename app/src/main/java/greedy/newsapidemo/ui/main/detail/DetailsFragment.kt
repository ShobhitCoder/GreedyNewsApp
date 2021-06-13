package greedy.newsapidemo.ui.main.detail

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import greedy.newsapidemo.R
import greedy.newsapidemo.databinding.FragmentDetailsBinding
import greedy.newsapidemo.ui.main.news.NewsViewModel
import greedy.newsapidemo.util.hide
import greedy.newsapidemo.util.show
import greedy.newsapidemo.util.snackbar

/**
 * Display passed article in WebView.
 *
 * FAB button in this fragment will be used to bookmark an article that will be saved locally.
 */
@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val viewModel: NewsViewModel by viewModels()
    private val navigationArgs: DetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        displayArticle()
        binding.fabSaveArticle.apply {
            val message: String =
                if (navigationArgs.article.isSaved) {
                    setImageResource(R.drawable.ic_bookmark_selected)
                    getString(R.string.article_already_saved)
                } else {
                    getString(R.string.article_saved)
                }

            setOnClickListener {
                viewModel.saveArticleClicked(navigationArgs.article)
                it.snackbar(message)
                setImageResource(R.drawable.ic_bookmark_selected)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun displayArticle() {
        binding.webView.apply {
            webViewClient = webViewCustomClient
            loadUrl(navigationArgs.article.url)
            settings.javaScriptEnabled = true
        }
    }

    private val webViewCustomClient = object : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            binding.progressBar.show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.hide()
        }
    }
}