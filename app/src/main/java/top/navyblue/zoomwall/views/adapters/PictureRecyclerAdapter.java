package top.navyblue.zoomwall.views.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.models.bean.Pictures;

/**
 * Created by CIR on 8/9/15.
 */
public class PictureRecyclerAdapter extends RecyclerView.Adapter<PictureRecyclerAdapter.PictureViewHolder>
        implements View.OnClickListener {
    public static final String TAG = "PictureRecyclerAdapter";

    private LayoutInflater mInflater;
    private Context mContext;
    private Pictures mPictures;
    private List<Pictures.Picture> mPictureList;

    public PictureRecyclerAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPictureList = new ArrayList<Pictures.Picture>();
    }

    public void setFirstPage(List<Pictures.Picture> pictureList){
        mPictureList = pictureList;
        notifyDataSetChanged();
    }

    public void addNextPage(List<Pictures.Picture> pictureList){
        mPictureList.addAll(pictureList);
        notifyDataSetChanged();
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_picture, parent, false);
        view.setOnClickListener(this);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Pictures.Picture picture = mPictureList.get(position);
        holder.mPicture = picture;
        holder.view.setTag(holder);

        Uri uri = Uri.parse(picture.getUrl());
        Log.e(TAG, picture.getUrl());

        holder.mSdvPicture.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mPictureList == null?0:mPictureList.size();
    }

    @Override
    public void onClick(View v) {
        PictureViewHolder holder = (PictureViewHolder) v.getTag();
        mOnPictureClickListener.onPictureClick(v, holder);
    }

    public interface OnPictureClickListener{
        void onPictureClick(View pictureView, PictureViewHolder holder);
    }

    private OnPictureClickListener mOnPictureClickListener;

    public void setOnPictureClickListener(OnPictureClickListener onPictureClickListener){
        mOnPictureClickListener = onPictureClickListener;
    }

    public static class PictureViewHolder extends RecyclerView.ViewHolder {

        private View view;

        @Bind(R.id.sdv_picture)
        public SimpleDraweeView mSdvPicture;
        public Pictures.Picture mPicture;

        public PictureViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            ButterKnife.bind(this, itemView);
        }
    }
}
