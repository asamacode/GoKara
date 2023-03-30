package com.example.firstapplication

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterSentence(private val dataSet: List<SentenceData>) :
    RecyclerView.Adapter<AdapterSentence.ViewHolder>() {

    private val handler = Handler(Looper.getMainLooper())

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.txtSentence)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_sentence, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].sentence

        if (dataSet[position].animating) {
            starShowKara(viewHolder.textView, dataSet[position].sentence)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun starShowKara(view: TextView, sentence: String) {
        for ((index, element) in sentence.split(" ").withIndex()) {
            handler.postDelayed({
                highLightTextView(view, element, sentence)
            }, (1000 + (index * 1000)).toLong())
        }
    }

    fun highLightTextView(view: TextView, word: String, sentence: String) {
        val pos = sentence.indexOf(word)
        var startValue = pos
        var endValue = pos + word.length

        val valueAnimator = ValueAnimator.ofInt(startValue, endValue).apply {
            duration = 1000
        }

        valueAnimator.addUpdateListener { animator ->
            val spannableString: Spannable = SpannableString(
                view.text
            )

            spannableString.setSpan(
                ForegroundColorSpan(
                    Color.YELLOW
                ), startValue, animator.animatedValue.toString().toInt(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            view.text = spannableString
        }

        valueAnimator.start()
    }

}
