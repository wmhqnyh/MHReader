package com.wangmh.mhreader.reader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangmh.mhreader.common.base.IBaseActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.epub.EpubReader;

public class ReaderActivity extends IBaseActivity {

    private static final String TAG = ReaderActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_layout);

        ImageView mBgImageView = findViewById(R.id.bg_image);
        TextView mTextView = findViewById(R.id.textview);

        String miyue = ReadTxtUtil.readAssetsTxt(this, "miyue");
        mTextView.setText(miyue);

        EpubReader reader = new EpubReader();
        try {
            InputStream is = getAssets().open("miyue.epub");
            Book book = reader.readEpub(is, "UTF-8");
            Metadata metadata = book.getMetadata();
            List<Author> authors = metadata.getAuthors();
            String firstTitle = metadata.getFirstTitle();

            Bitmap bitmap = BitmapFactory.decodeStream(book.getCoverImage().getInputStream());
            if (null!=bitmap)
            mBgImageView.setImageBitmap(bitmap);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
