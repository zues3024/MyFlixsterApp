package com.codepath.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.myapplication.R.id

class NowPlayingMovieRecyclerViewAdapter(

    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<NowPlayingMovieRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_now_playing_movies, parent, false)
            return MovieViewHolder(view)
        }

        /**
         * This inner class lets us refer to all the different View elements
         * (Yes, the same ones as in the XML layout files!)
         */
        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: Movie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
            val mMoviePoster: ImageView = mView.findViewById<View>(id.movie_poster) as ImageView
            val mMovieOverview: TextView = mView.findViewById<View>(id.movie_overview) as TextView


            override fun toString(): String {
                return mMovieTitle.toString() + " '" + mMovieOverview.text + "'"
            }
        }

        /**
         * This lets us "bind" each Views in the ViewHolder to its' actual data!
         */
        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieOverview.text = movie.overview
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/" + movie.posterUrl)
                .centerInside()
                .into(holder.mMoviePoster)

//            holder.mBuyButton.setOnClickListener {
//                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.amazonUrl.toString()))
//                ContextCompat.startActivity(it.context, browserIntent, null)
//            }


        }

        /**
         * Remember: RecyclerView adapters require a getItemCount() method.
         */
        override fun getItemCount(): Int {
            return movies.size
        }
}