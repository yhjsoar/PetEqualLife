package com.example.petequallife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TextViewPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private Context mContext = null;
    private String text1, text2;

    public TextViewPagerAdapter(Context context, String text1, String text2){
        mContext = context;
        this.text1 = text1;
        this.text2 = text2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null ;

        if (mContext != null) {
            // LayoutInflater를 통해 "/res/layout/page.xml"을 뷰로 생성.
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.page, container, false);

            TextView textView = (TextView) view.findViewById(R.id.title) ;
            ImageView imageView = (ImageView)view.findViewById(R.id.pagerimg);
            switch (position){
                case 0:
                    textView.setText(text1);
                    imageView.setImageResource(R.drawable.pager1);
                    break;
                case 1:
                    textView.setText(text2);
                    imageView.setImageResource(R.drawable.pager2);
                    break;
            }
        }

        // 뷰페이저에 추가.
        container.addView(view) ;

        return view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 뷰페이저에서 삭제.
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // 전체 페이지 수는 2개로 고정.
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
