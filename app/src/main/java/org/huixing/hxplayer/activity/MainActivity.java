package org.huixing.hxplayer.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.huixing.hxplayer.R;
import org.huixing.hxplayer.adapter.VideoListAdapter;
import org.huixing.hxplayer.bean.VideoInfoBean;
import org.huixing.hxplayer.bean.VideoListBean;
import org.huixing.hxplayer.utils.CacheUtils;
import org.huixing.hxplayer.utils.FileUtils;

public class MainActivity extends AppCompatActivity {
    private List<VideoListBean> videoList = new ArrayList<VideoListBean>();
    private List<VideoInfoBean> videoInfo = new ArrayList<VideoInfoBean>();
    private VideoListAdapter videoListAdapter;
    private RecyclerView rv_video_list;

    public static final String VIDEOPATH = "videoPath";
    public static final String VIDEONAME = "videoName";
    public static final String VIDEOPOSITION = "videoPosition";
    public static final String VIDEOIBFO = "videoInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

//        String path = "/private/VideoManual";
//        boolean fileExists = FileUtils.isFileExists(path);
//
//        if(fileExists){
//            List<File> files = FileUtils.listFilesInDir(path);
//            videoList.clear();
//            for (int i = 0;i<files.size();i++){
//                VideoListBean videoListBean = new VideoListBean();
//                VideoInfoBean videoInfoBean = new VideoInfoBean();
//                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
//                mediaMetadataRetriever.setDataSource(files.get(i).getPath());
//
//                String videoLength = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
//                videoListBean.setVideoLength(videoLength);
//                videoListBean.setVideoName(files.get(i).getName());
//                videoListBean.setVideoPath(files.get(i).getPath());
//                Bitmap bitmap = mediaMetadataRetriever.getFrameAtTime(20000*1000);
//                Drawable drawable= new BitmapDrawable(bitmap);
//                videoListBean.setCover(drawable);
//                videoList.add(videoListBean);
//
//                videoInfoBean.setVideoName(files.get(i).getName());
//                videoInfoBean.setVideoPath(files.get(i).getPath());
//                videoInfo.add(videoInfoBean);
//            }
//
//            CacheUtils.getInstance().put(VIDEOIBFO, (Serializable) videoInfo);
//        }else {
//            Toast.makeText(this,"暂无视频！！！！！",Toast.LENGTH_SHORT).show();
//        }

        VideoListBean videoListBean = new VideoListBean();
        VideoInfoBean videoInfoBean = new VideoInfoBean();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Map headers = new HashMap<String, String>();
        mediaMetadataRetriever.setDataSource("http://vfx.mtime.cn/Video/2017/09/25/mp4/170925123208193177.mp4", headers);

        String videoLength = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        videoListBean.setVideoLength(videoLength);
        videoListBean.setVideoName("naza");
        videoListBean.setVideoPath("http://vfx.mtime.cn/Video/2017/09/25/mp4/170925123208193177.mp4");
        Bitmap bitmap = mediaMetadataRetriever.getFrameAtTime(20000*1000);
        Drawable drawable= new BitmapDrawable(bitmap);
        videoListBean.setCover(drawable);
        videoList.add(videoListBean);

        videoInfoBean.setVideoName("naza");
        videoInfoBean.setVideoPath("http://vfx.mtime.cn/Video/2017/09/25/mp4/170925123208193177.mp4");
        videoInfo.add(videoInfoBean);
        CacheUtils.getInstance().put(VIDEOIBFO, (Serializable) videoInfo);

        if (videoListAdapter == null) {
            videoListAdapter = new VideoListAdapter(videoList);
        }
        rv_video_list.setLayoutManager(new GridLayoutManager(this,3));
        rv_video_list.setAdapter(videoListAdapter);

        videoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                intent.putExtra(VIDEOPATH,videoList.get(position).getVideoPath());
                intent.putExtra(VIDEONAME,videoList.get(position).getVideoName());
                intent.putExtra(VIDEOPOSITION,position);

                startActivity(intent);
            }
        });
    }

    private void findView() {
        rv_video_list  = (RecyclerView) findViewById(R.id.rv_video_list);
    }
}