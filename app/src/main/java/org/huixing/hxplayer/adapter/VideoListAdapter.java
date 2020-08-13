package org.huixing.hxplayer.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import org.huixing.hxplayer.R;
import org.huixing.hxplayer.bean.VideoListBean;

/**
 * Created by doudou on 2017/8/4.
 */

public class VideoListAdapter extends BaseQuickAdapter<VideoListBean, BaseViewHolder> {

    public VideoListAdapter(@Nullable List<VideoListBean> data) {
        super(R.layout.video_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoListBean item) {
        helper.setImageDrawable(R.id.iv_cover, item.getCover())
                .setText(R.id.tv_video_name, item.getVideoName());
    }
}