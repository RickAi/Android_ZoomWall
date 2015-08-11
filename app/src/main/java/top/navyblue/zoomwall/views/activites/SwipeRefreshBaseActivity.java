package top.navyblue.zoomwall.views.activites;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;


/**
 * Created by drakeet on 1/3/15.
 */
public abstract class SwipeRefreshBaseActivity extends ToolbarActivity {
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        trySetupSwipeRefresh();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSwipeRefreshLayout = ButterKnife.findById(this, R.id.swipe_refresh_layout);
    }

    void trySetupSwipeRefresh() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeResources(
                    R.color.refresh_progress_3,
                    R.color.refresh_progress_2,
                    R.color.refresh_progress_1
            );
            mSwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            requestFirstPage();
                        }
                    }
            );
        }

        // init the page when first enter
        requestFirstPage();
    }

    public void requestFirstPage() {}

    public void setRefreshing(boolean refreshing) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!refreshing) {
            // 防止刷新消失太快，让子弹飞一会儿
            mSwipeRefreshLayout.postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }, 1000
            );
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }
}
