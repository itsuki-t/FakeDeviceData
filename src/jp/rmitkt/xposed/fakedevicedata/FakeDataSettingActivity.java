package jp.rmitkt.xposed.fakedevicedata;

import de.robv.android.xposed.XposedBridge;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class FakeDataSettingActivity extends ActionBarActivity implements OnCheckedChangeListener {

	private EditText edt_fake_board;
	private EditText edt_fake_bootloader;
	private EditText edt_fake_brand;
	private EditText edt_fake_cpu_abi;
	private EditText edt_fake_cpu_abi2;
	private EditText edt_fake_device;
	private EditText edt_fake_display;
	private EditText edt_fake_fingerprint;
	private EditText edt_fake_hardware;
	private EditText edt_fake_host;
	private EditText edt_fake_id;
	private EditText edt_fake_manufacturer;
	private EditText edt_fake_model;
	private EditText edt_fake_product;
	private EditText edt_fake_radio;
	private EditText edt_fake_tags;
	private EditText edt_fake_time;
	private EditText edt_fake_type;
	private EditText edt_fake_user;
	private EditText edt_fake_codename;
	private EditText edt_fake_incremental;
	private EditText edt_fake_release;
	private EditText edt_fake_sdk;
	private EditText edt_fake_sdk_int;
	private CheckBox cb_fake_board;
	private CheckBox cb_fake_bootloader;
	private CheckBox cb_fake_brand;
	private CheckBox cb_fake_cpu_abi;
	private CheckBox cb_fake_cpu_abi2;
	private CheckBox cb_fake_device;
	private CheckBox cb_fake_display;
	private CheckBox cb_fake_fingerprint;
	private CheckBox cb_fake_hardware;
	private CheckBox cb_fake_host;
	private CheckBox cb_fake_id;
	private CheckBox cb_fake_manufacturer;
	private CheckBox cb_fake_model;
	private CheckBox cb_fake_product;
	private CheckBox cb_fake_radio;
	private CheckBox cb_fake_tags;
	private CheckBox cb_fake_time;
	private CheckBox cb_fake_type;
	private CheckBox cb_fake_user;
	private CheckBox cb_fake_codename;
	private CheckBox cb_fake_incremental;
	private CheckBox cb_fake_release;
	private CheckBox cb_fake_sdk;
	private CheckBox cb_fake_sdk_int;

	SharedPreferences pref;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.settings);
		pref = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);

		// get views
		edt_fake_board = (EditText) findViewById(R.id.edt_fake_board);
		edt_fake_bootloader = (EditText) findViewById(R.id.edt_fake_bootloader);
		edt_fake_brand = (EditText) findViewById(R.id.edt_fake_brand);
		edt_fake_cpu_abi = (EditText) findViewById(R.id.edt_fake_cpu_abi);
		edt_fake_cpu_abi2 = (EditText) findViewById(R.id.edt_fake_cpu_abi2);
		edt_fake_device = (EditText) findViewById(R.id.edt_fake_device);
		edt_fake_display = (EditText) findViewById(R.id.edt_fake_display);
		edt_fake_fingerprint = (EditText) findViewById(R.id.edt_fake_fingerprint);
		edt_fake_hardware = (EditText) findViewById(R.id.edt_fake_hardware);
		edt_fake_host = (EditText) findViewById(R.id.edt_fake_host);
		edt_fake_id = (EditText) findViewById(R.id.edt_fake_id);
		edt_fake_manufacturer = (EditText) findViewById(R.id.edt_fake_manufacturer);
		edt_fake_model = (EditText) findViewById(R.id.edt_fake_model);
		edt_fake_product = (EditText) findViewById(R.id.edt_fake_product);
		edt_fake_radio = (EditText) findViewById(R.id.edt_fake_radio);
		edt_fake_tags = (EditText) findViewById(R.id.edt_fake_tags);
		edt_fake_time = (EditText) findViewById(R.id.edt_fake_time);
		edt_fake_type = (EditText) findViewById(R.id.edt_fake_type);
		edt_fake_user = (EditText) findViewById(R.id.edt_fake_user);
		edt_fake_codename = (EditText) findViewById(R.id.edt_fake_codename);
		edt_fake_incremental = (EditText) findViewById(R.id.edt_fake_incremental);
		edt_fake_release = (EditText) findViewById(R.id.edt_fake_release);
		edt_fake_sdk = (EditText) findViewById(R.id.edt_fake_sdk);
		edt_fake_sdk_int = (EditText) findViewById(R.id.edt_fake_sdk_int);
		cb_fake_board = (CheckBox) findViewById(R.id.cb_fake_board);
		cb_fake_bootloader = (CheckBox) findViewById(R.id.cb_fake_bootloader);
		cb_fake_brand = (CheckBox) findViewById(R.id.cb_fake_brand);
		cb_fake_cpu_abi = (CheckBox) findViewById(R.id.cb_fake_cpu_abi);
		cb_fake_cpu_abi2 = (CheckBox) findViewById(R.id.cb_fake_cpu_abi2);
		cb_fake_device = (CheckBox) findViewById(R.id.cb_fake_device);
		cb_fake_display = (CheckBox) findViewById(R.id.cb_fake_display);
		cb_fake_fingerprint = (CheckBox) findViewById(R.id.cb_fake_fingerprint);
		cb_fake_hardware = (CheckBox) findViewById(R.id.cb_fake_hardware);
		cb_fake_host = (CheckBox) findViewById(R.id.cb_fake_host);
		cb_fake_id = (CheckBox) findViewById(R.id.cb_fake_id);
		cb_fake_manufacturer = (CheckBox) findViewById(R.id.cb_fake_manufacturer);
		cb_fake_model = (CheckBox) findViewById(R.id.cb_fake_model);
		cb_fake_product = (CheckBox) findViewById(R.id.cb_fake_product);
		cb_fake_radio = (CheckBox) findViewById(R.id.cb_fake_radio);
		cb_fake_tags = (CheckBox) findViewById(R.id.cb_fake_tags);
		cb_fake_time = (CheckBox) findViewById(R.id.cb_fake_time);
		cb_fake_type = (CheckBox) findViewById(R.id.cb_fake_type);
		cb_fake_user = (CheckBox) findViewById(R.id.cb_fake_user);
		cb_fake_codename = (CheckBox) findViewById(R.id.cb_fake_codename);
		cb_fake_incremental = (CheckBox) findViewById(R.id.cb_fake_incremental);
		cb_fake_release = (CheckBox) findViewById(R.id.cb_fake_release);
		cb_fake_sdk = (CheckBox) findViewById(R.id.cb_fake_sdk);
		cb_fake_sdk_int = (CheckBox) findViewById(R.id.cb_fake_sdk_int);

		// set listener for changes
		cb_fake_board.setOnCheckedChangeListener(this);
		cb_fake_bootloader.setOnCheckedChangeListener(this);
		cb_fake_brand.setOnCheckedChangeListener(this);
		cb_fake_cpu_abi.setOnCheckedChangeListener(this);
		cb_fake_cpu_abi2.setOnCheckedChangeListener(this);
		cb_fake_device.setOnCheckedChangeListener(this);
		cb_fake_display.setOnCheckedChangeListener(this);
		cb_fake_fingerprint.setOnCheckedChangeListener(this);
		cb_fake_hardware.setOnCheckedChangeListener(this);
		cb_fake_host.setOnCheckedChangeListener(this);
		cb_fake_id.setOnCheckedChangeListener(this);
		cb_fake_manufacturer.setOnCheckedChangeListener(this);
		cb_fake_model.setOnCheckedChangeListener(this);
		cb_fake_product.setOnCheckedChangeListener(this);
		cb_fake_radio.setOnCheckedChangeListener(this);
		cb_fake_tags.setOnCheckedChangeListener(this);
		cb_fake_time.setOnCheckedChangeListener(this);
		cb_fake_type.setOnCheckedChangeListener(this);
		cb_fake_user.setOnCheckedChangeListener(this);
		cb_fake_codename.setOnCheckedChangeListener(this);
		cb_fake_incremental.setOnCheckedChangeListener(this);
		cb_fake_release.setOnCheckedChangeListener(this);
		cb_fake_sdk.setOnCheckedChangeListener(this);
		cb_fake_sdk_int.setOnCheckedChangeListener(this);

		// Set current fake values
		setValue("fake_board", cb_fake_board, edt_fake_board ,1);
		setValue("fake_bootloader", cb_fake_bootloader, edt_fake_bootloader ,1);
		setValue("fake_brand", cb_fake_brand, edt_fake_brand ,1);
		setValue("fake_cpu_abi", cb_fake_cpu_abi, edt_fake_cpu_abi ,1);
		setValue("fake_cpu_abi2", cb_fake_cpu_abi2, edt_fake_cpu_abi2 ,1);
		setValue("fake_device", cb_fake_device, edt_fake_device ,1);
		setValue("fake_display", cb_fake_display, edt_fake_display ,1);
		setValue("fake_fingerprint", cb_fake_fingerprint, edt_fake_fingerprint ,1);
		setValue("fake_hardware", cb_fake_hardware, edt_fake_hardware ,1);
		setValue("fake_host", cb_fake_host, edt_fake_host ,1);
		setValue("fake_id", cb_fake_id, edt_fake_id ,1);
		setValue("fake_manufacturer", cb_fake_manufacturer, edt_fake_manufacturer ,1);
		setValue("fake_model", cb_fake_model, edt_fake_model ,1);
		setValue("fake_product", cb_fake_product, edt_fake_product ,1);
		setValue("fake_radio", cb_fake_radio, edt_fake_radio ,1);
		setValue("fake_tags", cb_fake_tags, edt_fake_tags ,1);
		setValue("fake_time", cb_fake_time, edt_fake_time ,2);
		setValue("fake_type", cb_fake_type, edt_fake_type ,1);
		setValue("fake_user", cb_fake_user, edt_fake_user ,1);
		setValue("fake_codename", cb_fake_codename, edt_fake_codename ,1);
		setValue("fake_incremental", cb_fake_incremental, edt_fake_incremental ,1);
		setValue("fake_release", cb_fake_release, edt_fake_release ,1);
		setValue("fake_sdk", cb_fake_sdk, edt_fake_sdk ,1);
		setValue("fake_sdk_int", cb_fake_sdk_int, edt_fake_sdk_int ,3);
	}

	@Override
	public void onBackPressed(){
		Toast.makeText(getApplicationContext(), R.string.settings_fake_saved, Toast.LENGTH_LONG).show();
		saveFakeSetting();
		finish();
	}

	@Override  
	public boolean onOptionsItemSelected(MenuItem item) {  
	    switch(item.getItemId()) {  
	        case android.R.id.home:
	    		Toast.makeText(getApplicationContext(), R.string.settings_fake_saved, Toast.LENGTH_LONG).show();
	    		saveFakeSetting();
	            finish();
	            return true;  
	    }  
	    return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.cb_fake_board:
			edt_fake_board.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_bootloader:
			edt_fake_bootloader.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_brand:
			edt_fake_brand.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_cpu_abi:
			edt_fake_cpu_abi.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_cpu_abi2:
			edt_fake_cpu_abi2.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_device:
			edt_fake_device.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_display:
			edt_fake_display.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_fingerprint:
			edt_fake_fingerprint.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_hardware:
			edt_fake_hardware.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_host:
			edt_fake_host.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_id:
			edt_fake_id.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_manufacturer:
			edt_fake_manufacturer.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_model:
			edt_fake_model.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_product:
			edt_fake_product.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_radio:
			edt_fake_radio.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_tags:
			edt_fake_tags.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_time:
			edt_fake_time.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_type:
			edt_fake_type.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_user:
			edt_fake_user.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_codename:
			edt_fake_codename.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_incremental:
			edt_fake_incremental.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_release:
			edt_fake_release.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_sdk:
			edt_fake_sdk.setEnabled(!isChecked);
			break;
		case R.id.cb_fake_sdk_int:
			edt_fake_sdk_int.setEnabled(!isChecked);
			break;
		default:
			break;
		}
	}

	private void saveFakeSetting(){
		Editor editor = pref.edit();
		editor.putBoolean("fake_board_key", cb_fake_board.isChecked());
		editor.putBoolean("fake_bootloader_key", cb_fake_bootloader.isChecked());
		editor.putBoolean("fake_brand_key", cb_fake_brand.isChecked());
		editor.putBoolean("fake_cpu_abi_key", cb_fake_cpu_abi.isChecked());
		editor.putBoolean("fake_cpu_abi2_key", cb_fake_cpu_abi2.isChecked());
		editor.putBoolean("fake_device_key", cb_fake_device.isChecked());
		editor.putBoolean("fake_display_key", cb_fake_display.isChecked());
		editor.putBoolean("fake_fingerprint_key", cb_fake_fingerprint.isChecked());
		editor.putBoolean("fake_hardware_key", cb_fake_hardware.isChecked());
		editor.putBoolean("fake_host_key", cb_fake_host.isChecked());
		editor.putBoolean("fake_id_key", cb_fake_id.isChecked());
		editor.putBoolean("fake_manufacturer_key", cb_fake_manufacturer.isChecked());
		editor.putBoolean("fake_model_key", cb_fake_model.isChecked());
		editor.putBoolean("fake_product_key", cb_fake_product.isChecked());
		editor.putBoolean("fake_radio_key", cb_fake_radio.isChecked());
		editor.putBoolean("fake_tags_key", cb_fake_tags.isChecked());
		editor.putBoolean("fake_time_key", cb_fake_time.isChecked());
		editor.putBoolean("fake_type_key", cb_fake_type.isChecked());
		editor.putBoolean("fake_user_key", cb_fake_user.isChecked());
		editor.putBoolean("fake_codename_key", cb_fake_codename.isChecked());
		editor.putBoolean("fake_incremental_key", cb_fake_incremental.isChecked());
		editor.putBoolean("fake_release_key", cb_fake_release.isChecked());
		editor.putBoolean("fake_sdk_key", cb_fake_sdk.isChecked());
		editor.putBoolean("fake_sdk_int_key", cb_fake_sdk_int.isChecked());
		editor.putString("fake_board_value", edt_fake_board.getText().toString().trim());
		editor.putString("fake_bootloader_value", edt_fake_bootloader.getText().toString().trim());
		editor.putString("fake_brand_value", edt_fake_brand.getText().toString().trim());
		editor.putString("fake_cpu_abi_value", edt_fake_cpu_abi.getText().toString().trim());
		editor.putString("fake_cpu_abi2_value", edt_fake_cpu_abi2.getText().toString().trim());
		editor.putString("fake_device_value", edt_fake_device.getText().toString().trim());
		editor.putString("fake_display_value", edt_fake_display.getText().toString().trim());
		editor.putString("fake_fingerprint_value", edt_fake_fingerprint.getText().toString().trim());
		editor.putString("fake_hardware_value", edt_fake_hardware.getText().toString().trim());
		editor.putString("fake_host_value", edt_fake_host.getText().toString().trim());
		editor.putString("fake_id_value", edt_fake_id.getText().toString().trim());
		editor.putString("fake_manufacturer_value", edt_fake_manufacturer.getText().toString().trim());
		editor.putString("fake_model_value", edt_fake_model.getText().toString().trim());
		editor.putString("fake_product_value", edt_fake_product.getText().toString().trim());
		editor.putString("fake_radio_value", edt_fake_radio.getText().toString().trim());
		editor.putString("fake_tags_value", edt_fake_tags.getText().toString().trim());
		if(!(edt_fake_time.getText().toString()).equalsIgnoreCase("")){
			editor.putLong("fake_time_value", Long.parseLong(edt_fake_time.getText().toString().trim()));
		}
		editor.putString("fake_type_value", edt_fake_type.getText().toString().trim());
		editor.putString("fake_user_value", edt_fake_user.getText().toString().trim());
		editor.putString("fake_codename_value", edt_fake_codename.getText().toString().trim());
		editor.putString("fake_incremental_value", edt_fake_incremental.getText().toString().trim());
		editor.putString("fake_release_value", edt_fake_release.getText().toString().trim());
		editor.putString("fake_sdk_value", edt_fake_sdk.getText().toString().trim());
		if(!(edt_fake_sdk_int.getText().toString()).equalsIgnoreCase("") ){
			editor.putInt("fake_sdk_int_value", Integer.parseInt(edt_fake_sdk_int.getText().toString().trim()));
		}
		editor.apply();
	}

	private void setValue(String name, CheckBox check, EditText edit, int type) {
		switch (type){
		case 1:
			check.setChecked(pref.getBoolean(name+"_key", false));
			edit.setText(pref.getString(name+"_value", ""));
			edit.setEnabled(!check.isChecked());
			break;
		case 2:
			check.setChecked(pref.getBoolean(name+"_key", false));
			if(pref.getLong(name+"_value", 0) != 0){
				edit.setText(Long.toString(pref.getLong(name+"_value", 0)));
			}
			edit.setEnabled(!check.isChecked());
			break;
		case 3:
			check.setChecked(pref.getBoolean(name+"_key", false));
			if(pref.getInt(name+"_value", 0) != 0){
				edit.setText(Integer.toString(pref.getInt(name+"_value", 0)));
			}
			edit.setEnabled(!check.isChecked());
			break;
		default:
			break;
		}
	}
}
