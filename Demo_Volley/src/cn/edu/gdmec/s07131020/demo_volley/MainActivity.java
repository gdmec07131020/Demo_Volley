package cn.edu.gdmec.s07131020.demo_volley;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
 //    private TextView tv;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView=(NetworkImageView)findViewById(R.id.imageView);
//		tv=(TextView) findViewById(R.id.textView);
//		
//		RequestQueue queue=Volley.newRequestQueue(this);
//	    StringRequest request=new StringRequest("http://www.baidu.com", new Listener<String>(){
//
//			@Override
//			public void onResponse(String response) {
//				// TODO Auto-generated method stub
//				tv.setText(response);
//			}
//	    	
//	    }, new ErrorListener(){
//	    		
//				public void onErrorResponse(VolleyError error) {
//					// TODO Auto-generated method stub
//			Log.i("info",error.getMessage());	
//				}
//	
//	    });
//	    queue.add(request);
		
		
	}

	public void doClick(View v){
		String url="http://avatar.csdn.net/6/6/D/1_lfdhl.jpg";
		RequestQueue requestQueue=Volley.newRequestQueue(this);
	    final LruCache<String,Bitmap> lruCache=new LruCache<String,Bitmap>(5);
	    
	    ImageCache imageCache=new ImageCache(){

			@Override
			public Bitmap getBitmap(String url) {
				// TODO Auto-generated method stub
				return lruCache.get(url);
			}

			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				// TODO Auto-generated method stub
				lruCache.put(url,bitmap);
			}};
			
			ImageLoader imageLoader=new ImageLoader(requestQueue,imageCache);
	        ((NetworkImageView) imageView).setImageUrl(url,imageLoader);
	}

}
