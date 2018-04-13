package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    /**
     * Resource ID for the background color for this list of words
     */
    private int colorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context         The current context. Used to inflate the layout file.
     * @param words           A List of Words objects to display in a list
     * @param colorResourceId
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

        this.colorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Set the theme color for the list item
        View parentLayout = listItemView.findViewById(R.id.parent_layout);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        // Set the background color of the text container View
        parentLayout.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwok TextView
        if (currentWord != null) {
            miwokTextView.setText(currentWord.getMiwokTranslation());
        }

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView numberTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and
        // set this text on the default TextView
        if (currentWord != null) {
            numberTextView.setText(currentWord.getDefaultTranslation());
        }

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.imageView);
        // Check if an image is provided for this word or not
        if (currentWord != null) {
            if (currentWord.hasImage()) {
                // If an image is available, display the provided image based on the resource ID
                iconView.setImageResource(currentWord.getImageResourceId());
                // Make sure the view is visible
                iconView.setVisibility(View.VISIBLE);
            } else {
                // Otherwise hide the ImageView (set visibility to GONE)
                iconView.setVisibility(View.GONE);
            }
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
