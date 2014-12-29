package jp.rmitkt.xposed.fakedevicedata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.afollestad.materialdialogs.*;
import com.afollestad.materialdialogs.MaterialDialog.Callback;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {
	class PInfo {
		private String appname = "";
		private String pname = "";
	}

	SharedPreferences pref;  
	ListView app_list;
	ArrayList<PInfo> pinfos;
	PInfo pinfo;
	private AsyncTask<Void, Void, ArrayList<PInfo>> mAsyncTask;
	private ProgressDialog mProgressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final FloatingActionsMenu menu = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
		final FloatingActionButton actionSave = (FloatingActionButton) findViewById(R.id.action_save);
		actionSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				save(view);
				menu.collapse();
			}
		});
		final FloatingActionButton actionReset = (FloatingActionButton) findViewById(R.id.action_reset);
		actionReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				selectAll(view);
				invert(view);
				menu.collapse();
				Toast.makeText(getApplicationContext(), R.string.reset_message, Toast.LENGTH_LONG).show();
			}
		});
		final FloatingActionButton actionFakeData = (FloatingActionButton) findViewById(R.id.action_fakedata);
		actionFakeData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), FakeDataSettingActivity.class);
				startActivity(intent);
				menu.collapse();
			}
		});

		pref = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);
		app_list = (ListView) findViewById(R.id.appList);
		setAppList();
}

	public ArrayList<PInfo> getInstalledApps(boolean getSysPackages){
		ArrayList<PInfo> res = new ArrayList<PInfo>();        
		List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
		for (int i = 0; i < packs.size(); i++){
			PackageInfo p = packs.get(i);
			if ((!getSysPackages) && (p.versionName == null)){
				continue;
			}
			PInfo newInfo = new PInfo();
			newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
			newInfo.pname = p.packageName;
			res.add(newInfo);
		}
		return res;
	}

	public void save(View v){
		Editor editor = pref.edit();
		for (int i = 0; i < pinfos.size(); i++){
			editor.putBoolean(pinfos.get(i).pname, app_list.isItemChecked(i));
		}
		editor.apply();
		Toast.makeText(this, R.string.save_message, Toast.LENGTH_LONG).show();
		finish();
	}

	public void invert(View v){
		for (int i = 0; i < pinfos.size(); i++){
			app_list.setItemChecked(i, !app_list.isItemChecked(i));
		}
	}

	public void selectAll(View v){
		for (int i = 0; i < pinfos.size(); i++)      
			app_list.setItemChecked(i, true);
	}

	public void load(){
		for (int i = 0; i < pinfos.size(); i++){
			app_list.setItemChecked(i, pref.getBoolean(pinfos.get(i).pname, false));
		}
	}

	public void appExit(){
		finish();
	}

	@Override
	public void onBackPressed(){
		exitPrompt();
	}

	public void exitPrompt(){
		new MaterialDialog.Builder(this)
        .title(R.string.save_prompt_title)
        .content(R.string.save_prompt_message)
        .positiveText(R.string.save_prompt_positive)
        .positiveColorRes(R.color.bluegrey500)
        .negativeText(R.string.save_prompt_negative)
        .negativeColorRes(R.color.bluegrey500)
        .callback(new Callback() {
            @Override
            public void onPositive(MaterialDialog dialog) {
            }
            @Override
            public void onNegative(MaterialDialog dialog) {
        		finish();
            }
        })
        .build().show();
	}

	private void setAppList(){
		mAsyncTask = new AsyncTask<Void,Void,ArrayList<PInfo>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showProgressDialog();
            }
            
            @Override
            protected ArrayList<PInfo> doInBackground(Void... arg0) {
            	ArrayList<PInfo> res = new ArrayList<PInfo>();        
            	List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
            	for (int i = 0; i < packs.size(); i++){
            		PackageInfo p = packs.get(i);
            		if (p.versionName == null){
            			continue;
            		}
            		PInfo newInfo = new PInfo();
            		newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
            		newInfo.pname = p.packageName;
            		res.add(newInfo);
            	}
            	return res;
            }
        		
            @Override
            protected void onCancelled() {
            	dismissProgressDialog();
            }
            
            @Override
            protected void onPostExecute(ArrayList<PInfo> result) {
                dismissProgressDialog();
                pinfos = result;
        		Collections.sort(pinfos, new Comparator<PInfo>(){
        			@Override
        			public int compare(PInfo lhs, PInfo rhs){
        				return lhs.appname.compareTo(rhs.appname);
        			}
        		});

        		//add apps to installed_apps list
        		ArrayList<String> installed_apps = new ArrayList<String>();
        		for (int i = 0; i < pinfos.size(); i++){
        			installed_apps.add(pinfos.get(i).appname);
        		}

        		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        				MainActivity.this, 
        				android.R.layout.simple_list_item_multiple_choice,
        				installed_apps);
        		app_list.setAdapter(adapter);

        		app_list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        		load();
            }

            
		}.execute();
	}
	
    private void showProgressDialog() {
        mProgressDialog = new ProgressDialog(MainActivity.this);
    	mProgressDialog.setMessage(getString(R.string.app_loading_message));
    	mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setOnCancelListener(new OnCancelListener() {
        	@Override
        	public void onCancel(DialogInterface dialog) {
        		Toast.makeText(getApplicationContext(), R.string.app_loading_cancel, Toast.LENGTH_SHORT).show();
        		finish();
        	}
        });
        mProgressDialog.show();
    }

    private void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;        
    }

}
