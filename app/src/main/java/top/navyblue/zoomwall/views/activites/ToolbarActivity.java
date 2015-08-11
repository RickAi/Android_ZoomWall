package top.navyblue.zoomwall.views.activites;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;

public abstract class ToolbarActivity extends AppCompatActivity {

    abstract protected int getLayoutResource();

    public void onToolbarClick() {}

    protected AppBarLayout mAppBar;
    protected Toolbar mToolbar;

    protected boolean isHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mAppBar = ButterKnife.findById(this, R.id.app_bar_layout);
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (mToolbar == null || mAppBar == null) {
            throw new IllegalStateException("no toolbar");
        }

        mToolbar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onToolbarClick();
                    }
                }
        );

        setSupportActionBar(mToolbar);

        if (Build.VERSION.SDK_INT >= 21) {
            mAppBar.setElevation(10.6f);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    protected void setAppBarAlpha(float alpha) {
        mAppBar.setAlpha(alpha);
    }

    protected void hideOrShowToolbar() {
        mAppBar.animate()
               .translationY(isHidden ? 0 : -mAppBar.getHeight())
               .setInterpolator(new DecelerateInterpolator(2))
               .start();

        isHidden = !isHidden;
    }
}
