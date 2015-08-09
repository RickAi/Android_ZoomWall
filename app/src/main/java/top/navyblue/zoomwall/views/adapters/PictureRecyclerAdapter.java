package top.navyblue.zoomwall.views.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.managers.DataLoader;
import top.navyblue.zoomwall.managers.volley.RequestListener;
import top.navyblue.zoomwall.models.bean.Pictures;

/**
 * Created by CIR on 8/9/15.
 */
public class PictureRecyclerAdapter extends RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder> {
    public static final String TAG = "PictureRecyclerAdapter";

    private LayoutInflater mInflater;
    private Context mContext;
    private Pictures mPictures;
    private List<Pictures.Picture> mPictureList;
    private String mType;
    private Gson mGson;

    public PictureRecyclerAdapter(Context context, String type) {
        mContext = context;
        mType = type;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mGson = new Gson();

        firstLoad();
    }

    private void firstLoad() {
        DataLoader.loadPictures(mType, null, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                mPictures = mGson.fromJson(json, Pictures.class);
                mPictureList = mPictures.getData();
                notifyDataSetChanged();
            }

            @Override
            public void requestError(VolleyError e) {

            }
        });
    }


    public void nextLoad() {
        String nextPageUrl = mPictures.getNext_page_url();
        DataLoader.loadPictures(mType, nextPageUrl, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                mPictures = mGson.fromJson(json, Pictures.class);
                mPictureList.addAll(mPictures.getData());
                mPictures.setData(mPictureList);
                notifyDataSetChanged();
            }

            @Override
            public void requestError(VolleyError e) {

            }
        });
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureViewHolder(mInflater.inflate(R.layout.item_picture, parent, false));
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Pictures.Picture picture = mPictureList.get(position);

        Uri uri = Uri.parse(picture.getUrl());
        Log.e(TAG, picture.getUrl());

        holder.mSdvPicture.setImageURI(uri);
        holder.mTvCreatedAt.setText(picture.getCreated_at());
    }

    @Override
    public int getItemCount() {
        return mPictureList == null?0:mPictureList.size();
    }

    public static class PictureViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.sdv_picture)
        SimpleDraweeView mSdvPicture;
        @Bind(R.id.tv_created_at)
        TextView mTvCreatedAt;

        public PictureViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
