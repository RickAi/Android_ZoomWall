package top.navyblue.zoomwall.views.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.utils.Constants;
import top.navyblue.zoomwall.views.adapters.PictureRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureContentFragment extends Fragment {


    @Bind(R.id.rv_pictures)
    RecyclerView mRvPictures;
    private PictureRecyclerAdapter mPictureAdapter;
    private String mPictureType;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;

    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;
    private boolean mIsLoading = true;

    public PictureContentFragment(){
        init(Constants.LASTEST);
    }


    public PictureContentFragment(String type) {
        init(type);
    }

    private void init(String type) {
        mPictureType = type;
        mLayoutManager = new LinearLayoutManager(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture_content, container, false);
        ButterKnife.bind(this, view);

        mPictureAdapter = new PictureRecyclerAdapter(mContext, mPictureType);
        mRvPictures.setLayoutManager(mLayoutManager);
        mRvPictures.setAdapter(mPictureAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvPictures.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                if (mIsLoading) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        Log.v("...", "Last Item Wow !");
                        mPictureAdapter.nextLoad();
                    }
                }
            }
        });


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mContext = activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
