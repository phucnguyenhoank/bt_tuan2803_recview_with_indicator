package com.example.bt_tuan2803_recview_with_indicator;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final float DP;
    private final Paint paintActive;
    private final Paint paintInactive;

    public LinePagerIndicatorDecoration(Activity activity) {
        // Get the screen density from the activity's resources.
        DP = activity.getResources().getDisplayMetrics().density;

        // Setup the paint for the active indicator
        paintActive = new Paint();
        paintActive.setColor(activity.getResources().getColor(android.R.color.holo_blue_light));
        paintActive.setAntiAlias(true);

        // Setup the paint for inactive indicators
        paintInactive = new Paint();
        paintInactive.setColor(activity.getResources().getColor(android.R.color.darker_gray));
        paintInactive.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getAdapter() == null) {
            return;
        }
        int itemCount = parent.getAdapter().getItemCount();
        if (itemCount == 0) return;

        // Dimensions for the indicator lines
        float indicatorWidth = 16 * DP;
        float indicatorHeight = 4 * DP;
        float padding = 8 * DP;
        float totalIndicatorWidth = itemCount * indicatorWidth + (itemCount - 1) * padding;
        float startX = (parent.getWidth() - totalIndicatorWidth) / 2f;
        float posY = parent.getHeight() - indicatorHeight - (8 * DP);

        // Determine the active item position.
        int activePosition = 0;
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            activePosition = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        }

        // Draw each indicator.
        for (int i = 0; i < itemCount; i++) {
            float x = startX + i * (indicatorWidth + padding);
            RectF rect = new RectF(x, posY, x + indicatorWidth, posY + indicatorHeight);
            canvas.drawRoundRect(rect, indicatorHeight / 2, indicatorHeight / 2,
                    i == activePosition ? paintActive : paintInactive);
        }
    }
}
