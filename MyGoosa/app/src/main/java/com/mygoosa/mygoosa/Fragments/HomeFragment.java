package com.mygoosa.mygoosa.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.mygoosa.mygoosa.Adapters.AlbumsAdapter;
import com.mygoosa.mygoosa.MainActivity;
import com.mygoosa.mygoosa.Models.Album;
import com.mygoosa.mygoosa.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout mDemoSlider;
    private RecyclerView recyclerView;
    private NestedScrollView nestedScrollView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home_fragment =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) home_fragment.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        mDemoSlider = (SliderLayout) home_fragment.findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();

        file_maps.put("MyGoosa 1",R.mipmap.saree_banner);
        file_maps.put("MyGoosa 2",R.mipmap.mens_banner);
        file_maps.put("MyGoosa 3",R.mipmap.saree_banner);
        file_maps.put("MyGoosa 4", R.mipmap.mens_banner);
        Log.d("Banner:",file_maps.toString());
        for(String name : file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(getActivity(), albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();
/*        try {
            Glide.with(this).load(R.drawable.ic_launcher_background).into((ImageView) getActivity().findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        nestedScrollView=(NestedScrollView) home_fragment.findViewById(R.id.nestedScroll);
        nestedScrollView.scrollTo(0,nestedScrollView.getBottom());
        return home_fragment;
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.mipmap.tshirt,
                R.mipmap.tshirt1,
                R.mipmap.tshirt,
                R.mipmap.tshirt1,
                R.mipmap.tshirt,
                R.mipmap.tshirt1,
                R.mipmap.tshirt,
                R.mipmap.tshirt1,
                R.mipmap.tshirt,
                R.mipmap.tshirt1,
                R.mipmap.tshirt,
        };

        Album a = new Album("Test 1",covers[0],"150","300","50% Offers","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 2",covers[1],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 3",covers[2],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 4",covers[3],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 5",covers[4],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 6",covers[5],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 7",covers[6],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 8",covers[7],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 9",covers[8],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        a = new Album("Test 10",covers[9],"150","300","50% Off","Solid polo Collar T-shirt");
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
