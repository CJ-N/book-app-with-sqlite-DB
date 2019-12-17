package com.drivenpurpose.cjcorp.bookappwithsqlitedb;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

//    TextView detailsTv;
//    Button ZoomIn, ZoomOut;
//    static int textSize = 25;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter}return 0; derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.return 0;
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

//        detailsTv = (TextView) findViewById(R.id.detailTV);
////        detailsTv.setTextSize(ratio+12);
//
//        ZoomOut = findViewById(R.id.maxZoom);
//        ZoomOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textSize = textSize + 5;
//                detailsTv.setTextSize(textSize);
//            }
//        });
//
//        ZoomIn = findViewById(R.id.minZoom);
//        ZoomIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textSize = textSize - 5;
//                 detailsTv.setTextSize(textSize);
//            }
//        });


    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_main, container, false);
            TextView mPageTv, mChapterTv, mTitleTv, mDetailTv;
            mPageTv = v.findViewById(R.id.pageTV);
            mChapterTv = v.findViewById(R.id.chapterTV);
            mTitleTv = v.findViewById(R.id.titleTV);
            mDetailTv = v.findViewById(R.id.detailTV);

            SqliteDBHelper dbHelper;
            ArrayList<Model> modelList;
            int page = 0;
            String chapter = "", title = "", detail = "";
            modelList = new ArrayList<>();
            modelList.clear();
            dbHelper = new SqliteDBHelper(getContext());
            dbHelper.openDatabase();
            modelList = dbHelper.getDetails();

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {

                // get first record
                Model count = modelList.get(0);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();//.replace("\n\n", "\n\n");

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {

                // get first record
                Model count = modelList.get(1);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }                // setting the information in the TextView

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {

                // get first record
                Model count = modelList.get(2);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {

                // get first record
                Model count = modelList.get(3);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {

                // get first record
                Model count = modelList.get(4);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 6) {

                // get first record
                Model count = modelList.get(5);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 7) {

                // get first record
                Model count = modelList.get(6);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 8) {

                // get first record
                Model count = modelList.get(7);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 9) {

                // get first record
                Model count = modelList.get(8);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 10) {

                // get tenth record
                Model count = modelList.get(9);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 11) {

                // get eleventh record
                Model count = modelList.get(10);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 12) {

                // get eleventh record
                Model count = modelList.get(11);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 13) {

                // get eleventh record
                Model count = modelList.get(12);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 14) {

                // get eleventh record
                Model count = modelList.get(13);
                // save record in strings
                page = page + count.getIds();
                chapter = chapter + count.getChapters();
                title = title + count.getTitles();
                detail = detail + count.getDetails();

                // setting the information in the TextView
                mPageTv.setText(page+"");
                mChapterTv.setText(chapter);
                mTitleTv.setText(title);
                mDetailTv.setText(detail);

                return v;

            }


//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return v;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 14 total pages.
            return 14;
        }
    }
}
